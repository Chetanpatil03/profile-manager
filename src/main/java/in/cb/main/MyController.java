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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "index"; // --> maps to /WEB-INF/views/index.jsp
	}
	
	@GetMapping("/forgot-password")
	public String getForgot() {
		return "forgot"; // --> maps to /WEB-INF/views/forgot.jsp
	}
	
	@GetMapping("/reset-password")
	public String getResetPage() {
		return "reset-password";
	}

	@GetMapping("/loginForm") // --> get mapping for refesh or url 
	public String showLoginForm() {
		return "login"; // --> maps to /WEB-INF/views/login.jsp
	}
	
	@PostConstruct
	public void init() {
		System.out.println("MyController LOADED");
	}
	
	@GetMapping("/home")
	public String getHomePage() {
		return "home"; // --> maps to /WEB-INF/views/home.jsp
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";  //--> maps to /WEB-INF/views/login.jsp
	}

	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup"; //--> maps to /WEB-INF/views/signup.jsp
	}

	//--> Safe guarding edit page ==> 
	
	@GetMapping("/edit")
	public String editProfile(HttpSession session, Model model) {
		
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		
		if (loggedInUser == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("user", loggedInUser);
		return "edit"; // edit.jsp
	}
	
	// ==> Operations 
	
	// => 1. Register
	@PostMapping("/saveUser")
	public String signup(@ModelAttribute User user, Model model) {
		if (userService.register(user)) {
			return "redirect:/loginForm?success=1";
		} else {
			model.addAttribute("error", "Failed to create account");
			return "signup"; // --> signup.jsp
		}
	}

	// => 2. Login
	@PostMapping("/loginForm")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {

		User user = userService.authenticate(email, password);

		if (user == null) {
			model.addAttribute("error", "Invalid username or password");
			return "login"; // login.jsp
		}

		session.setAttribute("loggedInUser", user);
		System.out.println(session.getAttribute("loggedInUser"));

		return "redirect:/home";
	}

	// => 3. Edit/ Update
	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute User formUser, HttpSession session,
			RedirectAttributes redirectAttributes) {

		User sessionUser = (User) session.getAttribute("loggedInUser");

		if (sessionUser == null) {
			return "redirect:/login";
		}

		// 🔐 Force ID from session (prevent tampering)
		formUser.setId(sessionUser.getId());

		boolean updated = userService.updateUser(formUser);

		if (!updated) {
			redirectAttributes.addFlashAttribute("error", "Failed to update profile");
			return "redirect:/edit";
		}

		// ✅ Fetch fresh user from DB
		User updatedUser = userService.getUserById(sessionUser.getId());

		if (updatedUser == null) {
		    session.invalidate();
		    return "redirect:/login";
		}


		// ✅ Update session with complete object
		session.setAttribute("loggedInUser", updatedUser);

		redirectAttributes.addFlashAttribute("success", "Profile updated successfully");
		System.out.println(session.getAttribute("loggedInUser"));
		return "redirect:/home";
	}
	
	// => 4. Delete 
	@PostMapping("/deleteProfile")
	public String deleteAccount(
			@RequestParam("confirmEmail") String confirmEmail,
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		
		User sessionUser = (User) session.getAttribute("loggedInUser");

		if (sessionUser == null) {
			return "redirect:/login";
		}
		
		String email = sessionUser.getEmail();
		if (email.equals(confirmEmail)) {
			if (userService.deleteUser(sessionUser.getId())) {
				session.invalidate();
				redirectAttributes.addFlashAttribute( "success", "Your account has been deleted successfully.");
				return "redirect:/index";

			}else {
				redirectAttributes.addFlashAttribute("error", "Delete operation Failed");
				return "redirect:/home";			
			}
		}
		else {
			redirectAttributes.addFlashAttribute("error", "Email does not matched");
			return "redirect:/home";
		}
	}

	// => 5. Logout
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();

		return "redirect:/";
	}
	
	// => 6. Forgot Password
	@PostMapping("/forgotPassword")
	public String handleForgotPassword(
	        @RequestParam("email") String email,
	        @RequestParam("phone") String phoneLastDigits,
	        HttpSession session,
	        RedirectAttributes redirectAttributes) {

	    User user = userService.getUserByEmail(email);

	    if (user == null) {
	        redirectAttributes.addFlashAttribute(
	            "error", "Invalid email or phone details"
	        );
	        return "redirect:/forgot-password";
	    }

	    String phone = user.getPhone();

	    if (phone == null || phone.length() < 4) {
	        redirectAttributes.addFlashAttribute(
	            "error", "Invalid email or phone details"
	        );
	        return "redirect:/forgot-password";
	    }

	    String lastFour = phone.substring(phone.length() - 4);

	    if (!lastFour.equals(phoneLastDigits)) {
	        redirectAttributes.addFlashAttribute(
	            "error", "Invalid email or phone details"
	        );
	        return "redirect:/forgot-password";
	    }

	    session.removeAttribute("resetUserId");

	    session.setAttribute("resetUserId", user.getId());

	    return "redirect:/reset-password";
	}

	
	// => 7. Reset password
    @PostMapping("/resetPassword")
    public String handleResetPassword(
            @RequestParam("newPassword") String newPassword,
            @RequestParam("confirmPassword") String confirmPassword,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Integer userId = (Integer) session.getAttribute("resetUserId");

        if (userId == null) {
            redirectAttributes.addFlashAttribute(
                "error", "Session expired. Please try again."
            );
            return "redirect:/forgot-password";
        }

        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute(
                "error", "Passwords do not match"
            );
            return "redirect:/reset-password";
        }

        boolean updated = userService.updatePassword(userId, newPassword);

        if (!updated) {
            redirectAttributes.addFlashAttribute(
                "error", "Failed to reset password"
            );
            return "redirect:/reset-password";
        }

        // Clear reset session
        session.removeAttribute("resetUserId");

        redirectAttributes.addFlashAttribute(
            "success", "Password reset successfully. Please login."
        );

        return "redirect:/login";
    }



}

//select id,name,email,phone,designation,gender,bio from users;
