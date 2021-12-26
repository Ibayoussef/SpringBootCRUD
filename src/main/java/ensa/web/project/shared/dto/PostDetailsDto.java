package ensa.web.project.shared.dto;

import java.io.Serializable;
import java.util.List;

public class PostDetailsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3732540755765858272L;
	
	private long id;

	private String postDetailsId;
	
//	private String machineLaver;
//
//	private String refrigerateur;
//
//	private String television;
//
//	private String chauffeEau;
//
//	private String internetAccess;
//
//	private String fibreOptique;

//	private String etage;
//
//	private String ascenseur;
	
//	private String nonFumeur;
//
//	private String etudiantEnsa;	
	
	private PostDto post;
	
	private List<TagDto> tags;
	
	private String conditions;
	

	
	

	
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

//	public String getNonFumeur() {
//		return nonFumeur;
//	}
//
//	public void setNonFumeur(String nonFumeur) {
//		this.nonFumeur = nonFumeur;
//	}
//
//	public String getEtudiantEnsa() {
//		return etudiantEnsa;
//	}
//
//	public void setEtudiantEnsa(String etudiantEnsa) {
//		this.etudiantEnsa = etudiantEnsa;
//	}
//
	public List<TagDto> getTags() {
		return tags;
	}

	public void setTags(List<TagDto> tags) {
		this.tags = tags;
	}

	public String getPostDetailsId() {
		return postDetailsId;
	}

	public void setPostDetailsId(String postDetailsId) {
		this.postDetailsId = postDetailsId;
	}

//	public String getMachineLaver() {
//		return machineLaver;
//	}
//
//	public void setMachineLaver(String machineLaver) {
//		this.machineLaver = machineLaver;
//	}
//
//	public String getRefrigerateur() {
//		return refrigerateur;
//	}
//
//	public void setRefrigerateur(String refrigerateur) {
//		this.refrigerateur = refrigerateur;
//	}
//
//	public String getTelevision() {
//		return television;
//	}
//
//	public void setTelevision(String television) {
//		this.television = television;
//	}
//
//	public String getChauffeEau() {
//		return chauffeEau;
//	}
//
//	public void setChauffeEau(String chauffeEau) {
//		this.chauffeEau = chauffeEau;
//	}
//
//
//
//	public String getEtage() {
//		return etage;
//	}
//
//	public void setEtage(String etage) {
//		this.etage = etage;
//	}
//
//
//
//	public String getInternetAccess() {
//		return internetAccess;
//	}
//
//	public void setInternetAccess(String internetAccess) {
//		this.internetAccess = internetAccess;
//	}
//
//	public String getFibreOptique() {
//		return fibreOptique;
//	}
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
//	public void setAscenseur(String ascenseur) {
//		this.ascenseur = ascenseur;
//	}

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}
	
	

}
