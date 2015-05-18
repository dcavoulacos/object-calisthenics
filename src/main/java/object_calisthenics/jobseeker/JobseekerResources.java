package object_calisthenics.jobseeker;

import object_calisthenics.job.Job;
import object_calisthenics.resume.Resumes;

public class JobseekerResources
{
  private Resumes       resumes;
  private JobseekerJobs myJobs;

  public JobseekerResources() {
    this.resumes  = new Resumes();
    this.myJobs   = new JobseekerJobs();
  }

  public void saveJob(Job job) { myJobs.addNewSavedJob(job); }
  public boolean hasSaved(Job job) {return myJobs.hasSaved(job); }
}
