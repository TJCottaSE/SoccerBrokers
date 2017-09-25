package system;

import java.util.Date;

public class Game {
	
	private Team homeTeam;
	private Team awayTeam;
	private Integer homeTeamScore = -1;
	private Integer awayTeamScore = -1;
	private String date;
	private Double homeTeamOdds;
	private Double awayTeamOdds;
	private Double drawOdds;
	
	public Game() {
		homeTeam = new Team();
		awayTeam = new Team();
	}
	
	public Game(Team home, int homeScore, int awayScore, Team away, String date) {
		homeTeam = home;
		homeTeamScore = homeScore;
		awayTeamScore = awayScore;
		awayTeam = away;
		this.setDate(date);
	}
	
	public Game(Team home, Team away, String date, Double homeOdds, Double awayOdds, Double drawOdds) {
		this.setHomeTeam(home);
		this.setAwayTeam(away);
		this.setDate(date);
		this.setHomeTeamOdds(homeOdds);
		this.setAwayTeamOdds(awayOdds);
		this.setDrawOdds(drawOdds);
	}
	
	/**
	 * @return the homeTeam
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}
	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	/**
	 * @return the awayTeam
	 */
	public Team getAwayTeam() {
		return awayTeam;
	}
	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	/**
	 * @return the homeTeamScore
	 */
	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}
	/**
	 * @param homeTeamScore the homeTeamScore to set
	 */
	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	/**
	 * @return the awayTeamScore
	 */
	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}
	/**
	 * @param awayTeamScore the awayTeamScore to set
	 */
	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the homeTeamOdds
	 */
	public Double getHomeTeamOdds() {
		return homeTeamOdds;
	}
	/**
	 * @param homeTeamOdds the homeTeamOdds to set
	 */
	public void setHomeTeamOdds(Double homeTeamOdds) {
		this.homeTeamOdds = homeTeamOdds;
	}
	/**
	 * @return the awayTeamOdds
	 */
	public Double getAwayTeamOdds() {
		return awayTeamOdds;
	}
	/**
	 * @param awayTeamOdds the awayTeamOdds to set
	 */
	public void setAwayTeamOdds(Double awayTeamOdds) {
		this.awayTeamOdds = awayTeamOdds;
	}
	/**
	 * @return the drawOdds
	 */
	public Double getDrawOdds() {
		return drawOdds;
	}
	/**
	 * @param drawOdds the drawOdds to set
	 */
	public void setDrawOdds(Double drawOdds) {
		this.drawOdds = drawOdds;
	}

}
