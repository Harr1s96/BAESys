package com.bae.universalapp.test.rest;

import com.bae.universalapp.rest.ModuleController;
import com.bae.universalapp.service.ModuleService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ModuleControllerUnitTest {

    @InjectMocks
    private ModuleController moduleController;

    @Mock
    private ModuleService moduleService;


}