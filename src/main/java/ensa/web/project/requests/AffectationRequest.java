package ensa.web.project.requests;

public class AffectationRequest {
	
	private String studentId;

	private String postId;

	private String dateDeEntree;

	private String dureeDeLocation;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getDateDeEntree() {
		return dateDeEntree;
	}

	public void setDateDeEntree(String dateDeEntree) {
		this.dateDeEntree = dateDeEntree;
	}

	public String getDureeDeLocation() {
		return dureeDeLocation;
	}

	public void setDureeDeLocation(String dureeDeLocation) {
		this.dureeDeLocation = dureeDeLocation;
	}

	
}
