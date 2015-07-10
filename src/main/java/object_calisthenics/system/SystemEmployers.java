package object_calisthenics.system;

import object_calisthenics.employer.*;

public class SystemEmployers
{
  private Employers systemEmployers;

  public SystemEmployers() {
    this.systemEmployers = new Employers();
  }

  public Employer createEmployer(String name) {
    Employer employer = new Employer(new EmployerName(name));
    systemEmployers = systemEmployers.addNewEmployer(employer);
    return employer;
  }

  public int size() {
    return systemEmployers.size();
  }
}
