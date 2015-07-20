package object_calisthenics.resume;

import object_calisthenics.jobseeker.Jobseeker;

public interface Resume
{
  boolean exists();

  boolean belongsTo(Jobseeker jobseeker);
}
