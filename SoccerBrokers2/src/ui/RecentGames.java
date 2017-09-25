package ui;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import system.Game;

import javax.swing.JLabel;

public class RecentGames {

	List<Game> games = null;
	
	public RecentGames(List<Game> games) {
		this.games = games;
	}
	
	/**
	 * Gets the last 15 games of a given league
	 * @return a list of game objects containing 
	 * the most recent games listed from newest to oldest.
	 */
	public Game[] getRecentGames() {
		Game gamesList[] = new Game[15];
		int index = games.size()-1;
		for (int i=14; i>=0; i--) {
			if (index >= 0) {
				gamesList[i] = games.get(index);
				index--;
			}
			else {
				/*
				 * This is a temporary fix. This section of code should
				 * go back to the previous season and pull data for the 
				 * games that are missing.
				 */
				gamesList[i] = new Game();
			}
				
		}
		
		return gamesList;
	}
	
	/**
	 * Updates the recent games from a new list of games
	 * @param games list of games
	 */
	public void update(List<Game> games) {
		this.games = games;
		this.showRecentGames();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel showRecentGames() {
		Game[] list = this.getRecentGames();
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(900, 500));
		pane.setLayout(new MigLayout("", "[grow][grow][::50,grow][10px][::50,grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblDateHeader = new JLabel("Date");
		pane.add(lblDateHeader, "cell 0 0");
		
		JLabel lblHometeam = new JLabel("Home Team");
		pane.add(lblHometeam, "cell 1 0");
		
		JLabel lblHomeScore = new JLabel("Home");
		pane.add(lblHomeScore, "cell 2 0");
		
		JLabel lblAwayScore = new JLabel("Away");
		pane.add(lblAwayScore, "cell 4 0");
		
		JLabel lblAway = new JLabel("Away Team");
		pane.add(lblAway, "cell 5 0");
		
		JLabel Date15 = new JLabel(list[0].getDate());
		pane.add(Date15, "cell 0 1");
		
		JLabel lblHome15 = new JLabel(list[0].getHomeTeam().getTeamName());
		pane.add(lblHome15, "cell 1 1");
		
		JLabel lblHomescore15 = new JLabel(list[0].getHomeTeamScore().toString());
		pane.add(lblHomescore15, "cell 2 1");
		
		JLabel seperator15 = new JLabel(":");
		pane.add(seperator15, "cell 3 1");
		
		JLabel lblAwayscore15 = new JLabel(list[0].getAwayTeamScore().toString());
		pane.add(lblAwayscore15, "cell 4 1");
		
		JLabel lblAway_15 = new JLabel(list[0].getAwayTeam().getTeamName());
		pane.add(lblAway_15, "cell 5 1");
		
		JLabel Date14 = new JLabel(list[1].getDate());
		pane.add(Date14, "cell 0 2");
		
		JLabel lblHome14 = new JLabel(list[1].getHomeTeam().getTeamName());
		pane.add(lblHome14, "cell 1 2");
		
		JLabel lblHomescore14 = new JLabel(list[1].getHomeTeamScore().toString());
		pane.add(lblHomescore14, "cell 2 2");
		
		JLabel seperator14 = new JLabel(":");
		pane.add(seperator14, "cell 3 2");
		
		JLabel lblAwayscore14 = new JLabel(list[1].getAwayTeamScore().toString());
		pane.add(lblAwayscore14, "cell 4 2");
		
		JLabel lblAway_14 = new JLabel(list[1].getAwayTeam().getTeamName());
		pane.add(lblAway_14, "cell 5 2");
		
		JLabel Date13 = new JLabel(list[2].getDate());
		pane.add(Date13, "cell 0 3");
		
		JLabel lblHome13 = new JLabel(list[2].getHomeTeam().getTeamName());
		pane.add(lblHome13, "cell 1 3");
		
		JLabel lblHomescore13 = new JLabel(list[2].getHomeTeamScore().toString());
		pane.add(lblHomescore13, "cell 2 3");
		
		JLabel seperator13 = new JLabel(":");
		pane.add(seperator13, "cell 3 3");
		
		JLabel lblAwayscore13 = new JLabel(list[2].getAwayTeamScore().toString());
		pane.add(lblAwayscore13, "cell 4 3");
		
		JLabel lblAway_13 = new JLabel(list[2].getAwayTeam().getTeamName());
		pane.add(lblAway_13, "cell 5 3");
		
		JLabel Date12 = new JLabel(list[3].getDate());
		pane.add(Date12, "cell 0 4");
		
		JLabel lblHome12 = new JLabel(list[3].getHomeTeam().getTeamName());
		pane.add(lblHome12, "cell 1 4");
		
		JLabel lblHomescore12 = new JLabel(list[3].getHomeTeamScore().toString());
		pane.add(lblHomescore12, "cell 2 4");
		
		JLabel seperator12 = new JLabel(":");
		pane.add(seperator12, "cell 3 4");
		
		JLabel lblAwayScore12 = new JLabel(list[3].getAwayTeamScore().toString());
		pane.add(lblAwayScore12, "cell 4 4");
		
		JLabel lblAway_12 = new JLabel(list[3].getAwayTeam().getTeamName());
		pane.add(lblAway_12, "cell 5 4");
		
		JLabel Date11 = new JLabel(list[4].getDate());
		pane.add(Date11, "cell 0 5");
		
		JLabel lblHome11 = new JLabel(list[4].getHomeTeam().getTeamName());
		pane.add(lblHome11, "cell 1 5");
		
		JLabel lblHomescore11 = new JLabel(list[4].getHomeTeamScore().toString());
		pane.add(lblHomescore11, "cell 2 5");
		
		JLabel seperator11 = new JLabel(":");
		pane.add(seperator11, "cell 3 5");
		
		JLabel lblAwayscore11 = new JLabel(list[4].getAwayTeamScore().toString());
		pane.add(lblAwayscore11, "cell 4 5");
		
		JLabel lblAway_11 = new JLabel(list[4].getAwayTeam().getTeamName());
		pane.add(lblAway_11, "cell 5 5");
		
		JLabel Date10 = new JLabel(list[5].getDate());
		pane.add(Date10, "cell 0 6");
		
		JLabel lblHome10 = new JLabel(list[5].getHomeTeam().getTeamName());
		pane.add(lblHome10, "cell 1 6");
		
		JLabel lblHomescore10 = new JLabel(list[5].getHomeTeamScore().toString());
		pane.add(lblHomescore10, "cell 2 6");
		
		JLabel seperator10 = new JLabel(":");
		pane.add(seperator10, "cell 3 6");
		
		JLabel lblAwayscore10 = new JLabel(list[5].getAwayTeamScore().toString());
		pane.add(lblAwayscore10, "cell 4 6");
		
		JLabel lblAway_10 = new JLabel(list[5].getAwayTeam().getTeamName());
		pane.add(lblAway_10, "cell 5 6");
		
		JLabel Date9 = new JLabel(list[6].getDate());
		pane.add(Date9, "cell 0 7");
		
		JLabel lblHome9 = new JLabel(list[6].getHomeTeam().getTeamName());
		pane.add(lblHome9, "cell 1 7");
		
		JLabel lblHomescore9 = new JLabel(list[6].getHomeTeamScore().toString());
		pane.add(lblHomescore9, "cell 2 7");
		
		JLabel seperator9 = new JLabel(":");
		pane.add(seperator9, "cell 3 7");
		
		JLabel lblAwayscore9 = new JLabel(list[6].getAwayTeamScore().toString());
		pane.add(lblAwayscore9, "cell 4 7");
		
		JLabel lblAway_9 = new JLabel(list[6].getAwayTeam().getTeamName());
		pane.add(lblAway_9, "cell 5 7");
		
		JLabel Date8 = new JLabel(list[7].getDate());
		pane.add(Date8, "cell 0 8");
		
		JLabel lblHome8 = new JLabel(list[7].getHomeTeam().getTeamName());
		pane.add(lblHome8, "cell 1 8");
		
		JLabel lblHomescore8 = new JLabel(list[7].getHomeTeamScore().toString());
		pane.add(lblHomescore8, "cell 2 8");
		
		JLabel seperator8 = new JLabel(":");
		pane.add(seperator8, "cell 3 8");
		
		JLabel lblAwayscore8 = new JLabel(list[7].getAwayTeamScore().toString());
		pane.add(lblAwayscore8, "cell 4 8");
		
		JLabel lblAway_8 = new JLabel(list[7].getAwayTeam().getTeamName());
		pane.add(lblAway_8, "cell 5 8");
		
		JLabel Date7 = new JLabel(list[8].getDate());
		pane.add(Date7, "cell 0 9");
		
		JLabel lblHome7 = new JLabel(list[8].getHomeTeam().getTeamName());
		pane.add(lblHome7, "cell 1 9");
		
		JLabel lblHomescore7 = new JLabel(list[8].getHomeTeamScore().toString());
		pane.add(lblHomescore7, "cell 2 9");
		
		JLabel seperator7 = new JLabel(":");
		pane.add(seperator7, "cell 3 9");
		
		JLabel lblAwayscore7 = new JLabel(list[8].getAwayTeamScore().toString());
		pane.add(lblAwayscore7, "cell 4 9");
		
		JLabel lblAway_7 = new JLabel(list[8].getAwayTeam().getTeamName());
		pane.add(lblAway_7, "cell 5 9");
		
		JLabel Date6 = new JLabel(list[9].getDate());
		pane.add(Date6, "cell 0 10");
		
		JLabel lblHome6 = new JLabel(list[9].getHomeTeam().getTeamName());
		pane.add(lblHome6, "cell 1 10");
		
		JLabel lblHomescore6 = new JLabel(list[9].getHomeTeamScore().toString());
		pane.add(lblHomescore6, "cell 2 10");
		
		JLabel seperator6 = new JLabel(":");
		pane.add(seperator6, "cell 3 10");
		
		JLabel lblAwayscore6 = new JLabel(list[9].getAwayTeamScore().toString());
		pane.add(lblAwayscore6, "cell 4 10");
		
		JLabel lblAway_6 = new JLabel(list[9].getAwayTeam().getTeamName());
		pane.add(lblAway_6, "cell 5 10");
		
		JLabel Date5 = new JLabel(list[10].getDate());
		pane.add(Date5, "cell 0 11");
		
		JLabel lblHome5 = new JLabel(list[10].getHomeTeam().getTeamName());
		pane.add(lblHome5, "cell 1 11");
		
		JLabel lblHomeScore5 = new JLabel(list[10].getHomeTeamScore().toString());
		pane.add(lblHomeScore5, "cell 2 11");
		
		JLabel seperator5 = new JLabel(":");
		pane.add(seperator5, "cell 3 11");
		
		JLabel lblAwayscore5 = new JLabel(list[10].getAwayTeamScore().toString());
		pane.add(lblAwayscore5, "cell 4 11");
		
		JLabel lblAway_5 = new JLabel(list[10].getAwayTeam().getTeamName());
		pane.add(lblAway_5, "cell 5 11");
		
		JLabel Date4 = new JLabel(list[11].getDate());
		pane.add(Date4, "cell 0 12");
		
		JLabel lblHome4 = new JLabel(list[11].getHomeTeam().getTeamName());
		pane.add(lblHome4, "cell 1 12");
		
		JLabel lblHomescore4 = new JLabel(list[11].getHomeTeamScore().toString());
		pane.add(lblHomescore4, "cell 2 12");
		
		JLabel seperator4 = new JLabel(":");
		pane.add(seperator4, "cell 3 12");
		
		JLabel lblAwayscore4 = new JLabel(list[11].getAwayTeamScore().toString());
		pane.add(lblAwayscore4, "cell 4 12");
		
		JLabel lblAway_4 = new JLabel(list[11].getAwayTeam().getTeamName());
		pane.add(lblAway_4, "cell 5 12");
		
		JLabel Date3 = new JLabel(list[12].getDate());
		pane.add(Date3, "cell 0 13");
		
		JLabel lblHome3 = new JLabel(list[12].getHomeTeam().getTeamName());
		pane.add(lblHome3, "cell 1 13");
		
		JLabel lblHomescore3 = new JLabel(list[12].getHomeTeamScore().toString());
		pane.add(lblHomescore3, "cell 2 13");
		
		JLabel seperator3 = new JLabel(":");
		pane.add(seperator3, "cell 3 13");
		
		JLabel lblAwayscore3 = new JLabel(list[12].getAwayTeamScore().toString());
		pane.add(lblAwayscore3, "cell 4 13");
		
		JLabel lblAway_3 = new JLabel(list[12].getAwayTeam().getTeamName());
		pane.add(lblAway_3, "cell 5 13");
		
		JLabel Date2 = new JLabel(list[13].getDate());
		pane.add(Date2, "cell 0 14");
		
		JLabel lblHome2 = new JLabel(list[13].getHomeTeam().getTeamName());
		pane.add(lblHome2, "cell 1 14");
		
		JLabel lblHomescore2 = new JLabel(list[13].getHomeTeamScore().toString());
		pane.add(lblHomescore2, "cell 2 14");
		
		JLabel seperator2 = new JLabel(":");
		pane.add(seperator2, "cell 3 14");
		
		JLabel lblAwayscore2 = new JLabel(list[13].getAwayTeamScore().toString());
		pane.add(lblAwayscore2, "cell 4 14");
		
		JLabel lblAway_2 = new JLabel(list[13].getAwayTeam().getTeamName());
		pane.add(lblAway_2, "cell 5 14");
		
		JLabel Date1 = new JLabel(list[14].getDate());
		pane.add(Date1, "cell 0 15");
		
		JLabel lblHome1 = new JLabel(list[14].getHomeTeam().getTeamName());
		pane.add(lblHome1, "cell 1 15");
		
		JLabel lblHomescore1 = new JLabel(list[14].getHomeTeamScore().toString());
		pane.add(lblHomescore1, "cell 2 15");
		
		JLabel seperator1 = new JLabel(":");
		pane.add(seperator1, "cell 3 15");
		
		JLabel lblAwayscore1 = new JLabel(list[14].getAwayTeamScore().toString());
		pane.add(lblAwayscore1, "cell 4 15");
		
		JLabel lblAway_1 = new JLabel(list[14].getAwayTeam().getTeamName());
		pane.add(lblAway_1, "cell 5 15");
		
		
		
		
		return pane;
	}
	
	
	
	
}
