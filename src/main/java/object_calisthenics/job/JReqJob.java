package object_calisthenics.job;

import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.Resume;
import object_calisthenics.system.SystemJobApplications;

public class JReqJob extends Job
{
  public JReqJob(JobDescription jobDescription) {
    super(jobDescription);
  }

  @Override
  public void addNewApplication(Jobseeker applicant, Resume resume, SystemJobApplications destination)
  {
    destination.createNewApplication(this, applicant, resume);
  }
}

