package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import trading.app.neural.NeuralContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LearnPanel extends JPanel {
	private NeuralContext neuralContext;

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

		JProgressBar learnProgressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, learnProgressBar, 75,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnProgressBar, 12,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, learnProgressBar, 95,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, learnProgressBar, -162,
				SpringLayout.EAST, this);
		add(learnProgressBar);

		JButton learnButton = new JButton("Learn");
		learnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, learnButton, 70,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnButton, -127,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, learnButton, 100,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, learnButton, -29,
				SpringLayout.EAST, this);
		add(learnButton);
	}

	/**
	 * Do neural network training
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void trainNetwork() {

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
}
