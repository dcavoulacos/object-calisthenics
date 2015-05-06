package object_calisthenics.resume;

public class Resume
{
  private ResumeDetails   details;
  private ResumeJobseeker resumeJobseeker;

  public Resume(ResumeDetails details, ResumeJobseeker resumeJobseeker) {
    this.details          = details;
    this.resumeJobseeker  = resumeJobseeker;
  }
}
