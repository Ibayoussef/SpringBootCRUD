package ensa.web.project.entities;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="postTags")
public class TagEntity implements Serializable {
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4541172445920805919L;

	@Id
	@GeneratedValue
	private long id;

	@Column(length=100, nullable=false)
	private String tagId;
	
	@Column(length=50, nullable=true)
	private String name;
	
	@Column(length=50, nullable=false)
	private String slug;
	

	@ManyToOne
	@JoinColumn(name="postDetails_id")
	private PostDetailsEntity postDetails;


	
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


	public PostDetailsEntity getDetails() {
		return postDetails;
	}


	public void setDetails(PostDetailsEntity details) {
		this.postDetails = details;
	}



	
	
	

}
