package trading.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ResourceBundle;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Application window for Level1 chart
 * @author pdg
 *
 */
public class Level1Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1Window window = new Level1Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1Window window = new Level1Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Level1Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Level1Window.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		frame.setTitle(ResourceBundle.getBundle("trading.view.swing.messages").getString("Level1WindowTitle")); //$NON-NLS-1$ //$NON-NLS-2$
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		toolBar.add(comboBox);
		
		JToggleButton captureDataButton = new JToggleButton(ResourceBundle.getBundle("trading.view.swing.messages").getString("Level1Window.captureButton.text")); //$NON-NLS-1$ //$NON-NLS-2$
		captureDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		toolBar.add(captureDataButton);
	}

}
