package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.persistence.repo.UserRepo;
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
 * UserControllerIntegrationTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest // marks the class as an integration test class
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // creates mock HTTP requests
    
    @Autowired
    private UserRepo userRepo; 

    private User testUser;
    private User testUserWithId;
    private Long id;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {

        this.userRepo.deleteAll();
        
        this.testUser = new User("harris@email.com", "mypass");
        this.testUserWithId = this.userRepo.save(testUser);

        this.id = this.testUserWithId.getId();
    }

    @Test
    public void addUserTest() throws Exception {

        // the perform method throws an exception
        String result = this.mockMvc.perform(
            request(HttpMethod.POST, "/user")
            .contentType(MediaType.APPLICATION_JSON) // tells server the data type sent
            .content(this.mapper.writeValueAsString(testUser)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testUserWithId), result);      
    }

    @Test
    public void getAllUsersTest() throws Exception {

        List<User> userList = new ArrayList<>();
        User secondTestUser = new User("mfarrow@mail.com", "password");
        this.userRepo.save(secondTestUser);

        userList.add(this.testUserWithId);
        userList.add(secondTestUser);

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, "/getUsers")
            .accept(MediaType.APPLICATION_JSON)) // tells the server to send back JSON
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        assertEquals(this.mapper.writeValueAsString(userList), result);

    }

    @Test
    public void getUserByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.GET, String.format("/user/%s", this.id))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(testUserWithId), result);

    }

    @Test
    public void updateUserById() throws Exception {

        User secondTestUser = new User("mfarrow@mail.com", "password");
        User updatedUser = new User(secondTestUser.getEmail(), secondTestUser.getPassword());
        updatedUser.setId(this.id);

        String result = this.mockMvc.perform(
            request(HttpMethod.PUT, "/updateUser/?id=" + this.id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(secondTestUser))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals(this.mapper.writeValueAsString(updatedUser), result);
    }

    @Test
    public void deleteUserByIdTest() throws Exception {

        String result = this.mockMvc.perform(
            request(HttpMethod.DELETE, "/user/" + this.id))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
        
        assertEquals("User deleted successfully", result);
    }
}