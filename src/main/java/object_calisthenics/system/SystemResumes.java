package object_calisthenics.system;

import object_calisthenics.resume.Resume;
import object_calisthenics.resume.Resumes;

public class SystemResumes
{
  private Resumes systemResumes;

  public SystemResumes()
  {
    systemResumes = new Resumes();
  }

  public Resume addNew(Resume resume)
  {
    systemResumes.addNew(resume);
    return resume;
  }
}
