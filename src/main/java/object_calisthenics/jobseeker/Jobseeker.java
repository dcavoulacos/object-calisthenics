package object_calisthenics.jobseeker;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.JobApplication;

public class Jobseeker
{
  private JobseekerName name;
  private JobseekerJobs trackedJobs;

  public Jobseeker(JobseekerName jobseekerName)
  {
    name        = jobseekerName;
    trackedJobs = new JobseekerJobs();
  }

  public void saveJob(Job job)
  {
    trackedJobs.addNewSavedJob(job);
  }

  public void saveApplication(JobApplication application)
  {
    trackedJobs.addNewApplication(application);
  }

  public boolean hasAppliedTo(Job job)
  {
    return trackedJobs.hasApplicationFor(job);
  }

  public boolean appliedToJobOn(Date date)
  {
    return trackedJobs.hasApplicationsFrom(date);
  }

  public boolean hasAppliedToJobOnDate(Job job, Date date)
  {
    return trackedJobs.hasApplicationForJobOnDate(job, date);
  }

  public boolean hasNotAppliedTo(Job job)
  {
    return !hasAppliedTo(job);
  }

  public int numberOfSavedJobs()
  {
    return trackedJobs.numberOfSavedJobs();
  }

  public int numberOfApplications()
  {
    return trackedJobs.numberOfApplications();
  }

  public int numberOfSuccesses()
  {
    return trackedJobs.numberOfSuccesses();
  }

  public int numberOfFailures()
  {
    return trackedJobs.numberOfFailures();
  }
}
