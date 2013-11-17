package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class LearnPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LearnPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JProgressBar learnProgressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, learnProgressBar, 75, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnProgressBar, 12, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, learnProgressBar, 95, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, learnProgressBar, -162, SpringLayout.EAST, this);
		add(learnProgressBar);
		
		JButton learnButton = new JButton("Learn");
		springLayout.putConstraint(SpringLayout.NORTH, learnButton, 70, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnButton, -127, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, learnButton, 100, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, learnButton, -29, SpringLayout.EAST, this);
		add(learnButton);

	}
}
