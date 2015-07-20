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

  public void postNewJob(Job newJob)
  {
    systemJobs = systemJobs.addNew(newJob);
  }

  public int size()
  {
    return systemJobs.size();
  }

  public Jobs postedBy(Employer employer)
  {
    return systemJobs.postedBy(employer);
  }

//  public Job createJReqJob(String jobTitle, Employer employer) {
//    JobDescription description = new JobDescription(new JobTitle(jobTitle), employer);
//    return new JReqJob(description);
//  }
//
//  public Job createATSJob(String jobTitle, Employer employer) {
//    JobDescription description = new JobDescription(new JobTitle(jobTitle), employer);
//    return new ATSJob(description);
//  }
}
