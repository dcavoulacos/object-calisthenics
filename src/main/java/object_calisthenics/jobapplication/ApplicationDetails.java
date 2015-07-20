package object_calisthenics.jobapplication;

import object_calisthenics.job.Job;

public class ApplicationDetails
{
  private Job             job;
  private ApplicationDate applicationDate;

  public ApplicationDetails(Job job)
  {
    this.job             = job;
    this.applicationDate = new ApplicationDate();
  }
}
