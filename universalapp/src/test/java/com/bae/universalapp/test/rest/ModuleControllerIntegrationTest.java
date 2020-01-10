package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.repo.LectureRepo;
import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * ModuleControllerIntegrationTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ModuleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ModuleRepo moduleRepo;

    @Autowired
    private LectureRepo lectureRepo;

    private Module testModule;
    private Module testModuleWithId;
    private long id;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {

        this.moduleRepo.deleteAll();
        this.lectureRepo.deleteAll();

        this.testModule = new Module("Intro to Organic Chemistry", "CHEM 135");
        this.testModule.setLectures(Collections.emptyList());
        this.testModuleWithId = this.moduleRepo.save(this.testModule);
        this.id = this.testModuleWithId.getId();
    }

    @Test
    public void addModuleTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.POST, "/teachers/modules")
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(testModule)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testModuleWithId), result);
    }

    @Test
    public void getAllModulesTest() throws Exception {

        List<Module> moduleList = new ArrayList<>();
        Module secondTestModule = new Module("Intro to Inorganic Chemistry", "CHEM 111");
        secondTestModule.setLectures(Collections.emptyList());
        this.moduleRepo.save(secondTestModule);

        moduleList.add(this.testModule);
        moduleList.add(secondTestModule);

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, "/teachers/modules")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        assertEquals(this.mapper.writeValueAsString(moduleList), result);
    }

    @Test
    public void getModuleByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, "/teachers/modules/" + this.id)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testModuleWithId), result);
    }

    @Test
    public void updateModuleByIdTest() throws Exception {

        Module testModuleTwo = new Module("Intro to Quantum", "CHEM 355");
        Module updatedModule = new Module(testModuleTwo.getModuleName(), testModuleTwo.getModuleCode());
        updatedModule.setId(this.id);
        updatedModule.setLectures(Collections.emptyList());
        
        String result = this.mockMvc.perform(
            request(HttpMethod.PUT, "/teachers/module/" + this.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(testModuleTwo))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(updatedModule), result);
    }

    @Test
    public void updateLecturesByModuleIdTest() throws Exception {

        List<Lecture> lectureList = new ArrayList<>();
        Lecture lectureOne = new Lecture("lecture 1");
        Lecture lectureTwo = new Lecture("lecture 2");

        lectureList.add(this.lectureRepo.save(lectureOne)); 
        lectureList.add(this.lectureRepo.save(lectureTwo)); 
        
        this.testModuleWithId.setLectures(lectureList);

        String result = this.mockMvc.perform(
            request(HttpMethod.PUT, "/module/" + this.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(lectureList))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testModuleWithId), result);
    }

    @Test
    public void deleteModuleByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.DELETE, "/teachers/module/" + this.id))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals("Module deleted successfully", result);

    }


    
}