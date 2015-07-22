package object_calisthenics.jobapplication;

import object_calisthenics.job.Job;
import object_calisthenics.jobseeker.Jobseeker;

public interface JobApplication
{
  boolean belongsTo(Jobseeker jobseeker);

  boolean isForJob(Job job);

  boolean wasSuccessful();
}
