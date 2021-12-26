package ensa.web.project.requests;


public class PostImageRequest {


	private String description;

	private String url;

	private PostRequest post;
	
	
	

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

	public PostRequest getPost() {
		return post;
	}

	public void setPost(PostRequest post) {
		this.post = post;
	}
	
	

}
