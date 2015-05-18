package object_calisthenics.resume;

import object_calisthenics.jobseeker.Jobseeker;

public class RealResume extends Resume
{
  private ResumeDetails details;
  private Jobseeker     resumeJobseeker;

  public RealResume(ResumeDetails details,
                    Jobseeker resumeJobseeker)
  {
    this.details = details;
    this.resumeJobseeker  = resumeJobseeker;
  }

  @Override
  public boolean exists() { return true; }
}
