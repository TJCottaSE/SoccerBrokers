package system;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class GameJDBCTemplate {
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
	   public Game getGame(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      Game game = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new GameMapper());
	      
	      return game;
	   }
	   public List<Game> listGames() {
	      String SQL = "select Date, HomeTeam, FTHG, FTAG, AwayTeam from Soccer.England_2017_2018";
	      List <Game> games = jdbcTemplateObject.query(SQL, new GameMapper());
	      return games;
	   }
	   public List<Game> listGames(String databaseTableName){
		   String SQL = "select Date, HomeTeam, FTHG, FTAG, AwayTeam from Soccer." + databaseTableName;
		   List<Game> games = jdbcTemplateObject.query(SQL, new GameMapper());
		   return games;
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