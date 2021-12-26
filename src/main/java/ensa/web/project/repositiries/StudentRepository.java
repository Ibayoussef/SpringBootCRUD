package ensa.web.project.repositiries;

import org.springframework.data.repository.PagingAndSortingRepository;



import ensa.web.project.entities.StudentEntity;

public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Long> {

	StudentEntity findByEmail(String email);
	StudentEntity findByStudentId(String userId);
	

}
