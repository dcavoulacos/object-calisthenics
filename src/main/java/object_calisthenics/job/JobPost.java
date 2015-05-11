package object_calisthenics.job;

public class JobPost
{
  private JobDescription jobDescription;
  private JobDetails     postDetails;

  public JobPost(JobDescription jobDescription,
                 JobDetails postDetails) {
    this.jobDescription = jobDescription;
    this.postDetails    = postDetails;
  }
}
