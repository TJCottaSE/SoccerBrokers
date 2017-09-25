package system;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TeamJDBCTemplate {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   public void create(String name, Integer age) {
	      String SQL = "insert into Student (name, age) values (?, ?)";
	      jdbcTemplateObject.update( SQL, name, age);
	      System.out.println("Created Record Name = " + name + " Age = " + age);
	      return;
	   }
	   public Team getTeam(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      Team team = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new TeamMapper());
	      
	      return team;
	   }
	   /**
	    * Get the names of the teams in the league
	    * @return a list with a team name for each team in the league (no duplicates)
	    */
	   public List<Team> listTeamNames(){
		   String SQL = "select distinct HomeTeam as TeamNames from Soccer.England_2017_2018 union select distinct AwayTeam as TeamNames from Soccer.England_2017_2018";      
		   List<Team> teams = jdbcTemplateObject.query(SQL, new LeagueTableMapper());
		   return teams;
	   }
	   public void delete(Integer id) {
	      String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
	   public void update(Integer id, Integer age){
	      String SQL = "update Student set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, age, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	   }
}
