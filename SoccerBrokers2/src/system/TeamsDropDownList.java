package system;

import java.util.*;

public class TeamsDropDownList {

	// Should be made a singleton
	private String team[] = new String[20];
	
	/**
	 * Default Constructor
	 */
	public TeamsDropDownList() {
		
	String Team = "Team";
	String Arsenal = "Arsenal";
	String Cortiba = "Cortiba";
	String Ural = "Ural";
	String Brossia_Dortmund = "Brossia Dortmund";
	String Monarcas = "Monarcs";
	String Earthquakes = "Earthquakes";

	team[0] = Team;
	team[1] = Arsenal;
	team[2] = Cortiba;
	team[3] = Ural;
	team[4] = Brossia_Dortmund;
	team[5] = Monarcas;
	team[6] = Earthquakes;

	}
	
	/**
	 * Adds a country to the list of countries
	 * @return True if the country was added successfully
	 */
	public boolean addTeam() {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * Gets the list of current countries in the list and
	 * @return s them as an array
	 */
	public String[] getListOfTeams() {
		return team;
	}
	
}