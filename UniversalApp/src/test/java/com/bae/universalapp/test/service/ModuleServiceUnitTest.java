package com.bae.universalapp.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.bae.universalapp.service.EmptyModuleListException;
import com.bae.universalapp.service.InvalidModuleCodeException;
import com.bae.universalapp.service.ModuleService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ModuleServiceUnitTest {

    @InjectMocks
    private ModuleService moduleService;

    @Mock
    private ModuleRepo moduleRepo;

    private List<Module> moduleList;

    private Module testModule;

    private Module testModuleWithId;

    private final Long id = 2L;

    @Before
    public void init() {

        this.moduleList = new ArrayList<>();
        
        this.testModule = new Module("Intro to group theory", "CHEM 382");
        this.testModuleWithId = new Module("Quantum Chemistry", "CHEM 335");

        this.moduleList.add(testModule);
        this.moduleList.add(testModuleWithId);
        this.testModuleWithId.setId(this.id);
    }

    @Test
    public void addModuleTest() {

        when(this.moduleRepo.save(testModule)).thenReturn(testModule);

        assertEquals(this.testModule, this.moduleService.addModule(testModule));

        verify(this.moduleRepo, times(1)).save(this.testModule);
    }

    @Test
    public void getModuleByIdTest() {

        when(this.moduleRepo.findById(this.id)).thenReturn(Optional.of(this.testModuleWithId));

        assertEquals(this.testModuleWithId, this.moduleService.getModuleById(id));

        verify(this.moduleRepo, times(1)).findById(id);
    }

    @Test
    public void getAllModulesTest() {

        when(this.moduleRepo.findAll()).thenReturn(this.moduleList);

        assertEquals(2, this.moduleService.getAllModules().size());

        verify(this.moduleRepo, times(1)).findAll();
    }

    @Test
    public void updateModuleByIdTest() {
        
        Module newModule = new Module("Statistical Thermodynamics", "CHEM 336");
        Module updatedModule = new Module(newModule.getModuleCode(), newModule.getModuleName());
        updatedModule.setId(this.testModuleWithId.getId());

        when(this.moduleRepo.findById(this.testModuleWithId.getId())).thenReturn(Optional.of(this.testModuleWithId));
        
        when(this.moduleRepo.save(this.testModuleWithId)).thenReturn(updatedModule);

        assertEquals(updatedModule, this.moduleService.updateModuleById(newModule, this.testModuleWithId.getId()));

        verify(this.moduleRepo, times(1)).findById(this.testModuleWithId.getId());
        verify(this.moduleRepo, times(1)).save(this.testModuleWithId);

    }

    @Test
    public void updateLecturesByModuleIdTest() {

        Module toUpdate = new Module("Quantum Mechanics", "CHEM 335");
        Lecture lectureOne = new Lecture("lecture 1");
        Lecture lectureTwo = new Lecture("lecture 2");
        
        List<Lecture> lectureList = new ArrayList<>();
        lectureList.add(lectureOne);
        lectureList.add(lectureTwo);

        when(this.moduleRepo.findById(id)).thenReturn(Optional.of(this.testModuleWithId));

        assertEquals(testModuleWithId, this.moduleService.getModuleById(id));

        when(this.moduleRepo.save(toUpdate)).thenReturn(testModuleWithId);

        assertEquals(this.testModuleWithId, this.moduleService.updateLecturesByModuleId(this.id, lectureList));

        verify(this.moduleRepo, times(2)).findById(id);
        verify(this.moduleRepo, times(1)).save(toUpdate);

    }

    @Test
    public void deleteModuleByIdTest() {

        when(this.moduleRepo.existsById(id)).thenReturn(true, false);

        assertEquals("Module has not been deleted", this.moduleService.deleteModuleById(id));
        assertEquals("Module deleted successfully", this.moduleService.deleteModuleById(id));

        verify(this.moduleRepo, times(2)).existsById(id);
        verify(this.moduleRepo, times(2)).deleteById(id);

    }

    @Test
    public void verifyModuleCodeTest() throws InvalidModuleCodeException, EmptyModuleListException {

        Module moduleCodeTest = new Module("moduleName", "CHEM 222");
        this.moduleList.add(moduleCodeTest);

        assertEquals(true, this.moduleService.verifyModuleCode(moduleList));
    }

}