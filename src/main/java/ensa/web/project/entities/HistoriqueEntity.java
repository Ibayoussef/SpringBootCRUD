package ensa.web.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "historique")
public class HistoriqueEntity implements Serializable {

	private static final long serialVersionUID = -8582732056186182993L;

	@Id
	@GeneratedValue
	private long id;

	@Column(length = 100, nullable = true)
	private String studentId;

	@Column(length = 30, nullable = false)
	private String status;

	@Column(length = 30, nullable = false)
	private String dateEntree;

	@Column(length = 30, nullable = false)
	private String dureeDeLocalisation;

	@Column(length = 100, nullable = false)
	private String description;

	@Column(length = 30, nullable = false)
	private String prix;

	@Column(length = 30, nullable = false)
	private String region;

	@Column(length = 30, nullable = false)
	private String ville;

	@Column(length = 30, nullable = false)
	private String dateDePublication;

	@Column(length = 30, nullable = false)
	private String dureeDeDisponibilite;

	@Column(length = 30, nullable = false)
	private String nombreDeCollegues;

	@Column(length = 30, nullable = false)
	private String maxNombreDeCollegues;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
