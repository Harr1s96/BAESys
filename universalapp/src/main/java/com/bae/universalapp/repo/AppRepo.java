package com.bae.universalapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AppRepo
 */
@Repository
public interface AppRepo extends JpaRepository<T, Long> {

    
}