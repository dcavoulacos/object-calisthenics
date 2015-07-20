package object_calisthenics;

import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.jobseeker.JobseekerName;
import object_calisthenics.system.SystemJobseekers;

public class JobseekerWorkflow
{
  private SystemJobseekers systemJobseekers;

  public JobseekerWorkflow()
  {
    systemJobseekers = new SystemJobseekers();
  }

  public Jobseeker createJobseeker(String name)
  {
    Jobseeker jobseeker = new Jobseeker(new JobseekerName(name));
    return systemJobseekers.addNew(jobseeker);
  }

  public int totalJobseekers()
  {
    return systemJobseekers.size();
  }
}
