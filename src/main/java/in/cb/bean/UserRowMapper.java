package in.cb.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPass(rs.getString("pass"));
		user.setPhone(rs.getString("phone"));
		user.setDesignation(rs.getString("designation"));
		user.setGender(rs.getString("gender"));
		user.setBio(rs.getString("bio"));
		
		return user;
	}

}
