package object_calisthenics;

import object_calisthenics.employer.Employer;
import object_calisthenics.employer.EmployerName;
import object_calisthenics.job.Jobs;
import object_calisthenics.system.SystemEmployers;

public class EmployerWorkflow
{
  private  SystemEmployers systemEmployers;

  public EmployerWorkflow()
  {
    systemEmployers = new SystemEmployers();
  }

  public Employer createEmployer(String name)
  {
    Employer employer = new Employer(new EmployerName(name));
    return systemEmployers.addNew(employer);
  }

  public int totalEmployers()
  {
    return systemEmployers.size();
  }
}
