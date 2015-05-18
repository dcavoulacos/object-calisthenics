package object_calisthenics.jobapplication;

public class ApplicationStatus
{
  private ApplicationDate     applicationDate;
  private ApplicationSuccess  success;

  public ApplicationStatus(ApplicationSuccess success) {
    this.applicationDate = new ApplicationDate();
    this.success         = success;
  }
}
