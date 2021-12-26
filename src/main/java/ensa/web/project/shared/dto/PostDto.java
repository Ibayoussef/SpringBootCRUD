package ensa.web.project.shared.dto;

import java.io.Serializable;
import java.util.List;


public class PostDto implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3905957598644945256L;



	private long id;

	private String postId;

	private String description;

	private String prix;

	private String region;

	private String ville;

	private String dateDePublication;

	private String dureeDeDisponibilite;

	private String nombreDeCollegues;

	private String maxNombreDeCollegues;
	
	private String gender;

    private String status;
	
	private StudentDto student;
	

	private List<PostImageDto> images;
	
	private PostDetailsDto details;

	private LocationDto location;
	
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

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public List<PostImageDto> getImages() {
		return images;
	}

	public void setImages(List<PostImageDto> images) {
		this.images = images;
	}

	public PostDetailsDto getDetails() {
		return details;
	}

	public void setDetails(PostDetailsDto details) {
		this.details = details;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}

	
	
	

}
