package object_calisthenics.jobapplication;

import java.util.Date;

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

  public ApplicationDetails(Job job, Date date)
  {
    this.job = job;
    applicationDate = new ApplicationDate(date);
  }

  public boolean isForJob(Job job)
  {
    return this.job == job;
  }

  public boolean submittedOn(Date date)
  {
    return applicationDate.is(date);
  }
}
