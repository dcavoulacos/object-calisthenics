package object_calisthenics.jobseeker;

import org.junit.Test;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.*;
import object_calisthenics.resume.*;
import object_calisthenics.system.*;

public class JobseekerTests
{
  private SystemEmployers       systemEmployers    = new SystemEmployers();
  private SystemJobseekers      systemJobseekers   = new SystemJobseekers();
  private SystemJobs            systemJobs         = new SystemJobs();
  private SystemJobApplications systemApplications = new SystemJobApplications();

  @Test
  public void canCreateJobseeker()
  {
    systemJobseekers.createJobseeker("Perkins");
    assert systemJobseekers.size() == 1;
  }

  @Test
  public void canSaveJobs() {
    Employer viggo = systemEmployers.createEmployer("Viggo");
    Job newJob = systemJobs.createATSJob("Assassin", viggo);

    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
    perkins.saveJob(newJob);
    assert perkins.hasSaved(newJob);
  }

  @Test
  public void canApplyToJReqJobWithResume() {
    Employer viggo = systemEmployers.createEmployer("Viggo");
    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
    Job newJob = systemJobs.createJReqJob("Assassin", viggo);
    Resume resume = new RealResume(perkins);

    viggo.postJob(newJob, systemJobs);
    perkins.applyTo(newJob, resume, systemApplications);
    assert systemApplications.size() == 1;
  }

//  @Test
//  public void applyingToJReqJobWithoutResumeResultsInFailedApplication() {
//    Employer viggo = systemEmployers.createEmployer("Viggo");
//    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
//    Job newJob = systemJobs.createJReqJob("Assassin", viggo);
//
//    viggo.postJob(newJob, systemJobs);
//    perkins.applyTo(newJob, systemApplications);
//  }

//  @Test
//  public void canApplyToATSJob() {
//    Employer viggo = systemEmployers.createEmployer("Viggo");
//    Job newJob = systemJobs.createATSJob("Assassin", viggo);
//    viggo.postJob(newJob, systemJobs);
//
//    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
//    perkins.applyTo(newJob, systemApplications);
//    perkins.applyTo(newJob, application);
//  }
}
