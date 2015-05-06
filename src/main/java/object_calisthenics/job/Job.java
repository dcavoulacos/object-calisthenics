package object_calisthenics.job;

public class Job
{
  private JobPost   jobPost;
  private JobStatus jobStatus;

  public Job(JobPost jobPost, JobStatus jobStatus) {
    this.jobPost    = jobPost;
    this.jobStatus  = jobStatus;
  }
}
