package system;

import java.util.*;

public class CountriesDropDownList {

	// Should be made a singleton
	private String countries[] = new String[20];
	
	/**
	 * Default Constructor
	 */
	public CountriesDropDownList() {
		
		String Country = "Country";
		String Brazil = "Brazil";
		String France = "France";
		String England = "England";
		String Germany = "Germany";
		String Mexico = "Mexico";
		String Russia = "Russia";
	
		countries[0] = Country;
		countries[1] = Brazil;
		countries[2] = France;
		countries[3] = England;
		countries[4] = Germany;
		countries[5] = Mexico;
		countries[6] = Russia;

	}
	
	/**
	 * Adds a country to the list of countries
	 * @return True if the country was added successfully
	 */
	public boolean addCountry() {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * Gets the list of current countries in the list and
	 * @return s them as an array
	 */
	public String[] getListOfCountries() {
		return countries;
	}
	
}
