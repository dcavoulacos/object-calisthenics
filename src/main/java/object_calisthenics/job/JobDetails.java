package object_calisthenics.job;

import object_calisthenics.employer.Employer;

public class JobDetails
{
  private Employer    employer;
  private JobPostDate postDate;

  public JobDetails(Employer employer) {
    this.employer = employer;
    this.postDate = new JobPostDate();
  }
}
