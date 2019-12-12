package com.bae.universalapp.persistence.repo;

import com.bae.universalapp.persistence.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ModuleRepo
*/
@Repository
public interface ModuleRepo  extends JpaRepository<Module, Long> {

    
}