package object_calisthenics.jobseeker;

import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplications;

public class JobseekerJobs
{
  private JobApplications appliedJobs;
  private Jobs            savedJobs;

  public JobseekerJobs() {
    this.appliedJobs  = new JobApplications();
    this.savedJobs    = new Jobs();
  }
}