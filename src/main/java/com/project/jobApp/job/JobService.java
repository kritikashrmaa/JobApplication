package com.project.jobApp.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);
    Job findJob(long id);
    boolean deleteJob(long id);
    boolean updateJob(long id, Job updatedJob);
}
