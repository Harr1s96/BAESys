package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.repo.LectureRepo;
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
 * LectureControllerIntegrationTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class LectureControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LectureRepo lectureRepo;

    private Lecture testLecture;
    private Lecture testLectureWithId;
    private long id;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {

        this.lectureRepo.deleteAll();

        this.testLecture = new Lecture("lecture 1");
        this.testLectureWithId = this.lectureRepo.save(this.testLecture);
        this.id = this.testLectureWithId.getId();
    }

    @Test
    public void addLectureTest() throws Exception {
        
        String result = this.mockMvc.perform(
            request(HttpMethod.POST, "/module/lectures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(testLecture)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testLectureWithId), result);
    }

    @Test
    public void getAllLecturesTest() throws Exception {

        List<Lecture> lectureList = new ArrayList<>();
        Lecture secondTestLecture = new Lecture("lecture 2");
        this.lectureRepo.save(secondTestLecture);

        lectureList.add(this.testLectureWithId);
        lectureList.add(secondTestLecture);

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, "/lecture")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        assertEquals(this.mapper.writeValueAsString(lectureList), result);
    }

    @Test
    public void getLectureByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, String.format("/lecture/%s", this.id))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testLectureWithId), result);
    }

    @Test
    public void updateLectureByIdTest() throws Exception {

        Lecture secondTestLecture = new Lecture("statistics");
        Lecture updatedLecture = new Lecture(secondTestLecture.getLectureName());
        updatedLecture.setId(this.id);

        String result = this.mockMvc.perform(
            request(HttpMethod.PUT, "/lecture/?id=" + this.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(secondTestLecture))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(updatedLecture), result);
    }

    @Test
    public void deleteLectureByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.DELETE, "/lecture/" + this.id))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals("Lecture deleted successfully", result);
    }



    
}