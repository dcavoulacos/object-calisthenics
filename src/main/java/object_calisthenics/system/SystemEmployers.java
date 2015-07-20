package object_calisthenics.system;

import object_calisthenics.employer.Employer;
import object_calisthenics.employer.Employers;

public class SystemEmployers
{
  private Employers systemEmployers;

  public SystemEmployers()
  {
    this.systemEmployers = new Employers();
  }

  public Employer addNew(Employer employer)
  {
    systemEmployers = systemEmployers.addNew(employer);
    return employer;
  }

  public int size()
  {
    return systemEmployers.size();
  }
}
