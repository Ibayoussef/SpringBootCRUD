package ensa.web.project.repositiries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ensa.web.project.entities.HistoriqueEntity;

public interface HistoriqueRepository extends PagingAndSortingRepository<HistoriqueEntity, Long> {
	
	HistoriqueEntity findByStudentId(String id);
	@Query(value="SELECT * FROM historique h WHERE h.student_id = ?1",nativeQuery=true)
	List<HistoriqueEntity> findAllByStudentId(String studentId);
}
