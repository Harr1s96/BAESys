package com.bae.universalapp.test.service;

import com.bae.universalapp.persistence.repo.LectureRepo;
import com.bae.universalapp.service.LectureService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LectureServiceUnitTest {

    @InjectMocks
    private LectureService lectureService;

    @Mock
    private LectureRepo lectureRepo;


}