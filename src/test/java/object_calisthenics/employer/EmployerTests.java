package object_calisthenics.employer;

import java.util.Date;

import org.junit.Test;

import object_calisthenics.EmployerWorkflow;
import object_calisthenics.JobApplicationWorkflow;
import object_calisthenics.JobWorkflow;
import object_calisthenics.JobseekerWorkflow;
import object_calisthenics.job.Job;
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

    assert jobWorkflow.jobsPostedBy(johnWick).size() == 2;
    assert jobWorkflow.totalJobs() == 3;
  }

  @Test
  public void canSeeAllApplications()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);
    Job helper = jobWorkflow.createATSForEmployer("Asst. Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido 1");

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(helper, fido1);
    applicationWorkflow.createApplicationFor(hitman, fido1);

    assert applicationWorkflow.applicationsFor(johnWick.postedJobs()).size() == 3;
  }

  @Test
  public void canSeeAllApplicants()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);
    Job helper = jobWorkflow.createATSForEmployer("Asst. Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido 1");

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(helper, fido1);
    applicationWorkflow.createApplicationFor(hitman, fido1);

    assert jobseekerWorkflow.jobseekersWithApplicationsFor(johnWick.postedJobs()).size() == 2;
  }

  @Test
  public void canFilterApplicantsByJob()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);
    Job helper = jobWorkflow.createATSForEmployer("Asst. Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido2 = jobseekerWorkflow.createJobseeker("Fido");

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(helper, fido1);
    applicationWorkflow.createApplicationFor(hitman, fido2);

    assert jobseekerWorkflow.jobseekersWithApplicationsFor(johnWick.postedJobs()).size() == 3;
    assert jobseekerWorkflow.jobseekersWithApplicationsFor(hitman.forEmployer(johnWick)).size() == 2;
    assert jobseekerWorkflow.jobseekersWithApplicationsFor(helper.forEmployer(johnWick)).size() == 1;
  }

  @Test
  public void canFilterApplicantsByDate()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido");

    Date today = new Date();
    Date yesterday = new Date(today.getTime() - (1000*60*60*24));

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(hitman, fido1, yesterday);

    assert jobseekerWorkflow.jobseekersWithApplicationsFor(johnWick.postedJobs()).size() == 2;
    assert jobseekerWorkflow.jobseekersWithApplicationsSubmitted(yesterday).size() == 1;
  }

  @Test
  public void canFilterApplicantsByJobAndDate()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);
    Job helper = jobWorkflow.createATSForEmployer("Asst. Hitman", johnWick);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido 1");
    Jobseeker fido2 = jobseekerWorkflow.createJobseeker("Fido 2");

    Date today = new Date();
    Date yesterday = new Date(today.getTime() - (1000*60*60*24));

    applicationWorkflow.createApplicationFor(hitman, fido, yesterday);
    applicationWorkflow.createApplicationFor(helper, fido);
    applicationWorkflow.createApplicationFor(helper, fido1, yesterday);
    applicationWorkflow.createApplicationFor(hitman, fido1);
    applicationWorkflow.createApplicationFor(hitman, fido2);

    assert jobseekerWorkflow.jobseekersWithApplicationsFor(johnWick.postedJobs()).size() == 3;

    assert applicationWorkflow.applicationsFor(helper.forEmployer(johnWick)).size() == 2;
    assert applicationWorkflow.applicationsFor(hitman.forEmployer(johnWick)).size() == 3;

    assert jobseekerWorkflow.jobseekersWithApplicationsSubmitted(yesterday).size() == 2;
    assert jobseekerWorkflow.jobseekersWithApplicationsSubmitted(today).size() == 3;


    assert jobseekerWorkflow.jobseekersWithApplicationsForJobFromDate(hitman, yesterday).size() == 1;
    assert jobseekerWorkflow.jobseekersWithApplicationsForJobFromDate(helper, yesterday).size() == 1;

    assert jobseekerWorkflow.jobseekersWithApplicationsForJobFromDate(hitman, today).size() == 2;
  }

  @Test
  public void cantSeeApplicantsToOtherRecruitersJobs()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Employer viggo    = employerWorkflow.createEmployer("Viggo");
    Job hitman = jobWorkflow.createATSForEmployer("Hitman", johnWick);
    Job helper = jobWorkflow.createATSForEmployer("Asst. Hitman", viggo);

    Jobseeker fido  = jobseekerWorkflow.createJobseeker("Fido");
    Jobseeker fido1 = jobseekerWorkflow.createJobseeker("Fido");

    applicationWorkflow.createApplicationFor(hitman, fido);
    applicationWorkflow.createApplicationFor(hitman, fido1);
    applicationWorkflow.createApplicationFor(helper, fido1);

//    assert johnWick.applicationsFor(jobseekerWorkflow, helper).size() == 0;
//    assert viggo.applicationsFor(jobseekerWorkflow, hitman).size() == 0;
    assert johnWick.applicants(jobseekerWorkflow).size() == 2;
    assert viggo.applicants(jobseekerWorkflow).size() == 1;
  }

}
