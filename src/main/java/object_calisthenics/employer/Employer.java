package object_calisthenics.employer;

public class Employer
{
  private EmployerName name;
  private EmployerJobs jobListings;

  public Employer(EmployerName employerName) {
    this.name         = employerName;
    this.jobListings  = new EmployerJobs();
  }
}
