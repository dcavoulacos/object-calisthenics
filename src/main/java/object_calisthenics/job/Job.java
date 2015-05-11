package object_calisthenics.job;

import object_calisthenics.jobapplication.*;

public class Job
{
  private JobPost         jobPost;
  private JobApplications applications;

  public Job(JobPost jobPost)
  {
    this.jobPost = jobPost;
    this.applications = new JobApplications();
  }

  public static Job createNewJob(JobDescription description, JobDetails details) {
    JobPost post = new JobPost(description, details);
    return new Job(post);
  }
}
