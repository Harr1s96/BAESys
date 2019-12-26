package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.rest.TeacherController;
import com.bae.universalapp.service.EmptyModuleListException;
import com.bae.universalapp.service.InvalidModuleCodeException;
import com.bae.universalapp.service.ModuleService;
import com.bae.universalapp.service.TeacherService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TeacherControllerUnitTest {

    @InjectMocks
    private TeacherController teacherController;

    @Mock
    private TeacherService teacherService;

    @Mock
    private ModuleService moduleService;

    private List<Teacher> teacherList;

    private Teacher testTeacher;

    private Teacher testTeacherWithId;

    private final Long id = 2L;

    @Before
    public void init() {

        this.teacherList = new ArrayList<>();
        this.testTeacher = new Teacher("Matt", "Farrow");
        this.testTeacherWithId = new Teacher("Jonathan", "Georgiou");

        this.teacherList.add(testTeacher);
        this.teacherList.add(testTeacherWithId);
        this.testTeacherWithId.setId(this.id);
    }

    @Test
    public void addTeacherTest() throws InvalidModuleCodeException, EmptyModuleListException {
        
        when(this.teacherService.addTeacher(testTeacher))
        .thenReturn(testTeacher);

        assertEquals(this.testTeacher, this.teacherController.addTeacher(testTeacher));

        verify(this.teacherService, times(1)).addTeacher(this.testTeacher);
    }

    @Test
    public void getTeacherByIdTest() {

        when(this.teacherService.getTeacherById(this.id))
        .thenReturn(this.testTeacherWithId);
        
        assertEquals(this.testTeacherWithId, this.teacherController.getTeacherById(id));

        verify(this.teacherService, times(1)).getTeacherById(id);
    }

    @Test
    public void getAllTeacherTest() {

        when(this.teacherService.getAllTeachers())
        .thenReturn(this.teacherList);

        assertEquals(2, this.teacherController.getAllTeachers().size());

        verify(this.teacherService, times(1)).getAllTeachers();
    }

    @Test
    public void updateTeacherByIdTest() {

        Teacher updateTeacher = new Teacher("Liam", "McIvor");

        when(this.teacherService.getTeacherById(id))
        .thenReturn(testTeacherWithId);

        assertEquals(testTeacherWithId, this.teacherController.getTeacherById(id));

        when(this.teacherService.updateTeacherById(updateTeacher, id))
        .thenReturn(updateTeacher);

        assertEquals(updateTeacher, this.teacherController.updateTeacherById(id, updateTeacher));

        verify(this.teacherService, times(1)).getTeacherById(id);
        verify(this.teacherService, times(1)).updateTeacherById(updateTeacher, id);
    }

    @Test
    public void deleteTeacherByIdTest() {
        
        when(this.teacherService.deleteTeacherById(id))
        .thenReturn("Teacher deleted successfully");

        assertEquals("Teacher deleted successfully", this.teacherController.deleteTeacherById(id));

        verify(this.teacherService, times(1)).deleteTeacherById(id);

    } 

}