package system;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GameMapper implements RowMapper<Game> {
   public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
      Game game = new Game();
      // May need a date formatter here
      game.setDate(rs.getString("Date"));
      game.setHomeTeam(new Team(rs.getString("HomeTeam")));
      game.setAwayTeam(new Team(rs.getString("AwayTeam")));
      game.setHomeTeamScore(rs.getInt("FTHG"));
      game.setAwayTeamScore(rs.getInt("FTAG"));      
      
      return game;
   }
}