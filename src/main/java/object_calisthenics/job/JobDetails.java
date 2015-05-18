package object_calisthenics.job;

public class JobDetails
{
  private JobType     type;
  private JobPostDate postDate;

  public JobDetails(JobType type) {
    this.type = type;
    this.postDate = new JobPostDate();
  }

  public boolean isJReq() { return type.equals(JobType.JReq); }
  public boolean isATS() { return type.equals(JobType.ATS); }
}
