package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
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

public class NetworkPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private NeuralContext neuralContext;
	final JFormattedTextField txtPredictionInterval;
	final JFormattedTextField txtLayers;
	final JFileChooser fileChooser;
	final JButton btnCreate;
	final JButton btnLoad;	
	final JButton btnSave;	
	final JButton btnReset;	
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
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 83,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 96,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, 98,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, label_1, 166,
				SpringLayout.WEST, this);
		add(label_1);

		txtLayers = new JFormattedTextField("10,10,2");
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

		JLabel label_2 = new JLabel("Prediction interval :");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 137,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 35,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, label_2, 161,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, label_2, 177,
				SpringLayout.WEST, this);
		add(label_2);

		txtPredictionInterval = new JFormattedTextField(new Integer(60));
		springLayout.putConstraint(SpringLayout.NORTH, txtPredictionInterval,
				140, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPredictionInterval,
				182, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPredictionInterval,
				159, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPredictionInterval,
				233, SpringLayout.WEST, this);
		txtPredictionInterval.setText("60");
		add(txtPredictionInterval);

		JLabel label_3 = new JLabel("seconds");
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 142,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 241,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, label_3, 157,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, label_3, 311,
				SpringLayout.WEST, this);
		add(label_3);

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
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnLoad, 10,
				SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, btnLoad, -90,
				SpringLayout.EAST, btnCreate);
		springLayout.putConstraint(SpringLayout.EAST, btnLoad, 0,
				SpringLayout.EAST, btnCreate);
		add(btnLoad);

		// Save button
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnLoad, -17,
				SpringLayout.NORTH, btnSave);
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
			this.txtPredictionInterval.commitEdit();
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
		txtLayers.setText(layersString);
		// Buttons 
		boolean isNetworkNotNull = (neuralContext.getNetwork() != null);
		btnSave.setEnabled(isNetworkNotNull);
		btnReset.setEnabled(isNetworkNotNull);
	}

	/**
	 * Update context from this view
	 */
	public void updateContext() {
		int predictionInterval = Integer.parseInt(txtPredictionInterval
				.getText());
		neuralContext.setPredictionInterval(predictionInterval);
	}
}
