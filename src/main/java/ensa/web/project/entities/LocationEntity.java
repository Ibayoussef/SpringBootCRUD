package ensa.web.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name="location")
public class LocationEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2934433190508118288L;

	@Id
	@GeneratedValue
	private long id;

	@Column(length=100, nullable=false)
	private String locationId;
	
	@Column(length=100, nullable=true)
	private String studentId;
	
	
	@Column(length=30, nullable=false)
	private String dateEntree;
		
	@Column(length=30, nullable=false)
	private String dureeDeLocation;
	
	@Column(length=30)
	private String longitude;
	
	@Column(length=30, nullable=false)
	private String latitude;
	
	@OneToOne
	@JoinColumn(name="post_id")
	private PostEntity posti;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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


	public PostEntity getPost() {
		return posti;
	}

	public void setPost(PostEntity post) {
		this.posti = post;
	}
	
	

}
