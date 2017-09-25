package system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LeagueTable {
	private static JTable LeagueStandingsTable;
	private String table[][];
	private List<Game> gamesList;
	
	public LeagueTable(List<Game> games) {
		table = this.calculateStandings(games);
		gamesList = games;
	}
	
	public String[][] getLeagueTable(){
		return table;
	}
	
	
	public JPanel update(List<Game> games) {
		JPanel panel = new JPanel();
		table = this.calculateStandings(games);
		gamesList = games;
		panel = showLeagueStandings();
		return panel;
	}
	
	public JPanel showLeagueStandings() {
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(100,800));
		
		String columns[] = {"#","Team","MP","D","P"};	//Header
		LeagueTable leagueTable = new LeagueTable(gamesList); // Table Data
		String[][] leagueTableData = leagueTable.getLeagueTable();
		LeagueStandingsTable = new JTable(leagueTableData, columns);
		
		// UI Stuffs
		LeagueStandingsTable.setShowVerticalLines(false);
		LeagueStandingsTable.setShowHorizontalLines(false);
		LeagueStandingsTable.setShowGrid(false);
		LeagueStandingsTable.setRowSelectionAllowed(false);
		LeagueStandingsTable.setEnabled(false);
		LeagueStandingsTable.setBorder(null);
		LeagueStandingsTable.setFillsViewportHeight(true);
		LeagueStandingsTable.setFont(new Font("Serif", Font.BOLD, 14));
		ui.WelcomeScreen.resizeColumnWidth(LeagueStandingsTable);
		//LeagueStandingsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.setLayout(new BorderLayout(2, 0));
		panel.add(LeagueStandingsTable.getTableHeader(), BorderLayout.NORTH);
		panel.add(LeagueStandingsTable, BorderLayout.CENTER);
		
		
		return panel;
	}
	

	private String[][] calculateStandings(List<Game> games){
		
		String[][] temp = new String[games.size()][4];
		// Connect to database via spring
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/SoccerBeans.xml");
		TeamJDBCTemplate TeamTemplate = (TeamJDBCTemplate)context.getBean("TeamJDBCTemplate");
		// Store the list of team names
		List<Team> teamNames = TeamTemplate.listTeamNames();
		/* ^^          ^^                 ^^
		 * This is the lazy way of doing it. The names list could be
		 * calculated locally instead of generating an additional 
		 * query to the database, but for databases that are 
		 * frequently updated this wouldn't be such a bad idea...
		 */
		
		// Array contents [Position][TeamName][MatchesPlayed][GoalDif.][Pts]
		String[][] results = new String[teamNames.size()][5];

		// Populate Team names and empty data
		String tempResults[][] = new String[teamNames.size()][5];
		for (int t = 0; t < teamNames.size(); t++) {
			Integer in = new Integer(t+1);
			tempResults[t][0] = in.toString();
			tempResults[t][1] = teamNames.get(t).getTeamName();
			tempResults[t][2] = "0";
			tempResults[t][3] = "0";
			tempResults[t][4] = "0";
		}
		
		// Calculate Win Draw Loss Per Team
		for (Game g2 : games) {
			if (g2.getHomeTeamScore() > g2.getAwayTeamScore()) {
			// If the home team wins
				// Update Home Team data
				for (int k = 0; k < teamNames.size(); k++) {
					if (tempResults[k][1].equalsIgnoreCase(g2.getHomeTeam().getTeamName())){
						
						// Update Matches Played
						Integer ins = Integer.parseInt(tempResults[k][2]) + 1;
						tempResults[k][2] = ins.toString();
						// Update Goal Difference
						Integer ins2 = Integer.parseInt(tempResults[k][3]) + 
								(g2.getHomeTeamScore()-g2.getAwayTeamScore());
						tempResults[k][3] = ins2.toString();
						// Update Points Standings
						Integer ins3 = Integer.parseInt(tempResults[k][4]) + 3;
						tempResults[k][4] = ins3.toString();
					}
				}
				// Update Away Team Data
				for (int L = 0; L < teamNames.size(); L++) {
					if (tempResults[L][1].equalsIgnoreCase(g2.getAwayTeam().getTeamName())){
						
						// Update Matches Played
						Integer ins = Integer.parseInt(tempResults[L][2]) + 1;
						tempResults[L][2] = ins.toString();
						// Update Goal Difference
						Integer ins2 = Integer.parseInt(tempResults[L][3]) - 
								(g2.getHomeTeamScore()-g2.getAwayTeamScore());
						tempResults[L][3] = ins2.toString();
						// Update Points Standings
						Integer ins3 = Integer.parseInt(tempResults[L][4]) + 0;
						tempResults[L][4] = ins3.toString();
					}
				}
			}
			else if (g2.getHomeTeamScore() == g2.getAwayTeamScore()) {
			// If it is a draw
				// Update Home Team data
				for (int k = 0; k < teamNames.size(); k++) {
					if (tempResults[k][1].equalsIgnoreCase(g2.getHomeTeam().getTeamName())){
						
						// Update Matches Played
						Integer ins = Integer.parseInt(tempResults[k][2]) + 1;
						tempResults[k][2] = ins.toString();
						// Update Goal Difference
						Integer ins2 = Integer.parseInt(tempResults[k][3]) + 
								(g2.getHomeTeamScore()-g2.getAwayTeamScore());
						tempResults[k][3] = ins2.toString();
						// Update Points Standings
						Integer ins3 = Integer.parseInt(tempResults[k][4]) + 1;
						tempResults[k][4] = ins3.toString();
					}
				}
				// Update Away Team Data
				for (int L = 0; L < teamNames.size(); L++) {
					if (tempResults[L][1].equalsIgnoreCase(g2.getAwayTeam().getTeamName())){
						
						// Update Matches Played
						Integer ins = Integer.parseInt(tempResults[L][2]) + 1;
						tempResults[L][2] = ins.toString();
						// Update Goal Difference
						Integer ins2 = Integer.parseInt(tempResults[L][3]) - 
								(g2.getHomeTeamScore()-g2.getAwayTeamScore());
						tempResults[L][3] = ins2.toString();
						// Update Points Standings
						Integer ins3 = Integer.parseInt(tempResults[L][4]) + 1;
						tempResults[L][4] = ins3.toString();
					}
				}
			}
			else if (g2.getHomeTeamScore() < g2.getAwayTeamScore()) {
			// If the home team lost
				// Update Home Team data
				for (int k = 0; k < teamNames.size(); k++) {
					if (tempResults[k][1].equalsIgnoreCase(g2.getHomeTeam().getTeamName())){
						
						// Update Matches Played
						Integer ins = Integer.parseInt(tempResults[k][2]) + 1;
						tempResults[k][2] = ins.toString();
						// Update Goal Difference
						Integer ins2 = Integer.parseInt(tempResults[k][3]) + 
								(g2.getHomeTeamScore()-g2.getAwayTeamScore());
						tempResults[k][3] = ins2.toString();
						// Update Points Standings
						Integer ins3 = Integer.parseInt(tempResults[k][4]) + 0;
						tempResults[k][4] = ins3.toString();
					}
				}
				// Update Away Team Data
				for (int L = 0; L < teamNames.size(); L++) {
					if (tempResults[L][1].equalsIgnoreCase(g2.getAwayTeam().getTeamName())){
						
						// Update Matches Played
						Integer ins = Integer.parseInt(tempResults[L][2]) + 1;
						tempResults[L][2] = ins.toString();
						// Update Goal Difference
						Integer ins2 = Integer.parseInt(tempResults[L][3]) - 
								(g2.getHomeTeamScore()-g2.getAwayTeamScore());
						tempResults[L][3] = ins2.toString();
						// Update Points Standings
						Integer ins3 = Integer.parseInt(tempResults[L][4]) + 3;
						tempResults[L][4] = ins3.toString();
					}
				}
			}
		}
		
		
		Integer highest = new Integer(0);
		int row = 0;
		/* Sort Table rows by total points
		 * O(n^2) sort algorithm. This could be improved but since
		 * this sort should only occur on the number of teams in a 
		 * given league, this should not exceed 50 teams in any given
		 * season, and therefore the additional speed up of alternate
		 * sort algorithms was considered but not implemented. 
		 */
		for (int j=0; j<tempResults.length; j++) {
			for (int k=0; k<tempResults.length; k++) {
				if (Integer.parseInt(tempResults[k][4]) > highest) {
					highest = Integer.parseInt(tempResults[k][4]);
					row = k;
				}
			}
			results[j][0] = tempResults[row][0];
			results[j][1] = tempResults[row][1];
			results[j][2] = tempResults[row][2];
			results[j][3] = tempResults[row][3];
			results[j][4] = tempResults[row][4];
			Integer t = new Integer(-1);
			tempResults[row][4] = t.toString();
			highest = -1;
			row = 0;
		}
		
		/*
		 * Secondary Sort should sort by goal difference for teams with the same number of points.
		 * THIS HAS NOT BEEN IMPLEMENTED YET
		 * This means that the league table may not be 100% exact, but should be close.
		 */
		
		
		
		// Place proper position numbers in the table
		for (int t = 0; t < teamNames.size(); t++) {
			Integer in = new Integer(t+1);
			results[t][0] = in.toString();
		}
		
		
		return results;
	}
	
}
