package system;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class TeamMapper implements RowMapper<Team> {
   public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
      Team team = new Team();
      // May need a date formatter here
      //game.setDate(rs.getInt("id"));
//	      game.setHomeTeam(new Team(rs.getString("HomeTeam")));
//	      game.setAwayTeam(new Team(rs.getString("AwayTeam")));
//	      game.setHomeTeamScore(rs.getInt("FTHG"));
//	      game.setAwayTeamScore(rs.getInt("FTAG"));      
      
      return team;
   }
}

