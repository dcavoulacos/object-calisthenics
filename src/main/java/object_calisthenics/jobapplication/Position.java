package object_calisthenics.jobapplication;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.Job;

public class Position
{
  private Employer  employer;
  private Job       job;

  public Position(Employer employer, Job job) {
    this.employer = employer;
    this.job      = job;
  }
}
