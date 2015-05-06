package object_calisthenics.jobapplication;

public class JobApplication
{
  private Position           position;
  private ApplicationDetails details;

  public JobApplication(Position position, ApplicationDetails details) {
    this.position = position;
    this.details  = details;
  }
}
