package object_calisthenics.resume;

import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseeker;

public class ResumeJobseeker
{
  private Jobseeker       jobseeker;
  private JobApplications appliedJobs;

  public ResumeJobseeker(Jobseeker jobseeker) {
    this.jobseeker    = jobseeker;
    this.appliedJobs  = new JobApplications();
  }
}
