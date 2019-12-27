package com.bae.universalapp.test.service;

import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.bae.universalapp.service.ModuleService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ModuleServiceUnitTest {

    @InjectMocks
    private ModuleService moduleService;

    @Mock
    private ModuleRepo moduleRepo;


}