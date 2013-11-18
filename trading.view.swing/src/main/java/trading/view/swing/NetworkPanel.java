package trading.view.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class NetworkPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NetworkPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("Neural Network summary");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(24, 23, 200, 19);
		add(label);
		
		JLabel label_1 = new JLabel("Layers:");
		label_1.setBounds(96, 83, 70, 15);
		add(label_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("1,2,3");
		formattedTextField.setAlignmentY(0.0f);
		formattedTextField.setAlignmentX(0.0f);
		formattedTextField.setBounds(182, 81, 157, 19);
		add(formattedTextField);
		
		JLabel label_2 = new JLabel("Prediction interval :");
		label_2.setBounds(35, 137, 142, 24);
		add(label_2);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("60");
		formattedTextField_1.setBounds(182, 140, 51, 19);
		add(formattedTextField_1);
		
		JLabel label_3 = new JLabel("seconds");
		label_3.setBounds(241, 142, 70, 15);
		add(label_3);

	}

}
