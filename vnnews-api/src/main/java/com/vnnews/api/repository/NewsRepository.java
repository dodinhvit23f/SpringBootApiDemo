package com.vnnews.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vnnews.api.dto.interfaces.NewsI;
import com.vnnews.api.entities.News;
import com.vnnews.common.rest.interfaces.BaseJpaRepository;

@Repository
public interface NewsRepository extends BaseJpaRepository<News, Long>  {
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND "+ 
			"    s.cateId = ?1 " )
	public Page<NewsI> getDefaultNews(Long cateId, Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.typeId = ?1")
	
	public Page<NewsI> getGroupNews(Long typeId,Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.newsType = ?1")
	
	public Page<NewsI> getContentTypeNews(Long contentType, Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.cateId = ?1 AND s.typeId = ?2 AND s.newsType = ?3 ")
	public Page<NewsI> getNewsByCateIdAndGroupAndContent(Long cateId, Long typeId, Long newsType, Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.cateId = ?1 AND s.newsType = ?2 ")
	public Page<NewsI> getNewsByCateIdAndContent(Long cateId, Long newsType , Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.cateId = ?1 AND s.typeId = ?2 ")
	public Page<NewsI> getNewsByCateIdAndGroup(Long cateId, Long typeId, Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.typeId = ?1 AND s.newsType = ?2 ")
	public Page<NewsI> getNewsByGroupAndContent(Long typeId, Long newsType, Pageable pageable);
	
	@Query(value = "SELECT s.description as description ," + 
			"    s.numlike as numlike , " + 
			"    s.title as title , " + 
			"    s.sourceUrl as sourceUrl, " + 
			"    c.name as cateName, " + 
			"    s.commentCount as commentCount, " + 
			"    s.shareCount as shareCount, " + 
			"    s.id as id, " + 
			"    s.createTime as createTime, " + 
			"    s.viewCount as viewCount, " + 
			"    s.newsType as newsType, " +
			"    s.image1 as image1, " + 
			"    s.image2 as image2, " + 
			"    sbc_2.name as groupName " + 
			"    FROM News s " + 
			"    INNER JOIN  Category c on c.id = s.cateId " + 
			"    INNER JOIN Category sbc_2 ON sbc_2.id = s.typeId "+ 
			"	 WHERE 	s.description IS NOT NULL AND " +
			"	 s.title IS NOT NULL AND " +
			"	 s.sourceUrl IS NOT NULL AND " +
			"	 s.id = ?1")
	public NewsI getNewsById(Long id);
	
}
