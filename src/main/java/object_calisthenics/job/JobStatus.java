package object_calisthenics.job;

import object_calisthenics.jobapplication.JobApplications;

public class JobStatus
{
  private final JobApplications applications;
  private       PositionStatus  positionStatus;

  public JobStatus()
  {
    this.applications     = new JobApplications();
    this.positionStatus   = new PositionStatus();
  }
}
