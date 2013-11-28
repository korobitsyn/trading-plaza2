package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

import trading.app.neural.NeuralContext;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestPanel extends JPanel {

	private NeuralContext neuralContext;
	private final JButton testButton;
	private final JProgressBar progressBar;
	
	/**
	 * Create the panel.
	 */
	public TestPanel(NeuralContext context) {
		neuralContext = context;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		testButton = new JButton("Test");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, testButton, -10, SpringLayout.EAST, this);
		add(testButton);
		
		progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.SOUTH, testButton, 0, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 25, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, progressBar, -100, SpringLayout.EAST, this);
		add(progressBar);

	}
	
	/**
	 * Update view from context
	 */
	public void updateView(){
		testButton.setEnabled(neuralContext != null);
	}
	/**
	 * Test neural network
	 */
	private void testNetwork(){
		//neuralContext.getNeuralService().Network();		
	}

}
