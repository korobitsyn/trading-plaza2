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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private final JFormattedTextField txtTrainStep;
	private final JLabel lblPredictionSamples;
	private final JLabel lblNeededItems; 
	/**
	 * Create the panel.
	 */
	public NetworkPanel(NeuralContext context) {
		neuralContext = context;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JPanel settingsPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, settingsPanel, 60,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, settingsPanel, 24,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, settingsPanel, -10,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, settingsPanel, 343,
				SpringLayout.WEST, this);
		add(settingsPanel);
		SpringLayout sl_settingsPanel = new SpringLayout();
		settingsPanel.setLayout(sl_settingsPanel);

		JLabel label_1 = new JLabel("Layers:");
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, label_1, 10,
				SpringLayout.NORTH, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, label_1, 97,
				SpringLayout.WEST, settingsPanel);
		springLayout.putConstraint(SpringLayout.WEST, label_1, 121,
				SpringLayout.WEST, this);
		settingsPanel.add(label_1);

		txtLayers = new JFormattedTextField("10,10,2");
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, txtLayers, -2,
				SpringLayout.NORTH, label_1);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, txtLayers, 18,
				SpringLayout.EAST, label_1);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, txtLayers, -90,
				SpringLayout.EAST, settingsPanel);
		springLayout.putConstraint(SpringLayout.EAST, label_1, -10,
				SpringLayout.WEST, txtLayers);
		springLayout.putConstraint(SpringLayout.EAST, txtLayers, 339,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, txtLayers, 182,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtLayers, 100,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtLayers, 81,
				SpringLayout.NORTH, this);
		txtLayers.setText("1,2,3");
		txtLayers.setAlignmentY(0.0f);
		txtLayers.setAlignmentX(0.0f);
		settingsPanel.add(txtLayers);

		JLabel lblPredictionSize = new JLabel("Prediction size:");
		sl_settingsPanel.putConstraint(SpringLayout.WEST, lblPredictionSize,
				40, SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, lblPredictionSize, 0, SpringLayout.EAST, txtLayers);
		springLayout.putConstraint(SpringLayout.WEST, lblPredictionSize, 82,
				SpringLayout.WEST, this);
		settingsPanel.add(lblPredictionSize);

		txtPredictionSize = new JFormattedTextField(new Integer(60));
		sl_settingsPanel.putConstraint(SpringLayout.WEST, txtPredictionSize, 0,
				SpringLayout.WEST, txtLayers);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, txtPredictionSize, 0, SpringLayout.EAST, txtLayers);
		txtPredictionSize.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateNeededLevel1Count();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, txtPredictionSize, 4,
				SpringLayout.NORTH, lblPredictionSize);
		springLayout.putConstraint(SpringLayout.WEST, txtPredictionSize, 10,
				SpringLayout.EAST, lblPredictionSize);
		txtPredictionSize.setText("60");
		settingsPanel.add(txtPredictionSize);

		// Create button
		btnCreate = new JButton("Create");
		springLayout.putConstraint(SpringLayout.NORTH, btnCreate, 60,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnCreate, -150,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate, -50,
				SpringLayout.EAST, this);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNetwork();
			}
		});
		add(btnCreate);

		// Load button
		btnLoad = new JButton("Load");
		springLayout.putConstraint(SpringLayout.NORTH, btnLoad, 38,
				SpringLayout.SOUTH, btnCreate);
		springLayout.putConstraint(SpringLayout.WEST, btnLoad, 0,
				SpringLayout.WEST, btnCreate);
		springLayout.putConstraint(SpringLayout.EAST, btnLoad, -50,
				SpringLayout.EAST, this);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadNetwork();
			}
		});
		add(btnLoad);

		// Save button
		btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 20,
				SpringLayout.SOUTH, btnLoad);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 0,
				SpringLayout.WEST, btnCreate);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, 0,
				SpringLayout.EAST, btnCreate);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNetwork();
			}
		});
		add(btnSave);

		// Reset button
		btnReset = new JButton("Reset");
		springLayout.putConstraint(SpringLayout.NORTH, btnReset, 32,
				SpringLayout.SOUTH, btnSave);
		springLayout.putConstraint(SpringLayout.WEST, btnReset, 0,
				SpringLayout.WEST, btnCreate);
		springLayout.putConstraint(SpringLayout.EAST, btnReset, 0,
				SpringLayout.EAST, btnCreate);
		springLayout.putConstraint(SpringLayout.EAST, txtPredictionSize, -281,
				SpringLayout.WEST, btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetNetwork();
			}
		});
		add(btnReset);

		txtWindowSize = new JFormattedTextField();
		txtWindowSize.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateNeededLevel1Count();
			}
		});
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, txtWindowSize, 19,
				SpringLayout.SOUTH, txtLayers);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, txtWindowSize, 166,
				SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, txtWindowSize, 0,
				SpringLayout.EAST, txtLayers);
		springLayout.putConstraint(SpringLayout.EAST, txtWindowSize, -281,
				SpringLayout.WEST, btnSave);
		springLayout.putConstraint(SpringLayout.NORTH, txtWindowSize, 6,
				SpringLayout.NORTH, btnSave);
		txtWindowSize.setText("100");
		settingsPanel.add(txtWindowSize);

		JLabel lblWindowSize = new JLabel("Window size:");
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, lblWindowSize, 23,
				SpringLayout.SOUTH, label_1);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, lblWindowSize, 55,
				SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, lblWindowSize, 0,
				SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.WEST, txtWindowSize, 10,
				SpringLayout.EAST, lblWindowSize);
		springLayout.putConstraint(SpringLayout.NORTH, lblPredictionSize, 17,
				SpringLayout.SOUTH, lblWindowSize);
		springLayout.putConstraint(SpringLayout.EAST, lblPredictionSize, 0,
				SpringLayout.EAST, lblWindowSize);
		springLayout.putConstraint(SpringLayout.NORTH, lblWindowSize, 7,
				SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, lblWindowSize, 0,
				SpringLayout.EAST, label_1);
		settingsPanel.add(lblWindowSize);

		// Samples count
		txtTrainSamples = new JFormattedTextField();
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, txtTrainSamples, 6, SpringLayout.SOUTH, txtWindowSize);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, txtTrainSamples, -90, SpringLayout.EAST, settingsPanel);
		txtTrainSamples.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateNeededLevel1Count();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, txtTrainSamples, -281,
				SpringLayout.WEST, btnReset);
		springLayout.putConstraint(SpringLayout.SOUTH, txtTrainSamples, 0,
				SpringLayout.SOUTH, btnReset);
		settingsPanel.add(txtTrainSamples);

		JLabel lblSamplesCount = new JLabel("Train samples:");
		sl_settingsPanel.putConstraint(SpringLayout.WEST, txtTrainSamples, 18, SpringLayout.EAST, lblSamplesCount);
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, lblSamplesCount,
				2, SpringLayout.NORTH, txtTrainSamples);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, lblSamplesCount, 46,
				SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, lblSamplesCount, 0, SpringLayout.EAST, label_1);
		springLayout.putConstraint(SpringLayout.WEST, txtTrainSamples, 10,
				SpringLayout.EAST, lblSamplesCount);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSamplesCount, 0,
				SpringLayout.SOUTH, btnReset);
		springLayout.putConstraint(SpringLayout.EAST, lblSamplesCount, 0,
				SpringLayout.EAST, label_1);
		settingsPanel.add(lblSamplesCount);

		txtPredictionSamples = new JFormattedTextField();
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, txtPredictionSamples, 6, SpringLayout.SOUTH, txtPredictionSize);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, txtPredictionSamples, 0, SpringLayout.WEST, txtLayers);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, txtPredictionSamples, 0, SpringLayout.EAST, txtLayers);
		txtPredictionSamples.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateNeededLevel1Count();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, txtPredictionSamples,
				288, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtPredictionSamples,
				182, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, txtPredictionSamples,
				-124, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, txtPredictionSamples,
				-421, SpringLayout.EAST, this);
		settingsPanel.add(txtPredictionSamples);

		lblPredictionSamples = new JLabel("Prediction samples:");
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, lblPredictionSamples, 0, SpringLayout.NORTH, txtPredictionSamples);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, lblPredictionSamples,
				10, SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, lblPredictionSamples, 0, SpringLayout.EAST, txtLayers);
		springLayout.putConstraint(SpringLayout.EAST, lblPredictionSamples, 0,
				SpringLayout.EAST, lblWindowSize);
		settingsPanel.add(lblPredictionSamples);

		txtTrainStep = new JFormattedTextField();
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, txtPredictionSize, 15, SpringLayout.SOUTH, txtTrainStep);
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, lblPredictionSize, 17, SpringLayout.SOUTH, txtTrainStep);
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, txtTrainStep, 6, SpringLayout.SOUTH, txtTrainSamples);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, txtTrainStep, 0, SpringLayout.WEST, txtLayers);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, txtTrainStep, -115, SpringLayout.EAST, settingsPanel);
		txtTrainStep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateNeededLevel1Count();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, txtTrainStep, -16,
				SpringLayout.NORTH, txtPredictionSamples);
		springLayout.putConstraint(SpringLayout.EAST, txtTrainStep, -421,
				SpringLayout.EAST, this);

		settingsPanel.add(txtTrainStep);

		JLabel lblTrainStep = new JLabel("Train step:");
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, lblTrainStep, 2, SpringLayout.NORTH, txtTrainStep);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, lblTrainStep, 73,
				SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, lblTrainStep, -18, SpringLayout.WEST, txtTrainStep);
		springLayout.putConstraint(SpringLayout.WEST, txtTrainStep, 10,
				SpringLayout.EAST, lblTrainStep);
		springLayout.putConstraint(SpringLayout.NORTH, lblPredictionSamples,
				18, SpringLayout.SOUTH, lblTrainStep);
		springLayout.putConstraint(SpringLayout.NORTH, lblTrainStep, 3,
				SpringLayout.NORTH, txtTrainStep);
		springLayout.putConstraint(SpringLayout.EAST, lblTrainStep, 0,
				SpringLayout.EAST, label_1);
		settingsPanel.add(lblTrainStep);

		JLabel label = new JLabel("Neural Network summary");
		springLayout.putConstraint(SpringLayout.EAST, label, 320,
				SpringLayout.WEST, this);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, label, 10,
				SpringLayout.WEST, this);
		sl_settingsPanel.putConstraint(SpringLayout.SOUTH, label, -5,
				SpringLayout.NORTH, settingsPanel);
		add(label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 23,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label, 24,
				SpringLayout.WEST, this);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 44,
				SpringLayout.SOUTH, label);

		lblNeededItems = new JLabel("Items");
		sl_settingsPanel.putConstraint(SpringLayout.NORTH, lblNeededItems, 277, SpringLayout.NORTH, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.SOUTH, lblNeededItems, -35, SpringLayout.SOUTH, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.WEST, lblNeededItems, 10, SpringLayout.WEST, settingsPanel);
		sl_settingsPanel.putConstraint(SpringLayout.EAST, lblNeededItems, -10, SpringLayout.EAST, settingsPanel);
		lblNeededItems.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNeededItems.setVerticalAlignment(SwingConstants.TOP);
		settingsPanel.add(lblNeededItems);

		// File chooser
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter(
				"Network config (.cfg)", "cfg"));

		updateView();
	}

	/**
	 * Reset network weights
	 */
	private void resetNetwork() {
		updateContext();
		neuralContext.getNetwork().reset();
		updateView();
	}

	/**
	 * Load network weights from file
	 */
	private void loadNetwork() {
		updateContext();
		// Show open dialog and open
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			neuralContext.getNeuralService().loadNetwork(
					fileChooser.getSelectedFile());
		}
		updateView();
	}

	/**
	 * Save network weights to file
	 * 
	 * @return
	 */
	private void saveNetwork() {
		updateContext();

		// Shiw save dialog and save
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			if (!path.endsWith("cfg")) {
				file = new File(path + ".cfg");

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
		if (neuralContext == null) {
			return;
		}

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
		txtTrainSamples.setText(neuralContext.getTrainingContext()
				.getTrainSamples().toString());
		txtPredictionSamples.setText(neuralContext.getTrainingContext()
				.getPredictionSamples().toString());
		// Train step spinner
		txtTrainStep.setText(neuralContext.getTrainingContext().getTrainStep().toString());


		// Buttons
		boolean isNetworkNotNull = (neuralContext.getNetwork() != null);
		btnSave.setEnabled(isNetworkNotNull);
		btnReset.setEnabled(isNetworkNotNull);

		updateNeededLevel1Count();

	}

	/**
	 * Update level1Neededlabel
	 */
	public void updateNeededLevel1Count() {
		// Get prediction size;
		int predictionInterval = Integer.parseInt(txtPredictionSize.getText());
		int predictionSamples = Integer
				.parseInt(txtPredictionSamples.getText());
		int predictionSize = predictionInterval * predictionSamples;

		// Get trainingSzie
		int windowSize = Integer.parseInt(txtWindowSize.getText());
		int trainSamples = Integer.parseInt(txtTrainSamples.getText());
		int trainStep = Integer.parseInt(txtTrainStep.getText());
		int trainingSize = windowSize + trainStep*(trainSamples-1);
				
		String level1NeededString = String
				.format("<html>Required history items: <br/>%d for training, <br/>%d for prediction. <br/><b>%d</b> overall.</html>",
						trainingSize, predictionSize, trainingSize
								+ predictionSize);
		// Set label text
		lblNeededItems.setText(level1NeededString);
	}

	/**
	 * Update context from this view
	 */
	public void updateContext() {
		// Update prediction interval
		int predictionInterval = Integer.parseInt(txtPredictionSize.getText());
		neuralContext.setPredictionSize(predictionInterval);
		// Update window size
		int windowSize = Integer.parseInt(txtWindowSize.getText());
		neuralContext.setLevel1WindowSize(windowSize);
		// Update prediction samples
		int trainSamples = Integer.parseInt(txtTrainSamples.getText());
		neuralContext.getTrainingContext().setTrainSamples(trainSamples);
		// Update train step
		neuralContext.getTrainingContext().setTrainStep(
				Integer.parseInt(txtTrainStep.getText()));

		// Update train samples
		int predictionSamples = Integer
				.parseInt(txtPredictionSamples.getText());
		neuralContext.getTrainingContext().setPredictionSamples(
				predictionSamples);

	}
}
