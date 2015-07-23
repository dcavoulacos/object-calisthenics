package object_calisthenics.jobapplication;

import java.util.Date;

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

  public SuccessfulApplication(Candidate candidate, Job job, Date date)
  {
    this.candidate = candidate;
    this.details   = new ApplicationDetails(job, date);
  }

  public boolean wasSuccessful()
  {
    return true;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return candidate.is(jobseeker);
  }

  public boolean isForJob(Job job)
  {
    return details.isForJob(job);
  }

  public boolean submittedOn(Date date)
  {
    return details.submittedOn(date);
  }
}
