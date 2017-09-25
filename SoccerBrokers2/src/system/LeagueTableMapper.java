package system;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LeagueTableMapper implements RowMapper<Team> {
   public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
      Team team = new Team(rs.getString("TeamNames"));   
      
      return team;
   }
}
