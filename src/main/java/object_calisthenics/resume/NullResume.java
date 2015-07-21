package object_calisthenics.resume;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobseeker.Jobseeker;

public class NullResume implements Resume
{
  public JobApplication buildApplicationFor(Candidate candidate, Job job)
  {
    return job.applyWithoutResume(candidate);
  }

  public Resume forJobseeker(Jobseeker jobseeker)
  {
    return this;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return false;
  }
}
