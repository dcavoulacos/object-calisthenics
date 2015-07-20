package object_calisthenics.resume;

import object_calisthenics.jobseeker.Jobseeker;

public class ValidResume implements Resume
{
  private ResumeName name;
  private Jobseeker  resumeJobseeker;

  public ValidResume(Jobseeker resumeJobseeker)
  {
    this.resumeJobseeker  = resumeJobseeker;
  }

  public boolean exists()
  {
    return true;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return resumeJobseeker == jobseeker;
  }
}
