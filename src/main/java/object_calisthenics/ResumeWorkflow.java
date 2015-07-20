package object_calisthenics;

import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.InvalidResume;
import object_calisthenics.resume.Resume;
import object_calisthenics.system.SystemResumes;

public class ResumeWorkflow
{
  private SystemResumes systemResumes;

  public ResumeWorkflow()
  {
    systemResumes = new SystemResumes();
  }

  public Resume resumeForApplication(Resume resume, Jobseeker jobseeker)
  {
    //todo: is ternary operator cheating here? check this
    return resume.belongsTo(jobseeker) ? resume : new InvalidResume();
  }
}
