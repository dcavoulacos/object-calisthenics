package object_calisthenics.jobapplication;


public class ApplicationDetails
{
  private Candidate         candidate;
  private ApplicationStatus status;

  public ApplicationDetails(Candidate candidate, ApplicationStatus status) {
    this.candidate = candidate;
    this.status     = status;
  }
}
