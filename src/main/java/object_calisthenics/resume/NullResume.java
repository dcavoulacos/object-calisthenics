package object_calisthenics.resume;

public class NullResume extends Resume
{
  public NullResume() {}

  @Override
  public boolean exists() { return false; }
}
