package in.cb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.cb.bean.User;
import in.cb.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	public UserDao userdao;
	
	@Autowired
	public BCryptPasswordEncoder encoder;
	
	public User authenticate(String email, String password) {
		User user = userdao.login(email);
		
		if (user != null && encoder.matches(password, user.getPass())) {
	        return user; // ✅ login success
	    }
		
		return null;
	}
	
	public boolean register(User user) {
		String encodedPass = encoder.encode(user.getPass());
		user.setPass(encodedPass);
		return userdao.signup(user);
	}
	
	public boolean updateUser(User user) {
	    if (user == null || user.getId() <= 0) {
	        return false;
	    }
	    return userdao.update(user);
	}

	
	public User getUserById(int id) {
		if (id <= 0) {
			return null;
		}
		else {
			return userdao.getUserById(id);
		}
	}
	
//	public void getPass() {
//		String pass = userdao.getPass();
//		System.out.println(encoder.encode(pass));
//	}
	
	
	
	
}
