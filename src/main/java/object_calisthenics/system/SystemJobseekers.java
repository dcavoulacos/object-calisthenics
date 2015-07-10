package object_calisthenics.system;

import object_calisthenics.jobseeker.*;

public class SystemJobseekers
{
  private Jobseekers systemJobseekers;
  
  public SystemJobseekers() { this.systemJobseekers = new Jobseekers();}

  public Jobseeker createJobseeker(String name) {
    Jobseeker Jobseeker = new Jobseeker(new JobseekerName(name));
    systemJobseekers = systemJobseekers.addNewJobseeker(Jobseeker);
    return Jobseeker;
  }

  public int size() {
    return systemJobseekers.size();
  }
}
