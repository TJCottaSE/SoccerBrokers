package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import system.CountriesDropDownList;
import system.Game;
import system.GameJDBCTemplate;
import system.LeagueTable;
import system.TeamsDropDownList;

import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.SpringLayout;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public class WelcomeScreen {
	private static JTable table;
	private static JTable LeagueStandingsTable;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	List<Game> games = new ArrayList(1);
            	JFrame MAINFRAME = new JFrame();
        		MAINFRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		MAINFRAME.setTitle("SoccerBrokers");
        		MAINFRAME.getContentPane().setLayout(new BorderLayout(0, 0));
        		MAINFRAME.setSize(new Dimension(1280,720));
        		MAINFRAME.add(WelcomeScreen(games), BorderLayout.CENTER);
        		MAINFRAME.setVisible(true);
            }
        });
			
	}
	
	
	public static JPanel WelcomeScreen(List<Game> games2) {
		// Connect to database via spring
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/SoccerBeans.xml");
		GameJDBCTemplate gameTemplate = (GameJDBCTemplate)context.getBean("GameJDBCTemplate");
		List<Game> games = null;
		// Request most up to date games list if not given
		if (games2.size() >= 2) {
			games = games2;
		}
		else {
			games = gameTemplate.listGames();
		}
//		for (Game G : games) {
//			System.out.println("Home: " + G.getHomeTeam().getTeamName()
//			+ ": " + G.getHomeTeamScore() + ":" + G.getAwayTeamScore()
//			+ " :" + G.getAwayTeam().getTeamName());
//			
//		}
		
		// Calculate League table
		String data[][] = {{"0","0","0","0","0",}};
		LeagueTable leagueTable = new LeagueTable(games);
		String[][] leagueTableData = leagueTable.getLeagueTable();
		
		// Calculate Recent Games
		Object[][] recentTable = new Object[15][5];
		RecentGames recent = new RecentGames(games);
		
		
		
		// UI Components
		
		/*
		 * The Base from from which all others are created.
		 */ 
		//JFrame MAINFRAME = new JFrame();
		JPanel MAINFRAME = new JPanel();
		MAINFRAME.revalidate();
		MAINFRAME.repaint();
		
		// This may have to change to a main panel
//		MAINFRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		MAINFRAME.setTitle("SoccerBrokers");
//		MAINFRAME.getContentPane().setLayout(new BorderLayout(0, 0));
		MAINFRAME.setSize(new Dimension(1280,720));
		MAINFRAME.setLayout(new BorderLayout(0,0));
		
		/*
		 * Start Header
		 * Header is divided into 2 parts stacked vertically, 
		 * Top_Header and Bottom_Header respectively
		 */
		JPanel Header = new JPanel();
		MAINFRAME.add(Header, BorderLayout.NORTH);
		GridBagLayout gbl_Header = new GridBagLayout();
		gbl_Header.columnWidths = new int[]{39, 1202, 0};
		gbl_Header.rowHeights = new int[]{35, 35, 0};
		gbl_Header.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_Header.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		Header.setLayout(gbl_Header);

		/*
		 * Start Top Panel of Header
		 */
		JPanel Top_Header = new JPanel();
		GridBagConstraints gbc_Top_Header = new GridBagConstraints();
		gbc_Top_Header.anchor = GridBagConstraints.NORTHWEST;
		gbc_Top_Header.insets = new Insets(0, 0, 5, 0);
		gbc_Top_Header.gridx = 1;
		gbc_Top_Header.gridy = 0;
		Header.add(Top_Header, gbc_Top_Header);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		Top_Header.add(horizontalGlue);
		
		JLabel lblSoccerbrokers = new JLabel("SoccerBrokers.com");
		lblSoccerbrokers.setHorizontalAlignment(SwingConstants.LEFT);
		Top_Header.add(lblSoccerbrokers);
		
		Component horizontalStrut = Box.createHorizontalStrut(900);
		Top_Header.add(horizontalStrut);
		
		JButton btnLogIn = new JButton("Log In");
		Top_Header.add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		Top_Header.add(btnSignUp);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		Top_Header.add(horizontalGlue_1);
		/*
		 * ^^ End Top Panel of Header ^^
		 */
		
		/*
		 * Start Bottom Panel of Header
		 */
		JPanel Bottom_Header = new JPanel();
		Bottom_Header.setPreferredSize(new Dimension(1280,20));
		GridBagConstraints gbc_Bottom_Header = new GridBagConstraints();
		gbc_Bottom_Header.fill = GridBagConstraints.HORIZONTAL;
		gbc_Bottom_Header.anchor = GridBagConstraints.NORTH;
		gbc_Bottom_Header.gridx = 1;
		gbc_Bottom_Header.gridy = 1;
		Header.add(Bottom_Header, gbc_Bottom_Header);
		
		// Combo boxes
		CountriesDropDownList country = new CountriesDropDownList();
		Bottom_Header.setLayout(new BoxLayout(Bottom_Header, BoxLayout.X_AXIS));
		JComboBox countryComboBox = new JComboBox(country.getListOfCountries());

				

		Bottom_Header.add(countryComboBox);
		
		
		TeamsDropDownList team = new TeamsDropDownList();
		JComboBox teamComboBox = new JComboBox(team.getListOfTeams());
		Bottom_Header.add(teamComboBox);
		
		// Buttons
		JButton btnOdds = new JButton("Odds");
		Bottom_Header.add(btnOdds);
		
		JButton btnPrediction = new JButton("Predictions");
		Bottom_Header.add(btnPrediction);
		
		JButton btnHistory = new JButton("History");
		Bottom_Header.add(btnHistory);
		
		JButton btnCalculators = new JButton("Calculators");
		btnCalculators.addActionListener(new CalculatorButtonPressed());
		Bottom_Header.add(btnCalculators);
		/* 
		 * ^^ End Bottom Header ^^
		 */
		
		/*
		 * Center Dynamic Panel Start
		 */
		JPanel CenterDynamicPanel = new JPanel();
		MAINFRAME.add(CenterDynamicPanel, BorderLayout.CENTER);

		// Insert Dynamic Page change here
		CenterDynamicPanel.add(recent.showRecentGames());
		
		
		
		/*
		 * ^^ Center Panel End ^^
		 */
		

		/*
		 * League Standing panel Start 
		 */
		JPanel LeagueStandingsPanel = new JPanel();
		LeagueStandingsPanel.setMaximumSize(new Dimension(100,800));
		MAINFRAME.add(LeagueStandingsPanel, BorderLayout.EAST);
		
//		String columns[] = {"#","Team","MP","D","P"};	//Header
//		//String data[][] = {{"0","0","0","0","0",}};		// Test data		ENTER REAL DATA HERE WITH FUNCTION CALL
//		LeagueStandingsTable = new JTable(leagueTableData/*data*/, columns);
//		LeagueStandingsTable.setShowVerticalLines(false);
//		LeagueStandingsTable.setShowHorizontalLines(false);
//		LeagueStandingsTable.setShowGrid(false);
//		LeagueStandingsTable.setRowSelectionAllowed(false);
//		LeagueStandingsTable.setEnabled(false);
//		LeagueStandingsTable.setBorder(null);
//		LeagueStandingsTable.setFillsViewportHeight(true);
//		LeagueStandingsTable.setFont(new Font("Serif", Font.BOLD, 14));
//		resizeColumnWidth(LeagueStandingsTable);
		//LeagueStandingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		LeagueTable t1 = new LeagueTable(games);
		LeagueStandingsPanel.setLayout(new BorderLayout(2, 0));
		LeagueStandingsPanel.add(t1.showLeagueStandings());
		//LeagueStandingsPanel.add(LeagueStandingsTable.getTableHeader(), BorderLayout.NORTH);
		//LeagueStandingsPanel.add(LeagueStandingsTable, BorderLayout.CENTER);
		
		
		/*
		 * ^^ League Standing Panel End ^^
		 */
		
		countryComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox countryBox = (JComboBox) e.getSource();
				Object selected = countryBox.getSelectedItem();
				System.out.println(selected.toString());
				ApplicationContext context2 = new ClassPathXmlApplicationContext("resources/SoccerBeans.xml");
				GameJDBCTemplate gameTemplate2 = (GameJDBCTemplate)context2.getBean("GameJDBCTemplate");
				List<Game> small = null;
				
				if (selected.toString().equals("England")) {
					// Update Center Panel Recent Games History
					small = gameTemplate2.listGames("England_2016_2017");
					
				}
				if (selected.toString().equals("Germany")) {
					small = gameTemplate2.listGames("Germany_2016_2017");
				}
				
				// Update Center Panel Recent Games History
				recent.update(small);
				// Update League Table
				t1.update(small);
				// Repaint the panels
				MAINFRAME.remove(CenterDynamicPanel);
				MAINFRAME.add(recent.showRecentGames(), BorderLayout.CENTER);
				MAINFRAME.revalidate();
				MAINFRAME.repaint();
				
				MAINFRAME.remove(LeagueStandingsPanel);
				MAINFRAME.add(t1.showLeagueStandings(), BorderLayout.EAST);
				MAINFRAME.revalidate();
				MAINFRAME.repaint();
				
//				
//				
//				JComboBox box = (JComboBox) e.getSource();
//				Object selected = box.getSelectedItem();
//				
//				if (selected.toString().equals("England")) {
//					List<Game> games = gameTemplate.listGames("England_2017_2018");
//					// Calculate League table
//					LeagueTable leagueTable = new LeagueTable(games);
//					String[][] leagueTableData = leagueTable.getLeagueTable();
//					
//					// Calculate Recent Games
//					Object[][] recentTable = new Object[15][5];
//					RecentGames recent = new RecentGames(games);
//					
//					CenterDynamicPanel.add(recent.showRecentGames());
//					
//				}
//				else if (selected.toString().equals("Germany")) {
//					List<Game> games = gameTemplate.listGames("Germany_2016_2017");
//					// Calculate League table
//					LeagueTable leagueTable = new LeagueTable(games);
//					String[][] leagueTableData = leagueTable.getLeagueTable();
//					
//					// Calculate Recent Games
//					Object[][] recentTable = new Object[15][5];
//					RecentGames recent = new RecentGames(games);
//					
//					CenterDynamicPanel.add(recent.showRecentGames());
//				}
			}
		});
		
		
		/*
		 * Start of Footer 
		 */
		JPanel Footer = new JPanel();
		MAINFRAME.add(Footer, BorderLayout.SOUTH);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setHorizontalAlignment(SwingConstants.RIGHT);
		Footer.add(btnAbout);
		
		JButton btnContact = new JButton("Contact");
		btnContact.addActionListener(new ContactButtonPressed());
		btnContact.setHorizontalAlignment(SwingConstants.RIGHT);
		Footer.add(btnContact);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setHorizontalAlignment(SwingConstants.RIGHT);
		Footer.add(btnHelp);
		/*
		 * ^^ End of Footer ^^
		 */
		
		MAINFRAME.setVisible(true);
		return MAINFRAME;

	}
	
	/**
	 * Resize table column widths
	 * @param table to be resized
	 */
	public static void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 20; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +20 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

	/*
	 * Open the window that shows contact details
	 */
	static class ContactButtonPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame ContactFrame = new JFrame();
			ContactFrame.setVisible(true);
			ContactFrame.setSize(300, 150);
			ContactFrame.setTitle("Contact");
			ContactWindow c = new ContactWindow();
			ContactFrame.getContentPane().add(c.getContentPane());
		}
	}
	
	/**
	 * Open the Calculator Window
	 */
	static class CalculatorButtonPressed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DoublePlayCalculator dp = new DoublePlayCalculator();
			dp.createAndShowGUI();
		}
	}
	
//	static class CountrySelector implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			JComboBox box = (JComboBox) e.getSource();
//			Object selected = box.getSelectedItem();
//			if(selected.toString().equals("England")) {
//				box.getParent().getParent().
//			}
//			else if(selected.toString().equals("Germany")) {
//				
//			}
//		}
//	}
}










