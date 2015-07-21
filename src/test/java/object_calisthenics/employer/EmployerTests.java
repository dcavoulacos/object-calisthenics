package object_calisthenics.employer;

import org.junit.Test;

import object_calisthenics.EmployerWorkflow;
import object_calisthenics.JobWorkflow;

public class EmployerTests
{
  private EmployerWorkflow employerWorkflow = new EmployerWorkflow();
  private JobWorkflow      jobWorkflow      = new JobWorkflow();

  @Test
  public void canCreateEmployer()
  {
    employerWorkflow.createEmployer("John Wick");
    assert employerWorkflow.totalEmployers() == 1;
  }

  @Test
  public void canPostAJob()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    assert jobWorkflow.totalJobs() == 0;
    jobWorkflow.createJREQForEmployer("Hitman", johnWick);
    assert jobWorkflow.totalJobs() == 1;
  }

  @Test
  public void canSeePostedJobs()
  {
    Employer johnWick = employerWorkflow.createEmployer("John Wick");
    Employer notJohn = employerWorkflow.createEmployer("Baba Yaga");
    assert jobWorkflow.totalJobs() == 0;

    jobWorkflow.createJREQForEmployer("Hitman", johnWick);
    jobWorkflow.createJREQForEmployer("Assistant Hitman", johnWick);

    assert jobWorkflow.totalJobs() == 2;
    assert jobWorkflow.jobsPostedBy(johnWick).size() == 2;

    jobWorkflow.createJREQForEmployer("Russian Demon", notJohn);

    assert jobWorkflow.totalJobs() == 3;
    assert jobWorkflow.jobsPostedBy(johnWick).size() == 2;
  }
}
