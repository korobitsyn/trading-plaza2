package trading.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ResourceBundle;
import java.awt.Toolkit;

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
	}

}
