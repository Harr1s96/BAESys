package com.bae.universalapp.test.rest;

import com.bae.universalapp.rest.LectureController;
import com.bae.universalapp.service.LectureService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LectureControllerUnitTest {

    @InjectMocks
    private LectureController lectureController;

    @Mock
    private LectureService lectureService;


}