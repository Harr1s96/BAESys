package com.bae.universalapp.persistence.repo;

import com.bae.universalapp.persistence.domain.Module;
// import com.bae.universalapp.service.ModuleListWrapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * ModuleRepo
 */
@Repository
public interface ModuleRepo extends JpaRepository<Module, Long>, QueryByExampleExecutor<Module> {

	// List<Module> saveAll(ModuleListWrapper modules);

}