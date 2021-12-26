package ensa.web.project.responses;





public class LocationResponse {
	

	private String locationId;

	private String studentId;

	private String dateEntree;

	private String longitude;

	private String latitude;
	
	private String dureeDeLocation;
	

	

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


	
	

}
