package object_calisthenics.job;

import object_calisthenics.employer.Employer;

public class Job
{
  private JobDescription jobDescription;
  private JobPostDate    postDate;

  public Job(JobDescription jobDescription)
  {
    this.jobDescription = jobDescription;
    this.postDate        = new JobPostDate();
  }

  public boolean postedBy(Employer employer)
  {
    return jobDescription.postedBy(employer);
  }
}
