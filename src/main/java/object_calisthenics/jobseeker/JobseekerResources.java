package object_calisthenics.jobseeker;

import object_calisthenics.resume.Resumes;

public class JobseekerResources
{
  private Resumes       resumes;
  private JobseekerJobs myJobs;

  public JobseekerResources() {
    this.resumes  = new Resumes();
    this.myJobs   = new JobseekerJobs();
  }
}
