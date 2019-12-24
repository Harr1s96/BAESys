package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.rest.LectureController;
import com.bae.universalapp.service.LectureService;
import com.bae.universalapp.service.ModuleService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LectureControllerUnitTest {

    @InjectMocks
    private LectureController lectureController;

    @Mock
    private LectureService lectureService;

    // needed to test addLecture method
    @Mock
    private ModuleService moduleService;

    private List<Lecture> lectureList;

    private Lecture testLecture;

    private Lecture testLectureWithId;

    private final Long id = 2L;

    @Before
    public void init() {

        this.lectureList = new ArrayList<>();
        this.testLecture = new Lecture("Symmetries");
        this.testLectureWithId = new Lecture("Orbitals");

        this.lectureList.add(testLecture);
        this.lectureList.add(testLectureWithId);
        this.testLectureWithId.setId(this.id);
    }

    // @Test
    // public void addModuleTest() {

    //     Module placeholderModule = new Module("moduleName", "CHEM 123");
    //     this.moduleService.addModule(placeholderModule);

        
    //     when(this.lectureService.addLecture(testLecture))
    //     .thenReturn(testLecture);

    //     assertEquals(this.testLecture, this.lectureController.addLecture(1L, testLecture));

    //     verify(this.lectureService, times(1)).addLecture(this.testLecture);
    // }

    @Test
    public void getModuleByIdTest() {

        when(this.lectureService.getLectureById(this.id))
        .thenReturn(this.testLectureWithId);
        
        assertEquals(this.testLectureWithId, this.lectureController.getLectureById(id));

        verify(this.lectureService, times(1)).getLectureById(id);
    }

    @Test
    public void getAllModulesTest() {

        when(this.lectureService.getAllLectures())
        .thenReturn(this.lectureList);

        assertEquals(2, this.lectureController.getAllLectures().size());

        verify(this.lectureService, times(1)).getAllLectures();
    }

    @Test
    public void updateUserByIdTest() {

        Lecture updateLecture = new Lecture("Statistical Thermodynamics");

        when(this.lectureService.getLectureById(id))
        .thenReturn(testLectureWithId);

        assertEquals(testLectureWithId, this.lectureController.getLectureById(id));

        when(this.lectureService.updateLectureById(updateLecture, id))
        .thenReturn(updateLecture);

        assertEquals(updateLecture, this.lectureController.updateLectureById(id, updateLecture));

        verify(this.lectureService, times(1)).getLectureById(id);
        verify(this.lectureService, times(1)).updateLectureById(updateLecture, id);
    }

    @Test
    public void deleteUserByIdTest() {
        
        when(this.lectureService.deleteLectureById(id))
        .thenReturn("Lecture deleted successfully");

        assertEquals("Lecture deleted successfully", this.lectureController.deleteLectureById(id));

        verify(this.lectureService, times(1)).deleteLectureById(id);

    } 


}