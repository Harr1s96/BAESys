package com.bae.universalapp.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.repo.LectureRepo;
import com.bae.universalapp.service.LectureService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LectureServiceUnitTest {

    @InjectMocks
    private LectureService lectureService;

    @Mock
    private LectureRepo lectureRepo;

    private List<Lecture> lectureList;

    private Lecture testLecture;

    private Lecture testLectureWithId;

    private final Long id = 2L;

    @Before
    public void init() {
        
        this.lectureList = new ArrayList<>();
        this.testLecture = new Lecture("Intro to group theory");
        this.testLectureWithId = new Lecture("Quantum Chemistry");

        this.lectureList.add(testLecture);
        this.lectureList.add(testLectureWithId);
        this.testLectureWithId.setId(this.id);   
    }

    @Test
    public void addLectureTest() {
        
        when(this.lectureRepo.save(testLecture))
        .thenReturn(testLecture);

        assertEquals(this.testLecture, this.lectureService.addLecture(testLecture));

        verify(this.lectureRepo, times(1)).save(this.testLecture);
    }

    @Test
    public void getLectureByIdTest() {

        when(this.lectureRepo.findById(this.id))
        .thenReturn(Optional.of(this.testLectureWithId));
        
        assertEquals(this.testLectureWithId, this.lectureService.getLectureById(id));

        verify(this.lectureRepo, times(1)).findById(id);
    }

    @Test
    public void getAllLecturesTest() {

        when(this.lectureRepo.findAll())
        .thenReturn(this.lectureList);

        assertEquals(2, this.lectureService.getAllLectures().size());

        verify(this.lectureRepo, times(1)).findAll();
    }

    @Test
    public void updateLectureByIdTest() {

        Lecture updatedModule = new Lecture("Statistical Thermodynamics");

        when(this.lectureRepo.findById(id))
        .thenReturn(Optional.of(testLectureWithId));

        assertEquals(testLectureWithId, this.lectureService.getLectureById(id));

        when(this.lectureRepo.save(updatedModule))
        .thenReturn(updatedModule);

        assertEquals(updatedModule, this.lectureService.updateLectureById(updatedModule, id));

        verify(this.lectureRepo, times(2)).findById(id);
        verify(this.lectureRepo, times(1)).save(updatedModule);

    }

    @Test
    public void deleteLectureByIdTest() {
        
        when(this.lectureRepo.existsById(id))
        .thenReturn(true, false);

        assertEquals("Lecture has not been deleted", this.lectureService.deleteLectureById(id));
        assertEquals("Lecture deleted successfully", this.lectureService.deleteLectureById(id));

        verify(this.lectureRepo, times(2)).existsById(id);
        verify(this.lectureRepo, times(2)).deleteById(id);

    } 
}