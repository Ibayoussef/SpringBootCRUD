package ensa.web.project.responses;





public class StudentResponse {
	

	private String studentId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	private String image;
	
	private String Gender;
	
	private String home;
	
	private String encryptedPassword;
	
//	private PostResponse post;
	
	
	
	

	public String getStudentId() {
		return studentId;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}


	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String password) {
		this.encryptedPassword = password;
	}




	
	
	
	
	

}
