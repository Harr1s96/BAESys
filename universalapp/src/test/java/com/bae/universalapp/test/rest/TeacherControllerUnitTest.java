package com.bae.universalapp.test.rest;

import com.bae.universalapp.rest.TeacherController;
import com.bae.universalapp.service.ModuleService;
import com.bae.universalapp.service.TeacherService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TeacherControllerUnitTest {

    @InjectMocks
    private TeacherController teacherController;

    @Mock
    private TeacherService teacherService;

    @Mock
    private ModuleService moduleService;

}