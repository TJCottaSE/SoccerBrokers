package ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ContactWindow {
	private JPanel pane;
	
	public ContactWindow() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[]", "[][][][][][]"));
		
		JLabel line1 = new JLabel("Thank You for Choosing SoccerBrokers");
		pane.add(line1, "cell 0 0");
		
		JLabel line2 = new JLabel("We can be reached through our support");
		pane.add(line2, "cell 0 1");
		
		JLabel line3 = new JLabel("forums at SoccerBrokers.com/support.");
		pane.add(line3, "cell 0 2");
		
		JLabel line4 = new JLabel("Developer: T.J. Cotta");
		pane.add(line4, "cell 0 3");
		
		JLabel line5 = new JLabel("Contact: TJCottaSE@gmail.com");
		pane.add(line5, "cell 0 4");
		
	}
	
	public JPanel getContentPane() {
		return pane;
	}
}










