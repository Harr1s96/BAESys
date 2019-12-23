package com.bae.universalapp.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.persistence.repo.UserRepo;
import com.bae.universalapp.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {

    // instantiates the UserService class as a mock object
    @InjectMocks
    private UserService userService;

    // injects object dependencies into the UserService instance
    @Mock
    private UserRepo userRepo;

    // intance variables needed to conduct the tests
    private List<User> userList;

    private User testUser;

    private User testUserWithId;

    private final Long id = 2L;

    // makes sure the class variables return to default values before each test
    @Before
    public void init() {
        
        this.userList = new ArrayList<>();
        this.testUser = new User("harris@email.com", "mypass");
        this.testUserWithId = new User("mattfarrow@mail.com", "password");

        this.userList.add(testUser);
        this.userList.add(testUserWithId);
        this.testUserWithId.setId(this.id);   
    }

    @Test
    public void addUserTest() {
        
        // when the save method is called, return the testUser object
        when(this.userRepo.save(testUser))
        .thenReturn(testUser);

        // check if the values are correct
        assertEquals(this.testUser, this.userService.addUser(testUser));

        // check that the method was called only once and with the correct parameters
        verify(this.userRepo, times(1)).save(this.testUser);
    }

    @Test
    public void getUserByIdTest() {

        when(this.userRepo.findById(this.id))
        .thenReturn(Optional.of(this.testUserWithId));
        
        assertEquals(this.testUserWithId, this.userService.getUserById(id));

        verify(this.userRepo, times(1)).findById(id);
    }

    @Test
    public void getAllUsersTest() {

        when(this.userRepo.findAll())
        .thenReturn(this.userList);

        assertEquals(2, this.userService.getAllUsers().size());

        verify(this.userRepo, times(1)).findAll();
    }

    @Test
    public void updateUserByIdTest() {

    }

    @Test
    public void deleteUserByIdTest() {

    } 


}