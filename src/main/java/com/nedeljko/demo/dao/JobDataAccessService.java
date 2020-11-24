package com.nedeljko.demo.dao;

import com.nedeljko.demo.model.Job;
import com.nedeljko.demo.model.ResponseMessage;
import com.nedeljko.demo.model.User;
import com.nedeljko.demo.repo.JobRepo;
import com.nedeljko.demo.repo.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("JobDao")
public class JobDataAccessService implements JobDao {
    private JobRepo jobRepo;
    private List<Job> DB_JOBS = new ArrayList<>();

    public JobDataAccessService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public ResponseMessage addJob(UUID id, Job job) {
        jobRepo.save(new Job(id, job.getJob_title(), job.getJob_description(), job.getRequred_skills(),
                job.getJob_offer(), job.getLocation(),
                job.getCompany_name(), job.getDate(), job.getRequred_level(),
                job.getTechnologies_requred(), job.getCompany_email(), job.getIs_promoted(), job.getUser(), job.getBonus_skills()));
        return new ResponseMessage("Job add");
    }

    @Override
    public List<Job> getListOfJobs() {
        return (List<Job>) jobRepo.findAll();
    }

    @Override
    public ResponseMessage deleteJob(UUID id) {
        Job job = selectJobByID(id);
        if (job.getId().equals(id)) {
            jobRepo.delete(job);
            return new ResponseMessage("Job deleted");
        }
        return new ResponseMessage("Wrong ID");

    }

    @Override
    public ResponseMessage updateJob(UUID id, Job job) {
        Job j = selectJobByID(id);
        if (j != null) {
            DB_JOBS = (List<Job>) jobRepo.findAll();
            int indexOfJob = DB_JOBS.indexOf(j);
            DB_JOBS.set(indexOfJob, new Job(id, job.getJob_title(), job.getJob_description(), job.getRequred_skills(),
                    job.getJob_offer(), job.getLocation(),
                    job.getCompany_name(), job.getDate(), job.getRequred_level(),
                    job.getTechnologies_requred(), job.getCompany_email(), job.getIs_promoted(), job.getUser(), job.getBonus_skills()));
            jobRepo.saveAll(DB_JOBS);
            return new ResponseMessage("Job updated");
        }
        return new ResponseMessage("Wrong ID");
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
