package ensa.web.project.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ensa.web.project.entities.StudentEntity;
import ensa.web.project.repositiries.StudentRepository;
import ensa.web.project.services.StudentService;
import ensa.web.project.shared.Utils;
import ensa.web.project.shared.dto.LocationDto;
import ensa.web.project.shared.dto.PostDetailsDto;
import ensa.web.project.shared.dto.PostDto;
import ensa.web.project.shared.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	Utils util;
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Create Student @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@Override
	public StudentDto createStudent(StudentDto studentDto) {

		StudentEntity checkUser = studentRepository.findByEmail(studentDto.getEmail());
		if (checkUser != null)
			throw new RuntimeException("student already exists !");

		// set Post--------------------------------------------------------------------------
		if (studentDto.getPost() != null) {
			

				PostDto post = studentDto.getPost();
				post.setStudent(studentDto);
				post.setPostId(util.generateStringId(30));
				post.setNombreDeCollegues("0");
				post.setStatus("Disponible");

				// set location--------------------------------------------------------------
				if (post.getLocation() != null) {
					
					LocationDto location = post.getLocation();
					location.setLocationId(util.generateStringId(30));
					post.setLocation(location);
				}
				//----------------location---------------------------------------------------
				
				// set location--------------------------------------------------------------
				if (post.getDetails() != null) {
					
					PostDetailsDto details = post.getDetails();
					details.setPostDetailsId(util.generateStringId(30));
					post.setDetails(details);
				}
				//----------------location---------------------------------------------------
								
				studentDto.setPost(post);
			
		}
		//------------------------------  Post -----------------------------------------------
		
		ModelMapper modelMapper = new ModelMapper();
		StudentEntity studentEntity = modelMapper.map(studentDto, StudentEntity.class);

		studentEntity.setStudentId(util.generateStringId(33));
		studentEntity.setEncryptedPassword(studentEntity.getPassword());
		studentEntity.setHome("none");

		StudentEntity newStudent = studentRepository.save(studentEntity);



		StudentDto stdDto = modelMapper.map(newStudent, StudentDto.class);

		return stdDto;
	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get Student @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public StudentDto getStudent(String email) {
		
		StudentEntity studentEntity = studentRepository.findByEmail(email);
		
		StudentDto studentDto = new StudentDto();
		if(studentEntity != null) {
			
			BeanUtils.copyProperties(studentEntity, studentDto);
		}
		
		return studentDto;
	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get Student by id @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public StudentDto getStudentByStudentId(String studentId) {
		
		StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
		
		StudentDto studentDto = new StudentDto();
		if(studentEntity != null) {
			
			BeanUtils.copyProperties(studentEntity, studentDto);
		}
		
		return studentDto;
	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ update Student @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public StudentDto updateStudent(String id, StudentDto studentDto) {
		
		StudentEntity studentEntity = studentRepository.findByStudentId(id);		

		
		
		StudentDto studentDt= new StudentDto();
		

		if(studentEntity != null) {
			studentEntity.setFirstName(studentDto.getFirstName());
			studentEntity.setLastName(studentDto.getLastName());
			studentEntity.setEmail(studentDto.getEmail());
			studentEntity.setHome(studentDto.getHome());
			studentEntity.setImage(studentDto.getImage());
			studentEntity.setPassword(studentDto.getPassword());
			studentEntity.setGender(studentDto.getGender());			
			
			StudentEntity studentUpdated = studentRepository.save(studentEntity);
			BeanUtils.copyProperties(studentUpdated, studentDt);
			
		}
		
		return studentDt;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ get all students Student @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public List<StudentDto> getStudents(int page, int limit) {
		if(page > 0) page -=1;

		List<StudentDto> studentsDto = new ArrayList<>();
		
		Pageable  pageableRequest = PageRequest.of(page, limit);
		
		Page<StudentEntity> userPage = studentRepository.findAll(pageableRequest);
		
		List<StudentEntity> users = userPage.getContent();
		
		for(StudentEntity userEntity: users) {
			StudentDto user = new StudentDto();
			BeanUtils.copyProperties(userEntity, user);
			
			studentsDto.add(user);
		}
		return studentsDto ;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ update Student @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		
//		StudentEntity studentEntity = studentRepository.findByEmail(email);
//		
//		if(studentEntity == null) throw new UsernameNotFoundException(email);
//		
//		return new User(studentEntity.getEmail(), studentEntity.getPassword(), new ArrayList<>());
//	}
//	
	

}
