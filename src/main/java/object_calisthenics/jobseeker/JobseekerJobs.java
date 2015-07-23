package object_calisthenics.jobseeker;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.JobApplications;

public class JobseekerJobs
{
  private JobApplications applications;
  private Jobs            savedJobs;

  public JobseekerJobs()
  {
    this.applications = new JobApplications();
    this.savedJobs    = new Jobs();
  }

  public void addNewSavedJob(Job job)
  {
    savedJobs = savedJobs.addNew(job);
  }

  public void addNewApplication(JobApplication application)
  {
    applications = applications.addNew(application);
  }

  public int numberOfSavedJobs()
  {
    return savedJobs.size();
  }

  public int numberOfApplications()
  {
    return applications.size();
  }

  public int numberOfSuccesses()
  {
    return applications.successes().size();
  }

  public int numberOfFailures()
  {
    return numberOfApplications() - numberOfSuccesses();
  }

  public boolean hasApplicationFor(Job job)
  {
    return applications.forJob(job).size() != 0;
  }

  public boolean hasApplicationsFrom(Date date)
  {
    return applications.submittedOn(date).size() != 0;
  }

  public boolean hasApplicationForJobOnDate(Job job, Date date)
  {
    return applications.forJob(job).submittedOn(date).size() != 0;
  }
}
