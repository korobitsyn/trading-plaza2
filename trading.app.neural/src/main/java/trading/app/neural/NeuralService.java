package trading.app.neural;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationElliott;
import org.encog.engine.network.activation.ActivationLinear;
import org.encog.engine.network.activation.ActivationTANH;
import org.encog.mathutil.randomize.ConsistentRandomizer;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.training.propagation.resilient.RPROPConst;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.neural.pattern.FeedForwardPattern;
import org.encog.persist.EncogDirectoryPersistence;
import org.encog.util.Stopwatch;
import org.encog.util.simple.EncogUtility;

import trading.app.neural.NeuralContext;
//import trading.data.MLBarDataConverter;
//import trading.data.MLBarDataLoader;
//import trading.data.model.BarEntity;
//import trading.data.model.DataPair;
//import trading.data.model.OutputEntity;

/**
 * Neural network service
 * @author pdg
 *
 */
public class NeuralService extends NeuralServiceBase {
	/**
	 * Ctor
	 */
	public NeuralService(){}
    /**
     * @see NeuralServiceBase#createNetwork(List) 
     */
	@Override
    public BasicNetwork createNetwork(List<Integer> layers) {
        if (layers.size() < 2) {
            throw new IllegalArgumentException("Wrong network layers count");
        }
        final FeedForwardPattern pattern = new FeedForwardPattern();
        // Input neurons
        int input = layers.get(0);
        pattern.setInputNeurons(input);
        // Hidden neurons
        for (int i = 1; ((i < layers.size() - 1)); i++) {
            int neurons = layers.get(i);
            if (neurons > 0) {
                pattern.addHiddenLayer(layers.get(i));
            }
        }
        // Output neurons
        int output = layers.get(layers.size() - 1);
        pattern.setOutputNeurons(output);

//        // Activation functioni
        pattern.setActivationFunction(new ActivationTANH());
//        pattern.setActivationFunction(new ActivationLinear());
//        //pattern.setActivationFunction(new ActivationElliott()); 

        // Create network
        final BasicNetwork network = (BasicNetwork) pattern.generate();
        // Randomize the network
        (new ConsistentRandomizer(-1, 1, 100)).randomize(network);
        neuralContext.setNetwork(network);

        return network;


    }
    
    /**
	 * @see NeuralServiceBase#trainNetwork()
     */
	@Override
    public void trainNetwork(){
         //MLDataSet ds = MLBarDataLoader.getTrainMLDataSet();
         //trainNetwork(ds);
    }
    
    /**
     * Train on specific dataset
     */

    public void trainNetwork(MLDataSet dataSet) throws FileNotFoundException, IOException {
        neuralContext.getTrainingContext().setLastError(0);
        neuralContext.getTrainingContext().setSamplesCount(dataSet.size());      
        BasicNetwork network = neuralContext.getNetwork();

       // Backpropagation training
        //ResilientPropagation train = new ResilientPropagation(network, ds, 0, RPROPConst.DEFAULT_MAX_STEP);
        ResilientPropagation train = new ResilientPropagation(network, dataSet);
        //Backpropagation train = new Backpropagation(network, ds);
        train.setThreadCount(10);
        neuralContext.getTrainingContext().setTrain(train);
        
        Logger.getLogger(NeuralService.class.getName()).info("Start training");
        
        // Create watches
        Stopwatch trainWatch = new Stopwatch();
        trainWatch.reset();
        trainWatch.start();
        
        Stopwatch epochWatch = new Stopwatch();
        epochWatch.reset();
        epochWatch.start();
        double lastError = 0;
        double sameErrorCount = 0;
        final int maxErrorCount = 10; // If error does not change maxErrorCount loops, training completed
        for (int epoch = 1; epoch <= neuralContext.getTrainingContext().getMaxEpochCount() && sameErrorCount <=maxErrorCount; epoch++) {
            epochWatch.reset();
            // Do training iteration
            train.iteration();
            // Calculate error
            double error = train.getError();
            // Increase error coujnt
            if(error==lastError)
            {
                sameErrorCount++;
            }else{
                sameErrorCount = 0;
                lastError = error;
            }
            // Update view
            neuralContext.getTrainingContext().setLastEpoch(epoch);
            neuralContext.getTrainingContext().setLastEpochMilliseconds(epochWatch.getElapsedMilliseconds());
            neuralContext.getTrainingContext().setTrainMilliseconds(trainWatch.getElapsedMilliseconds());
            neuralContext.getTrainingContext().setLastError(error);
            Logger.getLogger(NeuralService.class.getName()).info(String.format("Epoch %d. Time %d sec, error %s", epoch, epochWatch.getElapsedMilliseconds() / 1000, Double.toString(error)));
        }
        trainWatch.stop();
        epochWatch.stop();
        Logger.getLogger(NeuralService.class.getName()).info(String.format("Training time  %d minutes",  trainWatch.getElapsedMilliseconds() / 1000/60, Double.toString(train.getError())));
        train.finishTraining();
    }
}
