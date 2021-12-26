package ensa.web.project.requests;

public class LocationRequest {

	private String studentId;

	private String status;

	private String longitude;

	private String latitude;

	private String dateEntree;

	private String dureeDeLocation;

	private PostRequest post;
	
	

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longtitude) {
		this.longitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDureeDeLocation() {
		return dureeDeLocation;
	}

	public void setDureeDeLocation(String dureeDeLocalisation) {
		this.dureeDeLocation = dureeDeLocalisation;
	}

	public PostRequest getPost() {
		return post;
	}

	public void setPost(PostRequest post) {
		this.post = post;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

}
