package ensa.web.project.repositiries;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ensa.web.project.entities.PostEntity;

public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long> {

	PostEntity findByPostId(String id);

	Page<PostEntity> findAll(Pageable pageableRequest);

	@Query(value="SELECT * FROM post p WHERE p.gender = ?1",nativeQuery=true)
	Page<PostEntity> findAllByGender(Pageable pageableRequest,String gender);
}
