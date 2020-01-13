package com.bae.universalapp.persistence.repo;

import com.bae.universalapp.persistence.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * LectureRepository
 */
@Repository
public interface LectureRepo extends JpaRepository<Lecture, Long>, QueryByExampleExecutor<Lecture> {

    @Modifying
    @Transactional
    @Query(value = "delete from lecture", nativeQuery = true)
    void deleteLectureTable();

}