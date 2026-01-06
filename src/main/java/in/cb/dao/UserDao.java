package in.cb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.cb.bean.User;
import in.cb.bean.UserRowMapper;

@Repository
public class UserDao {
	
	@Autowired 
	JdbcTemplate template;
	
	public User login(String email) {
		String sql = "select * from users where email = ?";
		try {
			return template.queryForObject(sql, new UserRowMapper(), email);			
		}catch (EmptyResultDataAccessException e) {
	        return null; // ❗ LOGIN FAILED (NORMAL CASE)
	    }
	}
	
	public boolean signup(User user) {
		String sql = "insert into users(name,email,pass,phone,designation,gender,bio) values (?,?,?,?,?,?,?)";
		return template.update(
				sql,
				user.getName(),
				user.getEmail(),
				user.getPass(),
				user.getPhone(),
				user.getDesignation(),
				user.getGender(),
				user.getBio()
				) > 0;
	}
	
	public boolean update(User user) {
		String sql = "UPDATE users SET name =?, phone =?, designation=?, gender=?, bio = ? WHERE id = ?";
		return template.update(
				sql,
				user.getName(),
				user.getPhone(),
				user.getDesignation(),
				user.getGender(),
				user.getBio(),
				user.getId()
				) > 0;
	}
	
	public User getUserById(int id) {
		String query = "select * from users where id = ?";
		try {
			return template.queryForObject(query, new UserRowMapper(), id);			
		}catch (EmptyResultDataAccessException e) {
	        return null; // ❗ User not found FAILED (NORMAL CASE)
	    }
	}
	
	public String getPass(int id) {
		String sql = "select pass from users where id = ?";
		return template.queryForObject(sql, String.class,id);
	}
//	
	public boolean deleteUser(int id) {
		String query = "delete from users where id = ?";
		return template.update(query,id) > 0;
	}
	
}
