package object_calisthenics.system;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;

public class SystemJobs
{
  private Jobs systemJobs;

  public SystemJobs()
  {
    this.systemJobs = new Jobs();
  }

  public Job addNew(Job newJob, Employer employer)
  {
    systemJobs = systemJobs.addNew(newJob);
    employer.postJob(newJob);
    return newJob;
  }

  public int size()
  {
    return systemJobs.size();
  }

  public Jobs postedBy(Employer employer)
  {
    return systemJobs.postedBy(employer);
  }
}
