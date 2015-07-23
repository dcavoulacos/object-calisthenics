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

    jobApplicationWorkflow.createApplicationFor(newJob, perkins, resume);

    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 1;
  }

  @Test
  public void canApplyToATSWithValidResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createATSForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    Resume resume = resumeWorkflow.newResumeFor(perkins);

    jobApplicationWorkflow.createApplicationFor(newJob, perkins, resume);

    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 1;
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

    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 0;
    assert jobApplicationWorkflow.failuresBy(perkins).size() == 1;
  }

  @Test
  public void jreqApplicationFailsWithoutResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createJREQForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");

    jobApplicationWorkflow.createApplicationFor(newJob, perkins);

    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 0;

    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 0;
    assert jobApplicationWorkflow.failuresBy(perkins).size() == 1;
  }

  @Test
  public void canApplyToATSWithoutResume()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createATSForEmployer("Assassin", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");

    jobApplicationWorkflow.createApplicationFor(newJob, perkins);

    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 1;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 1;
  }

  @Test
  public void canApplyToDifferentJobsWithDifferentResumes()
  {
    Employer viggo = employerWorkflow.createEmployer("Viggo");
    Job newJob = jobWorkflow.createJREQForEmployer("Assassin", viggo);
    Job otherJob = jobWorkflow.createJREQForEmployer("Hotel Manager", viggo);

    Jobseeker perkins = jobseekerWorkflow.createJobseeker("Perkins");
    Resume resume = resumeWorkflow.newResumeFor(perkins);
    Resume otherResume = resumeWorkflow.newResumeFor(perkins);

    jobApplicationWorkflow.createApplicationFor(newJob, perkins, resume);
    jobApplicationWorkflow.createApplicationFor(otherJob, perkins, otherResume);

    assert jobApplicationWorkflow.totalApplications() == 2;
    assert jobApplicationWorkflow.applicationsBy(perkins).size() == 2;
    assert jobApplicationWorkflow.successesBy(perkins).size() == 2;
  }

}
