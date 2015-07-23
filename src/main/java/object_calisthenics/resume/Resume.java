package object_calisthenics.resume;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobseeker.Jobseeker;

public interface Resume
{
  Resume forJobseeker(Jobseeker jobseeker);

  JobApplication buildApplicationFor(Candidate candidate, Job job);

  JobApplication buildApplicationWithDateFor(Candidate candidate, Job job, Date date);

  boolean belongsTo(Jobseeker jobseeker);

  default boolean doesNotBelongTo(Jobseeker jobseeker)
  {
    return !belongsTo(jobseeker);
  }
}
