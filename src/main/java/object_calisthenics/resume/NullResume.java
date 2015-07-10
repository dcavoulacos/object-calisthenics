package object_calisthenics.resume;

import object_calisthenics.jobapplication.ApplicationSuccess;

public class NullResume extends Resume
{
  public NullResume() {}

  @Override
  public boolean exists() {
    return false;
  }

  @Override
  public ApplicationSuccess canBeUsedForJReq() {
    return ApplicationSuccess.FAILURE;
  }
}
