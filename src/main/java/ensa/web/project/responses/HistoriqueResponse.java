package ensa.web.project.responses;

public class HistoriqueResponse {

	private String studentId;
	private String status;
	private String dateEntree;
	private String dureeDeLocalisation;
	private String description;
	private String prix;
	private String region;
	private String ville;
	private String dateDePublication;
	private String dureeDeDisponibilite;
	private String nombreDeCollegues;
	private String maxNombreDeCollegues;

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

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getDureeDeLocalisation() {
		return dureeDeLocalisation;
	}

	public void setDureeDeLocalisation(String dureeDeLocalisation) {
		this.dureeDeLocalisation = dureeDeLocalisation;
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

}
