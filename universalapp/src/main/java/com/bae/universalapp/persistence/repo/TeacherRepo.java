package com.bae.universalapp.persistence.repo;

import org.springframework.stereotype.Repository;
import com.bae.universalapp.persistence.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TeacherRepo
*/
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    
}