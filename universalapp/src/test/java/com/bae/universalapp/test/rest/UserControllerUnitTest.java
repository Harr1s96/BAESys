package com.bae.universalapp.test.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.rest.UserController;
import com.bae.universalapp.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserControllerUnitTest {

    // instantiates the UserController class as a mock object
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

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
        when(this.userService.addUser(testUser))
        .thenReturn(testUser);

        // check if the values are correct
        assertEquals(this.testUser, this.userController.addUser(testUser));

        // check that the method was called only once and with the correct parameters
        verify(this.userService, times(1)).addUser(this.testUser);
    }

    @Test
    public void getUserByIdTest() {

        when(this.userService.getUserById(this.id))
        .thenReturn(this.testUserWithId);
        
        assertEquals(this.testUserWithId, this.userController.getUserById(id));

        verify(this.userService, times(1)).getUserById(id);
    }

    @Test
    public void getAllUsersTest() {

        when(this.userService.getAllUsers())
        .thenReturn(this.userList);

        assertEquals(2, this.userController.getAllUsers().size());

        verify(this.userService, times(1)).getAllUsers();
    }

    @Test
    public void updateUserByIdTest() {

        User updatedUser = new User("jongeorgiou@coldmail.com", "pass123");

        when(this.userService.getUserById(id))
        .thenReturn(testUserWithId);

        assertEquals(testUserWithId, this.userController.getUserById(id));

        when(this.userService.updateUserById(updatedUser, id))
        .thenReturn(updatedUser);

        assertEquals(updatedUser, this.userController.updateUserById(id, updatedUser));

        verify(this.userService, times(1)).getUserById(id);
        verify(this.userService, times(1)).updateUserById(updatedUser, id);
    }

    @Test
    public void deleteUserByIdTest() {
        
        when(this.userService.deleteUserById(id))
        .thenReturn("User deleted successfully");

        assertEquals("User deleted successfully", this.userController.deleteUserById(id));

        verify(this.userService, times(1)).deleteUserById(id);

    } 

}