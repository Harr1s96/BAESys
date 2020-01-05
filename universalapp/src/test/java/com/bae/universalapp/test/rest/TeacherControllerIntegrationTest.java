package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.bae.universalapp.persistence.repo.TeacherRepo;
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
 * TeacherControllerIntegrationTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TeacherControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private ModuleRepo moduleRepo;

    private Teacher testTeacher;
    private Teacher testTeacherWithId;
    private long id;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {

        this.teacherRepo.deleteAll();
        this.moduleRepo.deleteAll();

        this.testTeacher = new Teacher("Matt", "Farrow");
        this.testTeacher.setModules(Collections.emptyList());
        this.testTeacherWithId = this.teacherRepo.save(testTeacher);
        this.id = testTeacherWithId.getId();

    }

    @Test
    public void addTeacherTest() throws Exception {

        Teacher testTeacherTwo = new Teacher("Jonathan", "Georgiou");

        List<Module> moduleList = new ArrayList<>();
        Module firstModule = new Module("Intro Quantum Chemistry", "CHEM 355");
        Module secondModule = new Module("Group Theory", "CHEM 382");

        moduleList.add(firstModule);
        moduleList.add(secondModule);
        testTeacherTwo.setModules(moduleList);
        
        this.teacherRepo.save(testTeacherTwo);

        String result = this.mockMvc.perform(
            request(HttpMethod.POST, "/teacher")
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(testTeacherTwo)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testTeacherTwo), result);
    }

    @Test
    public void getAllTeachersTest() throws Exception {

        List<Teacher> teacherList = new ArrayList<>();
        
        Teacher secondTestTeacher = new Teacher("Liam", "McIvor");
        secondTestTeacher.setModules(Collections.emptyList());
        this.teacherRepo.save(secondTestTeacher);

        teacherList.add(this.testTeacherWithId);
        teacherList.add(secondTestTeacher);

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, "/teachers")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        assertEquals(this.mapper.writeValueAsString(teacherList), result);
    }

    @Test
    public void getTeacherByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, String.format("/teacher/%s", this.id))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testTeacherWithId), result);
    }

    @Test
    public void updateTeacherByIdTest() throws Exception {

        Teacher testTeacherTwo = new Teacher("Jonathan", "Georgiou");
        Teacher updatedTeacher = new Teacher(testTeacherTwo.getFirstName(), testTeacherTwo.getLastName());
        updatedTeacher.setId(this.id);
        updatedTeacher.setModules(Collections.emptyList());
        
        String result = this.mockMvc.perform(
            request(HttpMethod.PUT, "/teacher/?id=" + this.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(testTeacherTwo))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(updatedTeacher), result);
    }

    @Test
    public void deleteTeacherByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.DELETE, "/teacher/" + this.id))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals("Teacher deleted successfully", result);
    }  
}