package object_calisthenics.employer;

import org.junit.Test;

import object_calisthenics.job.*;
import object_calisthenics.system.*;

public class EmployerTests
{
  private SystemEmployers systemEmployers = new SystemEmployers();
  private SystemJobs      systemJobs      = new SystemJobs();

  @Test
  public void canCreateEmployer()
  {
    systemEmployers.createEmployer("John Wick");
    assert systemEmployers.size() == 1;
  }

  @Test
  public void canPostAJob()
  {
    Employer johnWick = systemEmployers.createEmployer("John Wick");

    Job newJob = systemJobs.createJReqJob("Hitman", johnWick);
    assert systemJobs.size() == 0;
    johnWick.postJob(newJob, systemJobs);
    assert systemJobs.size() == 1;
  }

  @Test
  public void canSeePostedJobs()
  {
    Employer johnWick = systemEmployers.createEmployer("John Wick");
    Employer notJohn = systemEmployers.createEmployer("Baba Yaga");

    Job newJob = systemJobs.createATSJob("Hitman", johnWick);
    Job newJob2 = systemJobs.createJReqJob("Hitman", johnWick);
    Job newJob3 = systemJobs.createJReqJob("Russian Demon", notJohn);

    johnWick.postJob(newJob, systemJobs);
    johnWick.postJob(newJob2, systemJobs);
    notJohn.postJob(newJob3, systemJobs);

    assert systemJobs.size() == 3;
    assert systemJobs.postedBy(johnWick).size() == 2;
    assert systemJobs.postedBy(notJohn).size() == 1;
  }
}
