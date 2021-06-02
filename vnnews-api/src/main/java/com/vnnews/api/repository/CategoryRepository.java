package com.vnnews.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vnnews.api.entities.Category;
import com.vnnews.common.rest.interfaces.BaseJpaRepository;

@Repository
public interface CategoryRepository extends BaseJpaRepository<Category, Long> {

	@Query(value = "SELECT c FROM Category c WHERE c.idParent = 1 AND  c.name IS NOT NULL")
	public Page<Category> getHeadersCategory(Pageable pageable);
	
}
