package ensa.web.project.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="postDetails")
public class PostDetailsEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6815910358009792124L;

	@Id
	@GeneratedValue
	private long id;

	@Column(length=100)
	private String postDetailsId;
	
//	@Column(length=30)
//	private String machineLaver;
//	
//	@Column(length=30)
//	private String refrigerateur;
//	
//	@Column(length=30)
//	private String television;
//	
//	@Column(length=30)
//	private String chauffeEau;
//	
//	@Column(length=30)
//	private String internetAccess;
//	
//	@Column(length=30)
//	private String fibreOptique;
//	
//	@Column(length=30)
//	private String etage;
//	
//	@Column(length=30)
//	private String ascenseur;
	
//	@Column(length=50)
//	private String nonFumeur;	
//	
//	@Column(length=50)
//	private String etudiantEnsa;	

	@Column(length=200)
	private String conditions;	
	
	

	
	@OneToOne
	@JoinColumn(name="post_id")
	private PostEntity post;
	
	@OneToMany(mappedBy = "postDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<TagEntity> tags;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public List<TagEntity> getTags() {
		return tags;
	}


	public void setTags(List<TagEntity> tags) {
		this.tags = tags;
	}


	public String getPostDetailsId() {
		return postDetailsId;
	}


	public void setPostDetailsId(String postDetailsId) {
		this.postDetailsId = postDetailsId;
	}
	
	public PostEntity getPost() {
		return post;
	}


	public void setPost(PostEntity post) {
		this.post = post;
	}


	public String getConditions() {
		return conditions;
	}


	public void setConditions(String conditions) {
		this.conditions = conditions;
	}



//	public String getMachineLaver() {
//		return machineLaver;
//	}
//
//
//	public void setMachineLaver(String machineLaver) {
//		this.machineLaver = machineLaver;
//	}
//
//
//	public String getRefrigerateur() {
//		return refrigerateur;
//	}
//
//
//	public void setRefrigerateur(String refrigerateur) {
//		this.refrigerateur = refrigerateur;
//	}
//
//
//	public String getTelevision() {
//		return television;
//	}
//
//
//	public void setTelevision(String television) {
//		this.television = television;
//	}
//
//
//	public String getChauffeEau() {
//		return chauffeEau;
//	}
//
//
//	public void setChauffeEau(String chauffeEau) {
//		this.chauffeEau = chauffeEau;
//	}
//
//
//	public String getEtage() {
//		return etage;
//	}
//
//
//	public void setEtage(String etage) {
//		this.etage = etage;
//	}
//
//	public String getInternetAccess() {
//		return internetAccess;
//	}
//
//
//	public void setInternetAccess(String internetAccess) {
//		this.internetAccess = internetAccess;
//	}
//
//
//	public String getFibreOptique() {
//		return fibreOptique;
//	}
//
//
//	public void setFibreOptique(String fibreOptique) {
//		this.fibreOptique = fibreOptique;
//	}
//
//
//	public String getAscenseur() {
//		return ascenseur;
//	}
//
//
//	public void setAscenseur(String ascenseur) {
//		this.ascenseur = ascenseur;
//	}
//	
//	public String getNonFumeur() {
//		return nonFumeur;
//	}
//
//	public String getEtudiantEnsa() {
//		return etudiantEnsa;
//	}
//
//
//	public void setEtudiantEnsa(String etudiantEnsa) {
//		this.etudiantEnsa = etudiantEnsa;
//	}
//
//
//	public void setNonFumeur(String nonFumeur) {
//		this.nonFumeur = nonFumeur;
//	}



	
	

}
