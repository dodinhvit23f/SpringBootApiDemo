package com.vnnews.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vnnews.api.entities.Comment;
import com.vnnews.common.rest.interfaces.BaseJpaRepository;

@Repository
public interface CommentsRepository extends BaseJpaRepository<Comment, Long>  {
	@Query(value = "SELECT c " +
			"FROM Comment c " + 
			"WHERE  news_id = ?1  AND c.status = 1"
		)
	public Page<Comment> getCommentsByNewsId(Long id, Pageable pagable);
	
	@Query(value ="SELECT c " +
			"FROM Comment c " + 
			"WHERE  newsId = ?1  AND c.parentId = ?2 AND c.status = 1 "
			)
	public Page<Comment> getCommentsByNewsIdAndParentId(Long id, Long parentId, Pageable pagable);
	
	@Modifying
	@Query(value = "INSERT INTO TBL_COMMENT "
			+ "(ID, MSISDN, CONTENT, CREATE_TIME, SOURCE, NEWS_ID) VALUES "
			+ "('?1', '?2', '?3', TO_DATE('?4', 'YYYY-MM-DD HH24:MI:SS'), '?5', '?6')"
		, nativeQuery = true)
	public void insertComment(Long id,String MSISDN,String content, String Date, String source, Long new_id);
}
