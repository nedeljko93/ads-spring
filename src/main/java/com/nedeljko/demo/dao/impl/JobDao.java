package com.nedeljko.demo.dao.impl;

import com.nedeljko.demo.dao.IJobDao;
import com.nedeljko.demo.entity.Job;
import com.nedeljko.demo.model.response.MessageResponse;
import com.nedeljko.demo.repository.JobRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("JobDao")
public class JobDao implements IJobDao {
    private JobRepo jobRepo;
    private List<Job> DB_JOBS = new ArrayList<>();

    public JobDao(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public MessageResponse addJob(UUID id, Job job) {
        jobRepo.save(new Job(id, job.getJob_title(), job.getJob_description(), job.getRequred_skills(),
                job.getJob_offer(), job.getLocation(),
                job.getCompany_name(), job.getDate(), job.getRequred_level(),
                job.getTechnologies_requred(), job.getCompany_email(), job.getIs_promoted(), job.getUser(), job.getBonus_skills()));
        return new MessageResponse("Job add");
    }

    @Override
    public List<Job> getListOfJobs() {
        return (List<Job>) jobRepo.findAll();
    }

    @Override
    public MessageResponse deleteJob(UUID id) {
        Job job = selectJobByID(id);
        if (job.getId().equals(id)) {
            jobRepo.delete(job);
            return new MessageResponse("Job deleted");
        }
        return new MessageResponse("Wrong ID");

    }

    @Override
    public MessageResponse updateJob(UUID id, Job job) {
        Job j = selectJobByID(id);
        if (j != null) {
            DB_JOBS = (List<Job>) jobRepo.findAll();
            int indexOfJob = DB_JOBS.indexOf(j);
            DB_JOBS.set(indexOfJob, new Job(id, job.getJob_title(), job.getJob_description(), job.getRequred_skills(),
                    job.getJob_offer(), job.getLocation(),
                    job.getCompany_name(), job.getDate(), job.getRequred_level(),
                    job.getTechnologies_requred(), job.getCompany_email(), job.getIs_promoted(), job.getUser(), job.getBonus_skills()));
            jobRepo.saveAll(DB_JOBS);
            return new MessageResponse("Job updated");
        }
        return new MessageResponse("Wrong ID");
    }

    private Job selectJobByID(UUID id) {
        List<Job> jobs = getListOfJobs();
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }
}
