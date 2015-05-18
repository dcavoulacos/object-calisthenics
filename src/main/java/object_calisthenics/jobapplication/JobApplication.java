package object_calisthenics.jobapplication;

import object_calisthenics.job.Job;

public class JobApplication
{
  private Job                job;
  private ApplicationDetails details;

  public JobApplication(Job job, ApplicationDetails details) {
    this.job      = job;
    this.details  = details;
  }
}
