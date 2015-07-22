package object_calisthenics;

import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.Resume;
import object_calisthenics.resume.ValidResume;
import object_calisthenics.system.SystemResumes;

public class ResumeWorkflow
{
  private SystemResumes systemResumes;

  public ResumeWorkflow()
  {
    systemResumes = new SystemResumes();
  }

  public Resume newResumeFor(Jobseeker jobseeker)
  {
    return new ValidResume(jobseeker);
  }
}
