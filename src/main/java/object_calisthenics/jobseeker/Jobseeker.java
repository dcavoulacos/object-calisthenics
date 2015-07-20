package object_calisthenics.jobseeker;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.resume.*;
import object_calisthenics.system.SystemJobApplications;

public class Jobseeker
{
  private JobseekerName       name;
  private JobseekerResources  resources;

  public Jobseeker(JobseekerName name)
  {
    this.name       = name;
    this.resources  = new JobseekerResources();
  }

  public void saveJob(Job job)
  {
    resources.saveJob(job);
  }

  public int numberOfSavedJobs()
  {
    return resources.numberOfSavedJobs();
  }

//  public boolean hasSaved(Job job)
//  {
//    return resources.hasSaved(job);
//  }
//
//  public void applyTo(Job job, SystemJobApplications destination)
//  {
//    this.applyTo(job, new NullResume(), destination);
//  }
//
//  public void applyTo(Job job, Resume resume, SystemJobApplications destination)
//  {
////    job.applyTo(this, resume, destination);
//  }
}
