package ensa.web.project.shared.dto;

import java.io.Serializable;



public class TagDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8929071037884353082L;
	

	private long id;

	private String tagId;

	private String name;

	private String slug;

	private PostDetailsDto details;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public PostDetailsDto getDetails() {
		return details;
	}

	public void setDetails(PostDetailsDto details) {
		this.details = details;
	}
	
	
}