package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import trading.app.neural.NeuralContext;
import trading.app.neural.TrainingContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLabel;

public class LearnPanel extends JPanel {
	private NeuralContext neuralContext;
	private final JProgressBar learnProgressBar;
	private final JLabel lblEpoch;
	private JLabel lblLastEpochTime;
	private JLabel lblTotalTime;

	/**
	 * Create the panel.
	 * 
	 * @param context
	 *            Neural network context to work with
	 */
	public LearnPanel(NeuralContext context) {
		this.neuralContext = context;

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		learnProgressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, learnProgressBar, 75,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnProgressBar, 12,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, learnProgressBar, -162,
				SpringLayout.EAST, this);
		add(learnProgressBar);

		JButton learnButton = new JButton("Learn");
		springLayout.putConstraint(SpringLayout.NORTH, learnButton, 70,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnButton, -125,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, learnButton, 100,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, learnButton, -27,
				SpringLayout.EAST, this);
		learnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainNetwork();
			}
		});
		add(learnButton);

		lblEpoch = new JLabel("Epoch 0 of 0");
		springLayout.putConstraint(SpringLayout.NORTH, lblEpoch, 29,
				SpringLayout.SOUTH, learnProgressBar);
		springLayout.putConstraint(SpringLayout.WEST, lblEpoch, 10,
				SpringLayout.WEST, this);
		add(lblEpoch);

		lblLastEpochTime = new JLabel("Last epoch: 0 ms");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastEpochTime, 16,
				SpringLayout.SOUTH, lblEpoch);
		springLayout.putConstraint(SpringLayout.WEST, lblLastEpochTime, 0,
				SpringLayout.WEST, learnProgressBar);
		add(lblLastEpochTime);

		lblTotalTime = new JLabel("Total time: 0 sec");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalTime, 17,
				SpringLayout.SOUTH, lblLastEpochTime);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalTime, 10,
				SpringLayout.WEST, this);
		add(lblTotalTime);

		updateView();
	}

	/**
	 * Do neural network training
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void trainNetwork() {
		resetTrainingContext();
		try {
			neuralContext.getNeuralService().trainNetwork();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Update view from context
	 */
	private void updateView() {
		TrainingContext context = neuralContext.getTrainingContext();
		// Update progress bar
		learnProgressBar.setMaximum(context.getMaxEpochCount());
		learnProgressBar.setValue(context.getLastEpoch());
		// Labels
		lblEpoch.setText(String.format("Epoch %d of %d",
				context.getLastEpoch(), context.getMaxEpochCount()));
		lblLastEpochTime.setText(String.format("Last epoch: %f sec ", new Long(
				context.getLastEpochMilliseconds()).doubleValue() / 1000));
		lblTotalTime.setText(String.format("Total time: %f sec", new Long(
				context.getTrainMilliseconds()).doubleValue()));
	}

	/**
	 * Reset context
	 */
	private void resetTrainingContext() {
		TrainingContext context = neuralContext.getTrainingContext();
		context.setLastEpoch(0);
		context.setLastEpochMilliseconds(0);
		context.setTrainMilliseconds(0);
		updateView();
	}
}
