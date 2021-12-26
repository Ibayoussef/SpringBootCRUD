package ensa.web.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ensa.web.project.entities.PostDetailsEntity;
import ensa.web.project.entities.PostEntity;
import ensa.web.project.repositiries.PostDetailRepository;
import ensa.web.project.repositiries.PostRepository;
import ensa.web.project.repositiries.StudentRepository;
import ensa.web.project.services.HistoriqueService;
import ensa.web.project.services.PostService;
import ensa.web.project.shared.Utils;
import ensa.web.project.shared.dto.LocationDto;
import ensa.web.project.shared.dto.PostDetailsDto;
import ensa.web.project.shared.dto.PostDto;
import ensa.web.project.shared.dto.PostImageDto;
import ensa.web.project.shared.dto.TagDto;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostDetailRepository postDetailsRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	HistoriqueService historiqueService ;
	
	

	@Autowired
	Utils util;
	

	PostDetailsEntity postdetails ;

	ModelMapper modelMapper = new ModelMapper();
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public PostDto createPost(String studentId, PostDto postDto) {

		postDto.setPostId(util.generateStringId(30));
		postDto.setNombreDeCollegues("0");
		postDto.setStatus("Disponible");
		
		// set location--------------------------------------------------------------
		if (postDto.getLocation() != null) {

			LocationDto location = postDto.getLocation();
			location.setLocationId(util.generateStringId(30));
			location.setStudentId(studentId);
			location.setPost(postDto);
			postDto.setLocation(location);
		}
		// ----------------location---------------------------------------------------


		// set details--------------------------------------------------------------
		if (postDto.getDetails() != null) {

			PostDetailsDto details = postDto.getDetails();
			details.setPostDetailsId(util.generateStringId(30));

			
			if(details.getTags() != null) {
				
				for(int i = 0; i< details.getTags().size(); i++) {
					
					TagDto tag = details.getTags().get(i);
					tag.setDetails(details);
					tag.setTagId(util.generateStringId(30));
				
					details.getTags().set(i, tag);
					
				}
				
			}
			details.setPost(postDto);
			
			postdetails = modelMapper.map(details, PostDetailsEntity.class);
			
			
			
		}
		// ----------------details---------------------------------------------------
		
		// set images--------------------------------------------------------------
		if (postDto.getImages() != null) {
			
			for(int i = 0; i< postDto.getImages().size(); i++) {
				
				PostImageDto image = postDto.getImages().get(i);
				image.setPost(postDto);
				image.setImageId(util.generateStringId(30));
			
				postDto.getImages().set(i, image);
				
			}
		}
		// ----------------images---------------------------------------------------

		

		ModelMapper modelMapper = new ModelMapper();
		PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
		
		
//		
//		StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
//		studentEntity.setHome("exist");
//		StudentEntity newStudent = studentRepository.save(studentEntity);
//		postEntity.setStudent(newStudent);
		postEntity.setStudent(studentRepository.findByStudentId(studentId));
		postdetails.setPost(postEntity);
		postEntity.setDetails(postdetails);
		PostEntity newPost = postRepository.save(postEntity);

		PostDto pstDto = modelMapper.map(newPost, PostDto.class);

		return pstDto;
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public void deletePost(String id) {
		
		PostEntity userEntity = postRepository.findByPostId(id);
		
		postRepository.delete(userEntity);
		
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public PostDto getPostByPostId(String postId) {
		
		PostEntity postEntity = postRepository.findByPostId(postId);
		
		ModelMapper modelMapper = new ModelMapper();
		PostDto postDto = modelMapper.map(postEntity, PostDto.class);
		
		
		return postDto;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public List<PostDto> getPosts(int page, int limit) {
		if(page > 0) page -=1;

		List<PostDto> postsDto = new ArrayList<>();
		
		Pageable  pageableRequest = PageRequest.of(page, limit);
		
		Page<PostEntity> userPage = postRepository.findAll(pageableRequest);
		
		List<PostEntity> users = userPage.getContent();
		
		for(PostEntity userEntity: users) {
			
			ModelMapper modelMapper = new ModelMapper();

			PostDto user = modelMapper.map(userEntity, PostDto.class);
			
			postsDto.add(user);
		}
		return postsDto ;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public PostDto updateStudent(String id, PostDto postDto) {
		
		PostEntity postEntity = postRepository.findByPostId(id);
		
		PostDto postDt = new PostDto();
		if(postEntity != null) {
			
			if(postDto.getDescription() != null ) {
				postEntity.setDescription(postDto.getDescription());
			}
			
			if(postDto.getPrix() != null ) {
				postEntity.setPrix(postDto.getPrix());
			}
			
			if(postDto.getTitle() != null) {
				postEntity.setTitle(postDto.getTitle());
			}
			
			if(postDto.getDureeDeDisponibilite() != null) {
				postEntity.setDureeDeDisponibilite(postDto.getDureeDeDisponibilite());
			}
			
//			if(postDto.getDetails().getAscenseur() != null ) {
//				postEntity.getDetails().setAscenseur(id);
//			}
//			
//			if(postDto.getDetails().getNonFumeur() != null ) {
//				postEntity.getDetails().setNonFumeur(postDto.getDetails().getNonFumeur());
//			}

//			if(postDto.getDetails().getChauffeEau() != null ) {
//				postEntity.getDetails().setChauffeEau(postDto.getDetails().getChauffeEau());
//			}
//			
//			if(postDto.getDetails().getEtage() != null ) {
//				postEntity.getDetails().setEtage(postDto.getDetails().getEtage());
//			}
//			
//			if(postDto.getDetails().getFibreOptique() != null ) {
//				postEntity.getDetails().setFibreOptique(postDto.getDetails().getFibreOptique());
//			}
//			
//			if(postDto.getDetails().getInternetAccess() != null ) {
//				postEntity.getDetails().setInternetAccess(postDto.getDetails().getInternetAccess());
//			}
//			
//			if(postDto.getDetails().getMachineLaver() != null ) {
//				postEntity.getDetails().setMachineLaver(postDto.getDetails().getMachineLaver());
//			}
//			
//			if(postDto.getDetails().getRefrigerateur() != null ) {
//				postEntity.getDetails().setRefrigerateur(postDto.getDetails().getRefrigerateur());
//			}
//			
//			if(postDto.getDetails().getTelevision() != null ) {
//				postEntity.getDetails().setTelevision(postDto.getDetails().getTelevision());
//			}
			
			PostEntity updateEntity = postRepository.save(postEntity);
			
			ModelMapper modelMapper = new ModelMapper();
			 postDt = modelMapper.map(updateEntity, PostDto.class) ; 
		}
			
		return postDt;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public List<PostDto> getPostsByGender(int page, int limit, String gender) {
		
		if(page > 0) page -=1;

		List<PostDto> postsDto = new ArrayList<>();
		
		Pageable  pageableRequest = PageRequest.of(page, limit);
		
		
		Page<PostEntity> userPage = postRepository.findAllByGender(pageableRequest,gender);
		
		List<PostEntity> users = userPage.getContent();
		
		for(PostEntity userEntity: users) {
			
			ModelMapper modelMapper = new ModelMapper();

			PostDto user = modelMapper.map(userEntity, PostDto.class);
			
			postsDto.add(user);
		}
		
		return postsDto ;

	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	

	@Override
	public void affecterPost(String studentId, String postId) {
		
		PostEntity post = postRepository.findByPostId(postId);
		
		post.setNombreDeCollegues( String.valueOf(Integer.parseInt(post.getNombreDeCollegues()) + 1) );
		
		if((post.getNombreDeCollegues()).equals(post.getMaxNombreDeCollegues())) {
			
			post.setStatus("Pas Disponible");
			postRepository.save(post);
		}
//		,ModelMapper modelMapper = new ModelMapper();
		
		ModelMapper mMapper = new ModelMapper();
		PostDto postDto = mMapper.map(post, PostDto.class);
		
		historiqueService.createHistorique(studentId, postDto);
		
	}

	
	

}
