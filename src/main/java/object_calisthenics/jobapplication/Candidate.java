package object_calisthenics.jobapplication;

import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.Resume;

public class Candidate
{
  private final Jobseeker jobseeker;
  private final Resume    resume;

  public Candidate(Jobseeker jobseeker, Resume resume)
  {
    this.jobseeker  = jobseeker;
    this.resume     = resume;
  }

  public boolean is(Jobseeker jobseeker)
  {
    return this.jobseeker == jobseeker;
  }
}
