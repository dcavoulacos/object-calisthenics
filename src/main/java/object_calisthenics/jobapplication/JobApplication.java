package object_calisthenics.jobapplication;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.jobseeker.Jobseeker;

public interface JobApplication
{
  boolean belongsTo(Jobseeker jobseeker);

  boolean isForJob(Job job);

  boolean wasSuccessful();

  boolean submittedOn(Date date);
}
