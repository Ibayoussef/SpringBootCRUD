package ensa.web.project.responses;

import java.util.List;

public class PostResponse {
	


	private String postId;

	private String description;

	private String prix;

	private String region;

	private String ville;
	
	private String gender;

	private String dateDePublication;

	private String dureeDeDisponibilite;

	private String nombreDeCollegues;

	private String maxNombreDeCollegues;


	private StudentResponse student;
	
	private List<PostImageResponse> images;
	
	private PostDetailsResponse details;
	
	private LocationResponse  location;
	
	private String status;
	
	private String title;
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public StudentResponse getStudent() {
		return student;
	}

	public void setStudent(StudentResponse student) {
		this.student = student;
	}

	public List<PostImageResponse> getImages() {
		return images;
	}

	public void setImages(List<PostImageResponse> images) {
		this.images = images;
	}

	public PostDetailsResponse getDetails() {
		return details;
	}

	public void setDetails(PostDetailsResponse details) {
		this.details = details;
	}

	public LocationResponse getLocation() {
		return location;
	}

	public void setLocation(LocationResponse location) {
		this.location = location;
	}
	
	
	
	
	

}
