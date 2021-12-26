package ensa.web.project.requests;


import java.util.List;


public class PostRequest {
	

	private String description;

	private String prix;

	private String region;

	private String ville;
	
	private String gender;

	private String dateDePublication;

	private String dureeDeDisponibilite;

	private String nombreDeCollegues;

	private String maxNombreDeCollegues;
	

	private List<PostImageRequest> images;
	
	private PostDetailsRequest details;
	
	private LocationRequest  location;
	
	private String title;
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public List<PostImageRequest> getImages() {
		return images;
	}

	public void setImages(List<PostImageRequest> images) {
		this.images = images;
	}

	public PostDetailsRequest getDetails() {
		return details;
	}

	public void setDetails(PostDetailsRequest details) {
		this.details = details;
	}

	public LocationRequest getLocation() {
		return location;
	}

	public void setLocation(LocationRequest location) {
		this.location = location;
	}
	
	

	
	
	


}
