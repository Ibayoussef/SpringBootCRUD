package ensa.web.project.entities;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;


@Entity(name="student")
public class StudentEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8306896345723596462L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=100, nullable=false)
	private String studentId;
	
	@Column(nullable=false,length=50)
	private String firstName;
	
	@Column(nullable=false,length=50)
	private String lastName;
	
	@Column(nullable=false, length=120, unique=true)
	private String email;
	
	@Column(nullable=true)
	private String image;
	
	@Column(nullable=true)
	private String Gender;
	
	@Column(nullable=true)
	private String home;
	
	@Column(nullable=false)
	private String encryptedPassword;
	
	@Column(nullable=false)
	private String password;
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}



	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}



	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	private PostEntity post;

	
	


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



	public String getHome() {
		return home;
	}



	public void setHome(String string) {
		this.home = string;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public PostEntity getPost() {
		return post;
	}



	public void setPost(PostEntity posts) {
		this.post = posts;
	}
	

	
	

}
