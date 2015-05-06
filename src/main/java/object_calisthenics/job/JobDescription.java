package object_calisthenics.job;

public class JobDescription
{
  private JobTitle jobTitle;
  private JobType  jobType;

  public JobDescription(JobTitle jobTitle, JobType jobType) {
    this.jobTitle  = jobTitle;
    this.jobType   = jobType;
  }
}
