package object_calisthenics.resume;

import object_calisthenics.jobseeker.Jobseeker;

public class InvalidResume implements Resume
{
  public InvalidResume() {}

  public boolean exists()
  {
    return true;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return false;
  }
}
