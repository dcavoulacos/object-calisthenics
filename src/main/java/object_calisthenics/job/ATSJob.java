package object_calisthenics.job;

import object_calisthenics.jobapplication.*;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.Resume;
import object_calisthenics.system.SystemJobApplications;

public class ATSJob extends Job
{
  public ATSJob(JobDescription jobDescription) {
    super(jobDescription);
  }

  @Override
  public void addNewApplication(Jobseeker candidate, Resume resume, SystemJobApplications destination) {
  }
}
