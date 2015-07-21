package object_calisthenics.jobseeker;

import org.junit.Test;

import object_calisthenics.EmployerWorkflow;
import object_calisthenics.JobApplicationWorkflow;
import object_calisthenics.JobWorkflow;
import object_calisthenics.JobseekerWorkflow;
import object_calisthenics.ResumeWorkflow;
import object_calisthenics.employer.Employer;
import object_calisthenics.job.*;
import object_calisthenics.resume.*;

public class JobseekerTests
{
  private JobseekerWorkflow      jobseekerWorkflow      = new JobseekerWorkflow();
  private JobWorkflow            jobWorkflow            = new JobWorkflow();
  private EmployerWorkflow       employerWorkflow       = new EmployerWorkflow();
  private JobApplicationWorkflow jobApplicationWorkflow = new JobApplicationWorkflow();
  private ResumeWorkflow         resumeWorkflow         = new ResumeWorkflow();

  @Test
  public void canCreateJobseeker()
  {
    jobseekerWorkflow.createJobseeker("Perkins");
    assert jobseekerWorkflow.totalJobseekers() == 1;
  }

  @Test
  public void canSaveJobs()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createJREQForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    assert perkins.numberOfSavedJobs() == 0;

    perkins.saveJob(newJob);

    assert perkins.numberOfSavedJobs() == 1;
  }

  @Test
  public void canApplyToJReqWithValidResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createJREQForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    Resume resume = resumeWorkflow.newResumeFor(perkins);
    assert jobApplicationWorkflow.totalApplications() == 0;

    jobApplicationWorkflow.createApplicationFor(newJob, perkins, resume);

    assert jobApplicationWorkflow.totalApplications() == 1;
    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successfulApplicationsBy(perkins).size() == 1;
  }

  @Test
  public void canApplyToATSWithValidResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createATSForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    Resume resume = resumeWorkflow.newResumeFor(perkins);
    assert jobApplicationWorkflow.totalApplications() == 0;

    jobApplicationWorkflow.createApplicationFor(newJob, perkins, resume);

    assert jobApplicationWorkflow.totalApplications() == 1;
    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successfulApplicationsBy(perkins).size() == 1;
  }

  @Test
  public void jReqApplicationFailsWithInvalidResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createJREQForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    Jobseeker vitali = jobseekerWorkflow.createJobseeker("Vitali");
    Resume resume = resumeWorkflow.newResumeFor(vitali);

    jobApplicationWorkflow.createApplicationFor(newJob, perkins, resume);

    assert jobApplicationWorkflow.totalApplications() == 1;
    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successfulApplicationsBy(perkins).size() == 0;
  }

  @Test
  public void jreqApplicationFailsWithoutResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createJREQForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    assert jobApplicationWorkflow.totalApplications() == 0;

    jobApplicationWorkflow.createApplicationFor(newJob, perkins);

    assert jobApplicationWorkflow.totalApplications() == 1;
    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successfulApplicationsBy(perkins).size() == 0;
  }

  @Test
  public void canApplyToATSWithoutResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createATSForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    assert jobApplicationWorkflow.totalApplications() == 0;

    jobApplicationWorkflow.createApplicationFor(newJob, perkins);

    assert jobApplicationWorkflow.totalApplications() == 1;
    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successfulApplicationsBy(perkins).size() == 1;
  }

//  @Test
//  public void canApplyToDifferentJobsWithDifferentResumes()
//  {
//
//  }

//  @Test
//  public void canApplyToJReqJobWithResume() {
//    Employer viggo = systemEmployers.addNew("Viggo");
//    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
//    Job newJob = systemJobs.createJReqJob("Assassin", viggo);
//    Resume resume = new ValidResume(perkins);
//
//    viggo.postJob(newJob, systemJobs);
//    perkins.applyTo(newJob, resume, systemApplications);
//    assert systemApplications.size() == 1;
//  }

//  @Test
//  public void applyingToJReqJobWithoutResumeResultsInFailedApplication() {
//    Employer viggo = systemEmployers.addNew("Viggo");
//    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
//    Job newJob = systemJobs.createJReqJob("Assassin", viggo);
//
//    viggo.postJob(newJob, systemJobs);
//    perkins.applyTo(newJob, systemApplications);
//  }

//  @Test
//  public void canApplyToATSJob() {
//    Employer viggo = systemEmployers.addNew("Viggo");
//    Job newJob = systemJobs.createATSJob("Assassin", viggo);
//    viggo.postJob(newJob, systemJobs);
//
//    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
//    perkins.applyTo(newJob, systemApplications);
//    perkins.applyTo(newJob, application);
//  }
}
