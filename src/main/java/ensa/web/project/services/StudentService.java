package ensa.web.project.services;


import java.util.List;

import ensa.web.project.shared.dto.StudentDto;

public interface StudentService {

	StudentDto createStudent(StudentDto studentDto);
	
	StudentDto getStudent(String email);
	
	StudentDto getStudentByStudentId(String studentId);

	StudentDto updateStudent(String id, StudentDto studentDto);

	List<StudentDto> getStudents(int page, int limit);
	

}
