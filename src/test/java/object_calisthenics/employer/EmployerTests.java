package object_calisthenics.employer;

import org.junit.Test;

import object_calisthenics.EmployerWorkflow;
import object_calisthenics.JobApplicationWorkflow;
import object_calisthenics.JobWorkflow;
import object_calisthenics.JobseekerWorkflow;
import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseeker;

public class EmployerTests
{
  private EmployerWorkflow       employerWorkflow    = new EmployerWorkflow();
  private JobWorkflow            jobWorkflow         = new JobWorkflow();
  private JobseekerWorkflow      jobseekerWorkflow   = new JobseekerWorkflow();
  private JobApplicationWorkflow applicationWorkflow = new JobApplicationWorkflow();

  @Test
  public void canCreateEmployer()
  {
    employerWorkflow.createEmployer("John Wick");
    assert employerWorkflow.totalEmployers() == 1;
  }

  @Test
  public void canPostAJob()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    assert jobWorkflow.totalJobs() == 0;
    jobWorkflow.createJREQForEmployer("Hitman", johnWick);
    assert jobWorkflow.totalJobs() == 1;
  }

  @Test
  public void canSeePostedJobs()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Employer notJohn = employerWorkflow.createEmployer("Baba Yaga");

    jobWorkflow.createJREQForEmployer("Hitman", johnWick);
    jobWorkflow.createJREQForEmployer("Assistant Hitman", johnWick);
    jobWorkflow.createJREQForEmployer("Russian Demon", notJohn);

    assert johnWick.postedJobs(jobWorkflow).size() == 2;
    assert jobWorkflow.totalJobs() == 3;
  }

  @Test
  public void canSeeAllApplications()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido");

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(hitman, fido1);

    Jobs jobs = johnWick.postedJobs(jobWorkflow);
    assert johnWick.receivedApplications(applicationWorkflow, jobs).size() == 2;
  }

  @Test
  public void canSeeAllApplicants()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido2 = jobseekerWorkflow.createJobseeker("Fido");

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(hitman, fido1);
    applicationWorkflow.createApplicationFor(hitman, fido2);

    Jobs jobs = johnWick.postedJobs(jobWorkflow);
    JobApplications applications = johnWick.receivedApplications(applicationWorkflow, jobs);
    assert johnWick.applicants(jobseekerWorkflow, applications).size() == 3;
  }


}
