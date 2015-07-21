package object_calisthenics.resume;

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

  public Resume forJobseeker(Jobseeker jobseeker)
  {
    return this;
  }

  public boolean belongsTo(Jobseeker jobseeker) { return false; }
}
