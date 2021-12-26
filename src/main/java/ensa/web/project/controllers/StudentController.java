package ensa.web.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ensa.web.project.requests.StudentRequest;
import ensa.web.project.responses.StudentResponse;
import ensa.web.project.services.StudentService;
import ensa.web.project.shared.dto.StudentDto;

@RequestMapping("/students")
@RestController

public class StudentController {
	
	@Autowired
	StudentService studentService;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Create Student [Post,/students] @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest ) {
				
		ModelMapper modelMapper = new ModelMapper();
		StudentDto studentDto = modelMapper.map(studentRequest, StudentDto.class);
		
		StudentDto createStudent = studentService.createStudent(studentDto);
		
		StudentResponse studentResponse = modelMapper.map(createStudent, StudentResponse.class);
				
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);

	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get Student [Get,/students/{studentId}] @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path="/{studentId}")
	public ResponseEntity<StudentResponse> getUser(@PathVariable String studentId) {
		
		StudentDto studentDto = studentService.getStudentByStudentId(studentId);
		
		StudentResponse studentResponse = new StudentResponse();
		
		BeanUtils.copyProperties(studentDto, studentResponse);
		

		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);	
	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ update Student [Put,/students/{studentId}] @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(path="/{id}")
	public ResponseEntity<StudentResponse> updateUser(@PathVariable String id, @RequestBody StudentRequest studentRequest ) {
		
		StudentDto studentDto = new StudentDto();
		
		BeanUtils.copyProperties(studentRequest, studentDto);
		
		StudentDto updateStudent = studentService.updateStudent(id, studentDto);
	
		StudentResponse studentResponse = new StudentResponse();
		
		BeanUtils.copyProperties(updateStudent, studentResponse);
		
		return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.ACCEPTED);	
		
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ get all students @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<StudentResponse> getALLStudents(@RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "3") int limit) {
		
		List<StudentResponse> studentsResponse = new ArrayList<>();
		
		List<StudentDto> users = studentService.getStudents(page, limit);
		
		for (StudentDto userDto: users) {

			ModelMapper modelMapper = new ModelMapper();
			StudentResponse user = modelMapper.map(userDto, StudentResponse.class);
			studentsResponse.add(user);
		}
		
		return studentsResponse;
 
	}

}
