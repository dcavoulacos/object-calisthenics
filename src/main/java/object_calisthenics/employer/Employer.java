package object_calisthenics.employer;

import object_calisthenics.job.*;
import object_calisthenics.system.*;

public class Employer
{
  private EmployerName name;

  public Employer(EmployerName employerName) {
    this.name         = employerName;
  }

  public void postJob(Job newJob, SystemJobs destination) {
    destination.postNewJob(newJob);
  }
}
