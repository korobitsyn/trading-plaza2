package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class TestPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TestPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton testButton = new JButton("Test");
		springLayout.putConstraint(SpringLayout.EAST, testButton, -10, SpringLayout.EAST, this);
		add(testButton);
		
		JProgressBar progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.SOUTH, testButton, 0, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 25, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, progressBar, -100, SpringLayout.EAST, this);
		add(progressBar);

	}

}
