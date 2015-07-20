package object_calisthenics.resume;

import object_calisthenics.jobseeker.Jobseeker;

public class NullResume implements Resume
{
  public NullResume() {}

  public boolean exists()
  {
    return false;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return false;
  }
}
