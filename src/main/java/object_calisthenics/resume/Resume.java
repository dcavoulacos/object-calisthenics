package object_calisthenics.resume;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.ApplicationSuccess;

public abstract class Resume
{
  public abstract boolean exists();

  public abstract ApplicationSuccess canBeUsedForJReq();
}
