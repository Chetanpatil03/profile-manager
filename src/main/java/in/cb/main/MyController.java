package in.cb.main;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.cb.bean.User;
import in.cb.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
    public String home() {
        return "index"; // maps to /WEB-INF/views/index.jsp
    }
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/home")
	public String getHomePage(HttpServletRequest request, HttpServletResponse response) {
		 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		    response.setHeader("Pragma", "no-cache");
		    response.setDateHeader("Expires", 0);

		    HttpSession session = request.getSession(false);
		    if (session == null || session.getAttribute("loggedInUser") == null) {
		        return "redirect:/login";
		    }

		    return "home";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup";
	}
	
	@GetMapping("/edit")
	public String getEditPage() {
		return "edit";
	}
	
//	@PostMapping("/signupForm")
//	public String signupForm(@ModelAttribute("model") User user) {
//		
//		System.out.println("Name :: "+user.getName());
//		System.out.println("Email :: "+user.getEmail());
//		System.out.println("pass :: "+user.getPass());
//		System.out.println("phone :: "+user.getPhone());
//		System.out.println("Designation : "+user.getDesignation());
//		System.out.println("Gender :: "+user.getGender());
//		System.out.println("Bio :: "+user.getBio());
//		
//		return "login";n
//	}
	
	@PostMapping("/saveUser")
	public String signup(@ModelAttribute User user,Model model) {
		if (userService.register(user)) {
			return "redirect:/loginForm?success=1";
		}
		else {
			model.addAttribute("error", "Failed to create account");
            return "signup"; //--> signup.jsp
		}
	}
	
	@PostMapping("/loginForm")
	public String login(
			@RequestParam("email") String email,
	        @RequestParam("password") String password,
	        Model model,
	        HttpSession session) {
		
//		userService.getPass();

	    User user = userService.authenticate(email, password);

	    if (user == null) {
	        model.addAttribute("error", "Invalid username or password");
	        return "login"; // login.jsp
	    }

	    session.setAttribute("loggedInUser", user);
	    return "redirect:/home";
	}

	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/loginForm")
	public String showLoginForm() {
	    return "login"; // login.jsp
	}

	
	@PostConstruct
	public void init() {
	    System.out.println("MyController LOADED");
	}
}

//select id,name,email,phone,designation,gender,bio from users;
