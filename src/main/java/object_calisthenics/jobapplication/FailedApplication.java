package object_calisthenics.jobapplication;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.jobseeker.Jobseeker;

public class FailedApplication implements JobApplication
{
  private final Candidate          candidate;
  private final ApplicationDetails details;

  public FailedApplication(Candidate candidate, Job job)
  {
    this.candidate = candidate ;
    this.details   = new ApplicationDetails(job);
  }

  public FailedApplication(Candidate candidate, Job job, Date date)
  {
    this.candidate = candidate;
    details        = new ApplicationDetails(job, date);
  }

  public boolean wasSuccessful()
  {
    return false;
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
