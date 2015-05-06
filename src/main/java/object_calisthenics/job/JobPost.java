package object_calisthenics.job;

public class JobPost
{
  private JobDescription jobDescription;
  private JobPostDetails postDetails;

  public JobPost(JobDescription jobDescription, JobPostDetails postDetails) {
    this.jobDescription = jobDescription;
    this.postDetails    = postDetails;
  }
}
