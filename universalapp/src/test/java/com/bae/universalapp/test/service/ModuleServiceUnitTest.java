package com.bae.universalapp.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.repo.ModuleRepo;
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
        
        when(this.moduleRepo.save(testModule))
        .thenReturn(testModule);

        assertEquals(this.testModule, this.moduleService.addModule(testModule));

        verify(this.moduleRepo, times(1)).save(this.testModule);
    }

    @Test
    public void getModuleByIdTest() {

        when(this.moduleRepo.findById(this.id))
        .thenReturn(Optional.of(this.testModuleWithId));
        
        assertEquals(this.testModuleWithId, this.moduleService.getModuleById(id));

        verify(this.moduleRepo, times(1)).findById(id);
    }

    @Test
    public void getAllModulesTest() {

        when(this.moduleRepo.findAll())
        .thenReturn(this.moduleList);

        assertEquals(2, this.moduleService.getAllModules().size());

        verify(this.moduleRepo, times(1)).findAll();
    }

    @Test
    public void updateModuleByIdTest() {

        Module updatedModule = new Module("Statistical Thermodynamics", "CHEM 336");

        when(this.moduleRepo.findById(id))
        .thenReturn(Optional.of(testModuleWithId));

        assertEquals(testModuleWithId, this.moduleService.getModuleById(id));

        when(this.moduleRepo.save(updatedModule))
        .thenReturn(updatedModule);

        assertEquals(updatedModule, this.moduleService.updateModuleById(updatedModule, id));

        verify(this.moduleRepo, times(2)).findById(id);
        verify(this.moduleRepo, times(1)).save(updatedModule);

    }

    @Test
    public void deleteModuleByIdTest() {
        
        when(this.moduleRepo.existsById(id))
        .thenReturn(true);

        assertEquals("Module deleted successfully", this.moduleService.deleteModuleById(id));

        verify(this.moduleRepo, times(1)).existsById(id);
        verify(this.moduleRepo, times(1)).deleteById(id);

    } 

}