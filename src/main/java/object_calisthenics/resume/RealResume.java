package object_calisthenics.resume;

public class RealResume extends Resume
{
  private ResumeDetails   details;
  private ResumeJobseeker resumeJobseeker;

  public RealResume(ResumeDetails details, ResumeJobseeker resumeJobseeker) {
    this.details          = details;
    this.resumeJobseeker  = resumeJobseeker;
  }
}
