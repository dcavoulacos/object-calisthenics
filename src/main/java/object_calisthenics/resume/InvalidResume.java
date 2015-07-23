package object_calisthenics.resume;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.FailedApplication;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobseeker.Jobseeker;

public class InvalidResume implements Resume
{
  public InvalidResume() {}

  public JobApplication buildApplicationFor(Candidate candidate, Job job)
  {
    return new FailedApplication(candidate, job);
  }

  public JobApplication buildApplicationWithDateFor(Candidate candidate, Job job, Date date)
  {
    return new FailedApplication(candidate, job, date);
  }

  public Resume forJobseeker(Jobseeker jobseeker)
  {
    return this;
  }

  public boolean belongsTo(Jobseeker jobseeker) { return false; }
}
