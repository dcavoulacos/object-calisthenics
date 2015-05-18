package object_calisthenics.jobseeker;

import object_calisthenics.job.Job;

public class Jobseeker
{
  private JobseekerName       name;
  private JobseekerResources  resources;

  public Jobseeker(JobseekerName name) {
    this.name       = name;
    this.resources  = new JobseekerResources();
  }

  public void saveJob(Job job) { resources.saveJob(job); }
}
