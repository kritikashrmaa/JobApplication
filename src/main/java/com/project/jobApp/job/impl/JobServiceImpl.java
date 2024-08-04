package com.project.jobApp.job.impl;

import com.project.jobApp.job.Job;
import com.project.jobApp.job.JobRepository;
import com.project.jobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
  //  private List<Job> jobs=new ArrayList<>();
    private long nextId=1L;
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

        job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job findJob(long id) {
      return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(long id, Job updatedJob) {

        Optional<Job> jobOptional=jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setId(updatedJob.getId());
                job.setDescription(updatedJob.getDescription());
                job.setTitle(updatedJob.getTitle());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                jobRepository.save(job);
                return true;
            }


        return false;

    }
}
