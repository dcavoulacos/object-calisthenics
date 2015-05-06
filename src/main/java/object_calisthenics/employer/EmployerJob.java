package object_calisthenics.employer;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.JobApplications;

public class EmployerJob
{
  private Job                   postedJob;
  private final JobApplications applications;

  public EmployerJob(Job postedJob) {
    this.postedJob    = postedJob;
    this.applications = new JobApplications();
  }
}
