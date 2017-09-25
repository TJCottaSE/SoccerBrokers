package system;

import java.util.LinkedList;
import java.util.List;

public class Team {
	private String name = "";
	private Integer wins = 0;
	private Integer draws = 0;
	private Integer losses = 0;
	private Integer id = null;
	private List<Game> history = null;
	
	public Team() {
		history = new LinkedList<Game>();
	}
	
	public Team(String name) {
		this.name = name;
	}
	
	public Team(String name, int id, int wins, int draws, int losses) {
		this.name = name;
		this.setId(id);
		this.wins = wins;
		this.draws = draws;
		this.losses = losses;
	}
	
	public String getTeamName() {
		return name;
	}
	
	public void setTeamName(String name) {
		this.name = name;
	}
	
	public Integer getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public void addWin() {
		wins++;
	}
	
	public Integer getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public void addLoss() {
		losses++;
	}
	
	public Integer getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	public void addGameToHistory(Game game) {
		history.add(game);
	}
	
	public List<Game> getGameHistory(){
		return history;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
