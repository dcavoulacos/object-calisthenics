package object_calisthenics.jobseeker;

public class Jobseeker
{
  private JobseekerName       name;
  private JobseekerResources  resources;

  public Jobseeker(JobseekerName name) {
    this.name       = name;
    this.resources  = new JobseekerResources();
  }
}
