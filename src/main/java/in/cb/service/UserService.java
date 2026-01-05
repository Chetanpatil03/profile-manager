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
	
	public boolean update(User user) {
		return true;e
	}
	
//	public void getPass() {
//		String pass = userdao.getPass();
//		System.out.println(encoder.encode(pass));
//	}
	
	
	
	
}
