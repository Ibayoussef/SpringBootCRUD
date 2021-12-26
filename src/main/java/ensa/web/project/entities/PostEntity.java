package ensa.web.project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name="post")
public class PostEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4514045653305046306L;



	
	@Id
	@GeneratedValue
	private long id;

	@Column(length=100, nullable=false)
	private String postId;
	
	@Column(length=100, nullable=false)
	private String description;
	
	@Column(length=30, nullable=false)
	private String prix;
	
	@Column(length=30, nullable=false)
	private String region;
	
	@Column(length=30, nullable=false)
	private String ville;
	
	@Column(nullable=true)
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(length=30, nullable=false)
	private String dateDePublication;
	
	
	@Column(length=30, nullable=false)
	private String dureeDeDisponibilite;
	
	@Column(length=30, nullable=false)
	private String nombreDeCollegues;
	
	@Column(length=30, nullable=false)
	private String maxNombreDeCollegues;
	
	@Column(length=30, nullable=false)
	private String status;

	@OneToOne
	@JoinColumn(name="student_id")
	private StudentEntity student;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<PostImageEntity> images;
	
	
	@OneToOne(mappedBy = "posti",cascade = CascadeType.ALL)
	private LocationEntity location;
	
	@OneToOne(mappedBy = "post",cascade = CascadeType.ALL)
	private PostDetailsEntity details;
	
	@Column(length=50, nullable=false)
	private String title;
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateDePublication() {
		return dateDePublication;
	}

	public void setDateDePublication(String dateDePublication) {
		this.dateDePublication = dateDePublication;
	}

	public String getDureeDeDisponibilite() {
		return dureeDeDisponibilite;
	}

	public void setDureeDeDisponibilite(String dureeDeDisponibilite) {
		this.dureeDeDisponibilite = dureeDeDisponibilite;
	}

	public String getNombreDeCollegues() {
		return nombreDeCollegues;
	}

	public void setNombreDeCollegues(String nombreDeCollegues) {
		this.nombreDeCollegues = nombreDeCollegues;
	}

	public String getMaxNombreDeCollegues() {
		return maxNombreDeCollegues;
	}

	public void setMaxNombreDeCollegues(String maxNombreDeCollegues) {
		this.maxNombreDeCollegues = maxNombreDeCollegues;
	}

	public List<PostImageEntity> getImages() {
		return images;
	}

	public void setImages(List<PostImageEntity> images) {
		this.images = images;
	}

	public PostDetailsEntity getDetails() {
		return details;
	}

	public void setDetails(PostDetailsEntity details) {
		this.details = details;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
