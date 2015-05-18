package object_calisthenics.jobseeker;

import org.junit.Test;

import object_calisthenics.system.*;

public class JobseekerTests
{
  private SystemJobseekers      systemJobseekers   = new SystemJobseekers();
  private SystemJobs            systemJobs         = new SystemJobs();
  private SystemJobApplications systemApplications = new SystemJobApplications();

  @Test
  public void canCreateJobseeker()
  {
    systemJobseekers.createJobseeker("Iosef");
    assert systemJobseekers.size() == 1;
  }

//  NOT TESTS

}
