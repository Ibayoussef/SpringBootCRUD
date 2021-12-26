package ensa.web.project.shared.dto;

import java.io.Serializable;




public class LocationDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5735753128231574773L;

	private long id;

	private String locationId;

	private String studentId;

	private String dateEntree;
	
	private String longitude;

	private String latitude;

	private String dureeDeLocation;
	
	private PostDto post;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
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

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getDureeDeLocation() {
		return dureeDeLocation;
	}

	public void setDureeDeLocation(String dureeDeLocalisation) {
		this.dureeDeLocation = dureeDeLocalisation;
	}

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}


	
	

}
