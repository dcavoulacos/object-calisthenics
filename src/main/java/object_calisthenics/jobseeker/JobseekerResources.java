package object_calisthenics.jobseeker;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.resume.Resumes;

public class JobseekerResources
{
  private Resumes       resumes;
  private Jobs          savedJobs;

  public JobseekerResources()
  {
    this.resumes   = new Resumes();
    this.savedJobs = new Jobs();
  }

  public void saveJob(Job job)
  {
    savedJobs = savedJobs.addNew(job);
  }

  public int numberOfSavedJobs()
  {
    return savedJobs.size();
  }
}
