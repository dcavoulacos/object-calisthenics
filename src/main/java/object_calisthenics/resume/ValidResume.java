package object_calisthenics.resume;

import java.util.Date;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.SuccessfulApplication;
import object_calisthenics.jobseeker.Jobseeker;

public class ValidResume implements Resume
{
  private ResumeName name;
  private final Jobseeker  resumeJobseeker;

  public ValidResume(Jobseeker resumeJobseeker)
  {
    this.resumeJobseeker  = resumeJobseeker;
  }

  public JobApplication buildApplicationFor(Candidate candidate, Job job)
  {
    return new SuccessfulApplication(candidate, job);
  }

  public JobApplication buildApplicationWithDateFor(Candidate candidate, Job job, Date date)
  {
    return new SuccessfulApplication(candidate, job, date);
  }

  public Resume forJobseeker(Jobseeker jobseeker)
  {
    Resume newResume = this;
    if (doesNotBelongTo(jobseeker))
    {
      newResume = new InvalidResume();
    }
    return newResume;
  }

  public boolean belongsTo(Jobseeker jobseeker)
  {
    return resumeJobseeker == jobseeker;
  }
}
