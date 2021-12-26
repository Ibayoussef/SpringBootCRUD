package ensa.web.project.controllers;



import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ensa.web.project.requests.AffectationRequest;
import ensa.web.project.requests.PostRequest;
import ensa.web.project.responses.LocationResponse;
import ensa.web.project.responses.PostDetailsResponse;
import ensa.web.project.responses.PostImageResponse;
import ensa.web.project.responses.PostResponse;
import ensa.web.project.responses.TagResponse;
import ensa.web.project.services.HistoriqueService;
import ensa.web.project.services.PostService;
import ensa.web.project.services.StudentService;
import ensa.web.project.shared.dto.PostDto;
import ensa.web.project.shared.dto.StudentDto;




@RequestMapping("/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class PostsControllers {
	
	@Autowired
	PostService postService;
	
	@Autowired
	StudentService studentService;
//	@Autowired
//	StudentRepository studentRepository;
	
	@Autowired
	HistoriqueService historiqueService;
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Create Post @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@PostMapping(path="/{studentId}")
	public ResponseEntity<PostResponse> createPost(@PathVariable String studentId,@RequestBody PostRequest postRequest ) {
				
		ModelMapper modelMapper = new ModelMapper();
		PostDto postDto = modelMapper.map(postRequest, PostDto.class);
		
		StudentDto student = studentService.getStudentByStudentId(studentId);
		student.setHome("exists");
		studentService.updateStudent(studentId, student);
//		StudentEntity studentEntity = modelMapper.map(student,StudentEntity.class);
//		studentRepository.save(studentEntity);

		
		PostDto createPost = postService.createPost(studentId,postDto);
		
		PostResponse postResponse = modelMapper.map(createPost, PostResponse.class);
		historiqueService.createHistorique(studentId, postDto);
		LocationResponse location = new LocationResponse();
		PostDetailsResponse  details = new PostDetailsResponse ();
		
		location.setLocationId(postResponse.getLocation().getLocationId());
		details.setPostDetailsId(postResponse.getDetails().getPostDetailsId());
		
		postResponse.setLocation(location);
		postResponse.setDetails(details);
		
		for (int i=0; i<postResponse.getImages().size(); i++) {
			PostImageResponse image = new PostImageResponse();
			
			image.setImageId(postResponse.getImages().get(i).getImageId());
			
			postResponse.getImages().set(i, image);
		}
				
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.CREATED);

	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get all Postss @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@GetMapping
	public List<PostResponse> getALLPosts(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "3") int limit) {
		
		List<PostResponse> postsResponse = new ArrayList<>();
		
		List<PostDto> posts = postService.getPosts(page, limit);
		
		for (PostDto postDto: posts) {
			ModelMapper modelMapper = new ModelMapper();
			PostResponse postResponse = modelMapper.map(postDto, PostResponse.class);
			
			postsResponse.add(postResponse);
		}
		
		return postsResponse;
 
	}
	
//	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get all Tags @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
//	@GetMapping(path="/tags")
//	public List<TagResponse> getALLTags(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "3") int limit) {
//		
//		List<TagResponse> tagsResponse = new ArrayList<>();
//		
//		List<PostDto> posts = postService.getPosts(page, limit);
//
//		for (PostDto postDto: posts) {
//			ModelMapper modelMapper = new ModelMapper();
//			PostResponse postResponse = modelMapper.map(postDto, PostResponse.class);
//			
//			if(postResponse.getDetails().getTags() != null) {
//				
//				for(TagResponse tag : postResponse.getDetails().getTags()) {
//					
//					tagsResponse.add(tag);
//				}
//			}
//			}
//
//
//		}
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get all Tags @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
		@GetMapping(path="/tags")
		public List<TagResponse> getALLStaticTags() {
			
			List<TagResponse> tagsResponse = new ArrayList<>();
			
            TagResponse tag = new TagResponse();
            tag.setName("Tv");
            tag.setSlug("tv");
            tagsResponse.add(tag);
            tag.setName("Network Connection");
            tag.setSlug("networkConnection");
            tagsResponse.add(tag);
            tag.setName("Parking");
            tag.setSlug("parking");
            tagsResponse.add(tag);
            tag.setName("Water Heater");
            tag.setSlug("waterHeater");
            tagsResponse.add(tag);
            tag.setName("Washing Machine");
            tag.setSlug("washingMachine");
            tagsResponse.add(tag);
            

	
		
		return tagsResponse;
 
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get all Posts By Gender @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@GetMapping(path="/gender")
	public List<PostResponse> getALLPostsByGender(@RequestParam(value="page", defaultValue = "0") int page, @RequestParam(value="limit", defaultValue = "3") int limit,
												  @RequestParam(value="gender", defaultValue = "homme") String gender) {
		
		List<PostResponse> postsResponse = new ArrayList<>();
		
		List<PostDto> posts = postService.getPostsByGender(page, limit,gender);
		
		for (PostDto postDto: posts) {
			ModelMapper modelMapper = new ModelMapper();
			PostResponse postResponse = modelMapper.map(postDto, PostResponse.class);
			
			postsResponse.add(postResponse);
		}
		
		return postsResponse;
 
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get Post by ID @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@GetMapping(path="/{postId}")

		public ResponseEntity<PostResponse> getTagsByPostId(@PathVariable String postId) {
			
			PostDto postDto = postService.getPostByPostId(postId);
			
			ModelMapper modelMapper = new ModelMapper();
		
			PostResponse postResponse = modelMapper.map(postDto, PostResponse.class);
			
			
			

			return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);

	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get Tags by postID @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@GetMapping(path="/tags/{postId}")
	public List<TagResponse> getPost(@PathVariable String postId) {
		PostDto postDto = postService.getPostByPostId(postId);
		
		ModelMapper modelMapper = new ModelMapper();
	
		PostResponse postResponse = modelMapper.map(postDto, PostResponse.class);
		
		List<TagResponse> tags = postResponse.getDetails().getTags();
		

		return tags;	
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ update Post @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@PutMapping(path="/{id}")
	public ResponseEntity<PostResponse> updatePost(@PathVariable String id, @RequestBody PostRequest postRequest ) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		PostDto postDto = modelMapper.map(postRequest, PostDto.class);
		
		
		PostDto updatePost = postService.updateStudent(id, postDto);
	
		PostResponse postResponse = modelMapper.map(updatePost, PostResponse.class);
		
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.ACCEPTED);	
		
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Delete Post @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		postService.deletePost(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ affectation post @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	

	@PutMapping(path="/affecter")
	public ResponseEntity<Object> affecterPost(@RequestBody AffectationRequest affectationRequest) {

		postService.affecterPost(affectationRequest.getStudentId() ,affectationRequest.getPostId());
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}
