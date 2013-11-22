package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import org.encog.neural.networks.BasicNetwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import trading.app.neural.NeuralContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class NetworkPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private NeuralContext neuralContext;
	private final JFormattedTextField txtPredictionSize;
	private final JFormattedTextField txtLayers;
	private final JFileChooser fileChooser;
	private final JButton btnCreate;
	private final JButton btnLoad;	
	private final JButton btnSave;	
	private final JButton btnReset;	
	private final JFormattedTextField txtWindowSize;
	private final JFormattedTextField txtTrainSamples;
	private final JFormattedTextField txtPredictionSamples;
	private final JSpinner trainStep;
	private JLabel lblPredictionSamples;
	
	/**
	 * Create the panel.
	 */
	public NetworkPanel(NeuralContext context) {
		neuralContext = context;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel label = new JLabel("Neural Network summary");
		springLayout.putConstraint(SpringLayout.NORTH, label, 23,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label, 24,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label, 224,
				SpringLayout.WEST, this);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		add(label);

		JLabel label_1 = new JLabel("Layers:");
		springLayout.putConstraint(SpringLayout.WEST, label_1, 121,
				SpringLayout.WEST, this);
		add(label_1);

		txtLayers = new JFormattedTextField("10,10,2");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 3, SpringLayout.NORTH, txtLayers);
		springLayout.putConstraint(SpringLayout.EAST, label_1, -10, SpringLayout.WEST, txtLayers);
		springLayout.putConstraint(SpringLayout.NORTH, txtLayers, 81,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtLayers, 182,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtLayers, 100,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtLayers, 339,
				SpringLayout.WEST, this);
		txtLayers.setText("1,2,3");
		txtLayers.setAlignmentY(0.0f);
		txtLayers.setAlignmentX(0.0f);
		add(txtLayers);

		JLabel lblPredictionSize = new JLabel("Prediction size:");
		springLayout.putConstraint(SpringLayout.WEST, lblPredictionSize, 82,
				SpringLayout.WEST, this);
		add(lblPredictionSize);

		txtPredictionSize = new JFormattedTextField(new Integer(60));
		springLayout.putConstraint(SpringLayout.WEST, txtPredictionSize, 0, SpringLayout.WEST, txtLayers);
		txtPredictionSize.setText("60");
		add(txtPredictionSize);

		// Create button
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCreate, 35,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnCreate, -140,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCreate, 65,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, -50,
				SpringLayout.EAST, this);
		add(btnCreate);

		// Load button
		btnLoad = new JButton("Load");
		springLayout.putConstraint(SpringLayout.NORTH, btnLoad, 28, SpringLayout.SOUTH, btnCreate);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnLoad, -90,
				SpringLayout.EAST, btnCreate);
		springLayout.putConstraint(SpringLayout.EAST, btnLoad, 0,
				SpringLayout.EAST, btnCreate);
		add(btnLoad);

		// Save button
		btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.SOUTH, btnLoad, -17, SpringLayout.NORTH, btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 140,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 0,
				SpringLayout.WEST, btnCreate);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, 170,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, 0,
				SpringLayout.EAST, btnCreate);
		add(btnSave);

		// Reset button
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnReset, 201,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnReset, 0,
				SpringLayout.WEST, btnCreate);
		springLayout.putConstraint(SpringLayout.SOUTH, btnReset, 231,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnReset, 0,
				SpringLayout.EAST, btnCreate);
		add(btnReset);
		
		txtWindowSize = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtWindowSize, -245, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtPredictionSize, 12, SpringLayout.SOUTH, txtWindowSize);
		springLayout.putConstraint(SpringLayout.EAST, txtWindowSize, -281, SpringLayout.WEST, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, txtPredictionSize, 0, SpringLayout.EAST, txtWindowSize);
		txtWindowSize.setText("100");
		add(txtWindowSize);
		
		JLabel lblWindowSize = new JLabel("Window size:");
		springLayout.putConstraint(SpringLayout.WEST, txtWindowSize, 10, SpringLayout.EAST, lblWindowSize);
		springLayout.putConstraint(SpringLayout.NORTH, lblPredictionSize, 17, SpringLayout.SOUTH, lblWindowSize);
		springLayout.putConstraint(SpringLayout.EAST, lblPredictionSize, 0, SpringLayout.EAST, lblWindowSize);
		springLayout.putConstraint(SpringLayout.NORTH, lblWindowSize, 7, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, lblWindowSize, 0, SpringLayout.EAST, label_1);
		add(lblWindowSize);
		
		// Samples count
		txtTrainSamples = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtPredictionSize, -12, SpringLayout.NORTH, txtTrainSamples);
		springLayout.putConstraint(SpringLayout.WEST, txtTrainSamples, 0, SpringLayout.WEST, txtLayers);
		springLayout.putConstraint(SpringLayout.SOUTH, txtTrainSamples, 0, SpringLayout.SOUTH, btnReset);
		springLayout.putConstraint(SpringLayout.EAST, txtTrainSamples, -281, SpringLayout.WEST, btnReset);
		add(txtTrainSamples);
		
		JLabel lblSamplesCount = new JLabel("Train samples:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblSamplesCount, 0, SpringLayout.SOUTH, btnReset);
		springLayout.putConstraint(SpringLayout.EAST, lblSamplesCount, 0, SpringLayout.EAST, label_1);
		add(lblSamplesCount);
		
		txtPredictionSamples = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPredictionSamples, 288, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPredictionSamples, 182, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPredictionSamples, -104, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPredictionSamples, -421, SpringLayout.EAST, this);
		add(txtPredictionSamples);
		
		lblPredictionSamples = new JLabel("Prediction samples:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPredictionSamples, 0, SpringLayout.NORTH, txtPredictionSamples);
		springLayout.putConstraint(SpringLayout.EAST, lblPredictionSamples, 0, SpringLayout.EAST, lblWindowSize);
		add(lblPredictionSamples);
		
		trainStep = new JSpinner();
		trainStep.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		springLayout.putConstraint(SpringLayout.WEST, trainStep, 0, SpringLayout.WEST, txtLayers);
		springLayout.putConstraint(SpringLayout.SOUTH, trainStep, -16, SpringLayout.NORTH, txtPredictionSamples);
		springLayout.putConstraint(SpringLayout.EAST, trainStep, -421, SpringLayout.EAST, this);
		add(trainStep);
		
		JLabel lblTrainStep = new JLabel("Train step:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTrainStep, 3, SpringLayout.NORTH, trainStep);
		springLayout.putConstraint(SpringLayout.EAST, lblTrainStep, 0, SpringLayout.EAST, label_1);
		add(lblTrainStep);
		
		// File chooser
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Network config (.cfg)", "cfg"));

		updateView();
	}

	/**
	 * Reset network weights
	 */
	private void resetNetwork(){
		updateContext();
		neuralContext.getNetwork().reset();
		updateView();
	}
	
	/**
	 * Load network weights from file
	 */
	private void loadNetwork(){
		updateContext();
		// Show open dialog and open
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			neuralContext.getNeuralService().loadNetwork(fileChooser.getSelectedFile());
		}
		updateView();
	}
	
	/**
	 * Save network weights to file
	 * @return
	 */
	private void saveNetwork(){
		updateContext();
	
		// Shiw save dialog and save
		if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			if(!path.endsWith("cfg")){
				file = new File(path+".cfg");
			
			}
			neuralContext.getNeuralService().saveNetwork(file);
		}
		updateView();
	}
	
	/**
	 * Create new neural network
	 * 
	 * @throws ParseException
	 */
	private void createNetwork() {

		// int predictionInterval;
		try {
			this.txtPredictionSize.commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateContext();

		// Calculate neuron counts in layers
		List<Integer> layers = new ArrayList<Integer>();
		String[] layerStrings = txtLayers.getText().split(",");
		for (String neuronsString : layerStrings) {
			int neurons = Integer.parseInt(neuronsString);
			layers.add(neurons);
		}
		// Create network
		BasicNetwork network = neuralContext.getNeuralService().createNetwork(
				layers);
		neuralContext.setNetwork(network);

		// Update view after network creation
		updateView();
	}

	/**
	 * Update view from context
	 */
	public void updateView() {
		// Update layers from network
		String layersString = "0,0,2";
		if (neuralContext.getNetwork() != null) {
			// Update layers text
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < neuralContext.getNetwork().getLayerCount(); i++) {
				int neurons = neuralContext.getNetwork().getLayerNeuronCount(i);
				sb.append(neurons);
				sb.append(",");
			}
			layersString = sb.toString().replaceAll(",$", "");
		}
		// Text fields
		txtLayers.setText(layersString);
		txtWindowSize.setText(neuralContext.getLevel1WindowSize().toString());
		txtPredictionSize.setText(neuralContext.getPredictionSize().toString());
		txtTrainSamples.setText(neuralContext.getTrainingContext().getTrainSamples().toString());
		txtPredictionSamples.setText(neuralContext.getTrainingContext().getPredictionSamples().toString());
		// Train step spinner
		trainStep.setValue(neuralContext.getTrainingContext().getTrainStep());
		((SpinnerNumberModel)trainStep.getModel()).setMaximum(neuralContext.getLevel1WindowSize());
		
		// Buttons 
		boolean isNetworkNotNull = (neuralContext.getNetwork() != null);
		btnSave.setEnabled(isNetworkNotNull);
		btnReset.setEnabled(isNetworkNotNull);
	}

	/**
	 * Update context from this view
	 */
	public void updateContext() {
		// Update prediction interval
		int predictionInterval = Integer.parseInt(txtPredictionSize
				.getText());
		neuralContext.setPredictionSize(predictionInterval);
		// Update window size
		int windowSize = Integer.parseInt(txtWindowSize.getText());
		neuralContext.setLevel1WindowSize(windowSize);
		// Update prediction samples
		int trainSamples = Integer.parseInt(txtTrainSamples.getText());
		neuralContext.getTrainingContext().setTrainSamples(trainSamples);
		// Update train step
		neuralContext.getTrainingContext().setTrainStep((Integer)trainStep.getValue());
		
		// Update train samples
		int predictionSamples = Integer.parseInt(txtPredictionSamples.getText());		
		neuralContext.getTrainingContext().setPredictionSamples(predictionSamples);	
		
	
	}
}
