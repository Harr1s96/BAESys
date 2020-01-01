package com.bae.universalapp.persistence.repo;

import com.bae.universalapp.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserRepository
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from user", nativeQuery = true)
    void truncateUserTable();

    
}