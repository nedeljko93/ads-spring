package com.nedeljko.demo.service.jobservice;

import com.nedeljko.demo.entity.Job;
import com.nedeljko.demo.model.response.MessageResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AddJobTests extends JobServiceTest {

    @Test
    void shouldAddJob_WhenCorrectParametersPassed() {
        // given
        Job job = new Job();
        when(jobDao.addJob(job)).thenReturn(new MessageResponse("job added"));
        var expected = new MessageResponse("job added");

        // when
        MessageResponse actual = jobService.addJob(job);

        // then
        assertEquals(expected, actual);
    }
}
