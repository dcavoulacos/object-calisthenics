package object_calisthenics.resume;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobseeker.Jobseeker;

public interface Resume
{
  Resume forJobseeker(Jobseeker jobseeker);

  JobApplication buildApplicationFor(Candidate candidate, Job job);

  boolean belongsTo(Jobseeker jobseeker);

  default boolean doesNotBelongTo(Jobseeker jobseeker)
  {
    return !belongsTo(jobseeker);
  }
}
