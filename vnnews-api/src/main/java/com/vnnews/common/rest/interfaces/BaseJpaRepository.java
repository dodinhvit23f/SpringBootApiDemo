package com.vnnews.common.rest.interfaces;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface BaseJpaRepository<ENTITY, ID> extends JpaRepositoryImplementation<ENTITY, ID>{

}
