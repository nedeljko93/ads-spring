package com.nedeljko.demo.service.jobservice;

import com.nedeljko.demo.dao.IJobDao;
import com.nedeljko.demo.service.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class JobServiceTest {

    @InjectMocks
    JobService jobService;

    @Mock
    IJobDao jobDao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}
