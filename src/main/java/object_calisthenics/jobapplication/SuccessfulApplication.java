package object_calisthenics.jobapplication;

import object_calisthenics.job.Job;
import object_calisthenics.jobseeker.Jobseeker;

public class SuccessfulApplication implements JobApplication
{
  private final Candidate          candidate;
  private final ApplicationDetails details;

  public SuccessfulApplication(Candidate candidate, Job job)
  {
    this.candidate = candidate;
    this.details   = new ApplicationDetails(job);
  }

  public boolean wasSuccessful()
  {
    return true;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return candidate.is(jobseeker);
  }
}
