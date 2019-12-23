package com.bae.universalapp.test.service;

import com.bae.universalapp.persistence.repo.UserRepo;
import com.bae.universalapp.service.UserService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepo userRepo;


}