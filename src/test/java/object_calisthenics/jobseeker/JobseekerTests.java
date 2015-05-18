package object_calisthenics.jobseeker;

import org.junit.Test;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.Job;
import object_calisthenics.job.JobType;
import object_calisthenics.jobapplication.JobApplication;
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
    Job newJob = systemJobs.createJob("Assassin", JobType.ATS, viggo);

    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
    perkins.saveJob(newJob);
    assert perkins.hasSaved(newJob);
  }

  @Test
  public void canApplytoATSJob() {
    Employer viggo = systemEmployers.createEmployer("Viggo");
    Job newJob = systemJobs.createJob("Assassin", JobType.ATS, viggo);
    viggo.postJob(newJob, systemJobs);

    Jobseeker perkins = systemJobseekers.createJobseeker("Perkins");
    JobApplication application = systemApplications.createApplication(newJob, perkins);

    perkins.applyTo(newJob, application);
  }
}
