package com.project.jobApp.job.impl;

import com.project.jobApp.job.Job;
import com.project.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs=new ArrayList<>();
    private long nextId=1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {

        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findJob(long id) {
        for(Job jobs:jobs){
            if(jobs.getId()==id){
                return jobs;
            }
        }

        return null;
    }

    @Override
    public Job deleteJob(long id) {
        for(Job job:jobs){
            if(job.getId()==id){
                jobs.remove(job);
                return job;
            }
        }

        return null;

    }

    @Override
    public Job updateJob(long id,Job updatedJob) {
        for(Job job:jobs){
            if(job.getId()==id){
                job.setId(updatedJob.getId());
                job.setDescription(updatedJob.getDescription());
                job.setTitle(updatedJob.getTitle());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                return job;
            }
        }

        return null;

    }
}
