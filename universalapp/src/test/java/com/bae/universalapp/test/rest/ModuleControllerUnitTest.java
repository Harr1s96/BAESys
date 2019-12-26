package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.rest.ModuleController;
import com.bae.universalapp.service.ModuleService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ModuleControllerUnitTest {

    @InjectMocks
    private ModuleController moduleController;

    @Mock
    private ModuleService moduleService;

    private List<Module> moduleList;

    private Module testModule;

    private Module testModuleWithId;

    private final Long id = 2L;

    @Before
    public void init() {

        this.moduleList = new ArrayList<>();
        this.testModule = new Module("Intro to Group Theory", "CHEM 385");
        this.testModuleWithId = new Module("Quantum Chemistry", "CHEM 355");

        this.moduleList.add(testModule);
        this.moduleList.add(testModuleWithId);
        this.testModuleWithId.setId(this.id);
    }

    @Test
    public void addModuleTest() {
        
        when(this.moduleService.addModule(testModule))
        .thenReturn(testModule);

        assertEquals(this.testModule, this.moduleController.addModule(testModule));

        verify(this.moduleService, times(1)).addModule(this.testModule);
    }

    @Test
    public void getModuleByIdTest() {

        when(this.moduleService.getModuleById(this.id))
        .thenReturn(this.testModuleWithId);
        
        assertEquals(this.testModuleWithId, this.moduleController.getModuleById(id));

        verify(this.moduleService, times(1)).getModuleById(id);
    }

    @Test
    public void getAllModulesTest() {

        when(this.moduleService.getAllModules())
        .thenReturn(this.moduleList);

        assertEquals(2, this.moduleController.getAllModules().size());

        verify(this.moduleService, times(1)).getAllModules();
    }

    @Test
    public void updateModuleByIdTest() {

        Module updateTeacher = new Module("Statistical Thermodynamics", "CHEM 322");

        when(this.moduleService.getModuleById(id))
        .thenReturn(testModuleWithId);

        assertEquals(testModuleWithId, this.moduleController.getModuleById(id));

        when(this.moduleService.updateModuleById(updateTeacher, id))
        .thenReturn(updateTeacher);

        assertEquals(updateTeacher, this.moduleController.updateModuleById(id, updateTeacher));

        verify(this.moduleService, times(1)).getModuleById(id);
        verify(this.moduleService, times(1)).updateModuleById(updateTeacher, id);
    }

    @Test
    public void updateLecturesByModuleIdTest() {

        Module toUpdate = new Module("Statistical Thermodynamics", "CHEM 336");
        Lecture lectureOne = new Lecture("lecture 1");
        Lecture lectureTwo = new Lecture("lecture 2");
        List<Lecture> lectureList = new ArrayList<>();

        lectureList.add(lectureOne);
        lectureList.add(lectureTwo);

        when(this.moduleService.getModuleById(id)).thenReturn(testModuleWithId);

        assertEquals(testModuleWithId, this.moduleService.getModuleById(id));

        when(this.moduleService.updateLecturesByModuleId(id, lectureList)).thenReturn(toUpdate);

        assertEquals(toUpdate, this.moduleService.updateLecturesByModuleId(id, lectureList));

        verify(this.moduleService, times(1)).getModuleById(id);
        verify(this.moduleService, times(1)).updateLecturesByModuleId(id, lectureList);

    }

    @Test
    public void deleteModuleByIdTest() {
        
        when(this.moduleService.deleteModuleById(id))
        .thenReturn("Module deleted successfully");

        assertEquals("Module deleted successfully", this.moduleController.deleteModuleById(id));

        verify(this.moduleService, times(1)).deleteModuleById(id);

    } 

}