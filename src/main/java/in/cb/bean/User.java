package in.cb.bean;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String pass;
	private String phone;
	private String designation;
	private String gender;
	private String bio;
	
	public User() {	}
	
	
	public User(String name, String email, String pass, String phone, String designation, String gender, String bio) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.designation = designation;
		this.gender = gender;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	
	
	
}
