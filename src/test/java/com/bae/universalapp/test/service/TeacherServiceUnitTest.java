package com.bae.universalapp.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.persistence.repo.TeacherRepo;
import com.bae.universalapp.service.TeacherService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TeacherServiceUnitTest {

    @InjectMocks
    private TeacherService teacherService;

    @Mock
    private TeacherRepo teacherRepo;

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
    public void addTeacherTest() {
        
        when(this.teacherRepo.save(testTeacher))
        .thenReturn(testTeacher);

        assertEquals(this.testTeacher, this.teacherService.addTeacher(testTeacher));

        verify(this.teacherRepo, times(1)).save(this.testTeacher);
    }

    @Test
    public void getTeacherByIdTest() {

        when(this.teacherRepo.findById(this.id))
        .thenReturn(Optional.of(this.testTeacherWithId));
        
        assertEquals(this.testTeacherWithId, this.teacherService.getTeacherById(id));

        verify(this.teacherRepo, times(1)).findById(id);
    }

    @Test
    public void getAllTeachersTest() {

        when(this.teacherRepo.findAll())
        .thenReturn(this.teacherList);

        assertEquals(2, this.teacherService.getAllTeachers().size());

        verify(this.teacherRepo, times(1)).findAll();
    }

    @Test
    public void updateTeacherByIdTest() {

        Teacher updatedTeacher = new Teacher("Liam", "McIvor");

        when(this.teacherRepo.findById(id))
        .thenReturn(Optional.of(testTeacherWithId));

        assertEquals(testTeacherWithId, this.teacherService.getTeacherById(id));

        when(this.teacherRepo.save(updatedTeacher))
        .thenReturn(updatedTeacher);

        assertEquals(updatedTeacher, this.teacherService.updateTeacherById(updatedTeacher, id));

        verify(this.teacherRepo, times(2)).findById(id);
        verify(this.teacherRepo, times(1)).save(updatedTeacher);

    }

    @Test
    public void deleteTeacherByIdTest() {
        
        when(this.teacherRepo.existsById(id))
        .thenReturn(true, false);

        assertEquals("Teacher has not been deleted", this.teacherService.deleteTeacherById(id));
        assertEquals("Teacher deleted successfully", this.teacherService.deleteTeacherById(id));

        verify(this.teacherRepo, times(2)).existsById(id);
        verify(this.teacherRepo, times(2)).deleteById(id);

    }


}