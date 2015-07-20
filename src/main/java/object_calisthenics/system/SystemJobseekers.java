package object_calisthenics.system;

import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.jobseeker.Jobseekers;

public class SystemJobseekers
{
  private Jobseekers systemJobseekers;

  public SystemJobseekers()
  {
    this.systemJobseekers = new Jobseekers();
  }

  public Jobseeker addNew(Jobseeker jobseeker)
  {
    systemJobseekers = systemJobseekers.addNew(jobseeker);
    return jobseeker;
  }

  public int size()
  {
    return systemJobseekers.size();
  }
}
