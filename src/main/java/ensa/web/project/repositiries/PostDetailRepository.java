package ensa.web.project.repositiries;

import org.springframework.data.repository.PagingAndSortingRepository;

import ensa.web.project.entities.PostDetailsEntity;

public interface PostDetailRepository extends PagingAndSortingRepository<PostDetailsEntity, Long> {

}
