package object_calisthenics.job;

import object_calisthenics.employer.Employer;

public class JobPostDetails
{
  private Employer    employer;
  private JobPostDate postDate;

  public JobPostDetails(Employer employer) {
    this.employer = employer;
    this.postDate = new JobPostDate();
  }
}
