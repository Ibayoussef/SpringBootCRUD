package ensa.web.project.services;

import java.util.List;

import ensa.web.project.shared.dto.PostDto;

public interface PostService  {

	PostDto createPost(String studentId, PostDto postDto);

	void deletePost(String id);

	PostDto getPostByPostId(String postId);

	List<PostDto> getPosts(int page, int limit);

	PostDto updateStudent(String id, PostDto postDto);

	List<PostDto> getPostsByGender(int page, int limit, String gender);

	void affecterPost(String studentId, String postId);

}
