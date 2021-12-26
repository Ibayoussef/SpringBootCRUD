package ensa.web.project.shared.dto;

import java.io.Serializable;



public class PostImageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8929071037884353082L;
	

	private long id;

	private String imageId;

	private String description;

	private String url;

	private PostDto post;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}
	
	
	

}
