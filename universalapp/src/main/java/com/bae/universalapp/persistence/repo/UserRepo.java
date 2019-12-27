package com.bae.universalapp.persistence.repo;

import com.bae.universalapp.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AppRepo
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    
}