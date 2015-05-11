package object_calisthenics.employer;

import org.junit.Test;

import object_calisthenics.job.Job;

public class EmployerTests
{
  @Test
  public void canCreateEmployer() {
    Employers employers = new Employers();
    employers.createEmployerNamed("John Wick");
    assert employers.size() == 1;
  }

  @Test
  public void canPostJReqJob(){
    Employers employers = new Employers();
    Employer employer = employers.createEmployerNamed("John Wick");
    Job newJReqJob = employer.postJReqJobTitled("Hitman");
    assert employer.hasListedJob(newJReqJob);
  }
}
