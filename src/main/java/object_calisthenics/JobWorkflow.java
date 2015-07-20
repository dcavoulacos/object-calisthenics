package object_calisthenics;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.Job;
import object_calisthenics.job.JobDescription;
import object_calisthenics.job.JobTitle;
import object_calisthenics.job.Jobs;
import object_calisthenics.system.SystemJobs;

public class JobWorkflow
{
  private SystemJobs systemJobs;

  public JobWorkflow()
  {
    systemJobs = new SystemJobs();
  }

  public Job createJob(String jobTitle, Employer employer)
  {
    Job job = new Job(new JobDescription(new JobTitle(jobTitle), employer));
    systemJobs.postNewJob(job);
    return job;
  }

  public Jobs jobsPostedBy(Employer employer)
  {
    return systemJobs.postedBy(employer);
  }

  public int totalJobs()
  {
    return systemJobs.size();
  }
}
