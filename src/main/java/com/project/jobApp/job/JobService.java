package com.project.jobApp.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);
    Job findJob(long id);
    Job deleteJob(long id);
    Job updateJob(long id,Job updatedJob);
}
