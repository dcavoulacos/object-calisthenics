package object_calisthenics.job;

import object_calisthenics.employer.Employer;

public class Job
{
  private JobDescription jobDescription;
  private JobDetails     details;

  public Job(JobDescription jobDescription, JobDetails details)
  {
    this.jobDescription = jobDescription;
    this.details        = details;
  }

  public boolean isJReq() { return details.isJReq(); }
  public boolean postedBy(Employer employer) {
    return jobDescription.postedBy(employer);
  }
}
