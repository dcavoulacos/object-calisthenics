package object_calisthenics;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobapplication.SuccessfulApplication;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.Resume;
import object_calisthenics.system.SystemJobApplications;

public class JobApplicationWorkflow
{
  private SystemJobApplications systemJobApplications;

  public JobApplicationWorkflow()
  {
    systemJobApplications = new SystemJobApplications();
  }

  public JobApplication createApplicationFor(Job job, Jobseeker jobseeker, Resume resume)
  {
    Candidate candidate = new Candidate(jobseeker, resume);
    //todo: create method to determine successful vs. failed application
    return systemJobApplications.addNew(new SuccessfulApplication(candidate, job));
  }

  public JobApplications applicationsBy(Jobseeker jobseeker)
  {
    return systemJobApplications.applicationsBy(jobseeker);
  }

  public JobApplications successfulApplicationsBy(Jobseeker jobseeker)
  {
    return applicationsBy(jobseeker).successes();
  }

  public int totalApplications()
  {
    return systemJobApplications.size();
  }
}
