package com.project.jobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // when we hit "/jobs" URL then this function will be invoked
    @GetMapping("/jobs")
     public ResponseEntity<List<Job>> findAll(){

         return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
     }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJob(@PathVariable long id){

        Job job= jobService.findJob(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }

        return new ResponseEntity<>( new Job(1L,"testJob","test job","2000","2000","testLoc"),HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id){

        Job job= jobService.deleteJob(id);
        if(job!=null){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>( "Job not found",HttpStatus.NO_CONTENT);
    }

     @PostMapping("/jobs")
    public ResponseEntity<String> createJob( @RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("job added successfully",HttpStatus.OK);
     }

     @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id,@RequestBody Job updatedJob){
         Job job= jobService.updateJob(id,updatedJob);
         if(job!=null){
             return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
         }

         return new ResponseEntity<>( "Job not found",HttpStatus.NO_CONTENT);
     }


}
