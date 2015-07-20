package object_calisthenics.job;

import object_calisthenics.employer.Employer;

public class JobDescription
{
  private JobTitle jobTitle;
  private Employer employer;

  public JobDescription(JobTitle jobTitle, Employer employer)
  {
    this.jobTitle = jobTitle;
    this.employer = employer;
  }

  public boolean postedBy(Employer poster)
  {
    return employer.equals(poster);
  }
}
