package ensa.web.project.shared.dto;

import java.io.Serializable;





public class StudentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1109015895656272697L;



	private long id;
	
	private String studentId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;

	private String image;
	
	private String Gender;
	
	private String home;
	
	private String encryptedPassword;
	
	private PostDto post;

	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto posts) {
		this.post = posts;
	}
	
	

}
