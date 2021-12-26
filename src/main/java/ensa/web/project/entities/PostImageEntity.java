package ensa.web.project.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="postImage")
public class PostImageEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7262319711817068358L;
	

	@Id
	@GeneratedValue
	private long id;

	@Column(length=100, nullable=false)
	private String imageId;
	
	@Column(length=30, nullable=true)
	private String description;
	
	@Column(length=30, nullable=false)
	private String url;
	

	@ManyToOne
	@JoinColumn(name="post_id")
	private PostEntity post;


	
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


	public PostEntity getPost() {
		return post;
	}


	public void setPost(PostEntity post) {
		this.post = post;
	}
	
	
	
	

}
