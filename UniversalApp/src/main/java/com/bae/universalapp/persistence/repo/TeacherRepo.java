package com.bae.universalapp.persistence.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bae.universalapp.persistence.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * TeacherRepository
*/
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>, QueryByExampleExecutor<Teacher> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM teacher", nativeQuery = true)
    void deleteTeacherTable();

}
