package com.bae.universalapp.test.service;

import com.bae.universalapp.persistence.repo.TeacherRepo;
import com.bae.universalapp.service.TeacherService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TeacherServiceUnitTest {

    @InjectMocks
    private TeacherService teacherService;

    @Mock
    private TeacherRepo teacherRepo;


}