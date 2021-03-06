package object_calisthenics.job;

import java.util.Date;

import object_calisthenics.employer.Employer;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.FailedApplication;
import object_calisthenics.jobapplication.JobApplication;

public class JREQ implements Job
{
  private final JobDescription description;
  private final JobPostDate    postDate;

  public JREQ(JobDescription jobDescription)
  {
    description = jobDescription;
    postDate    = new JobPostDate();
  }

  public boolean postedBy(Employer employer)
  {
    return description.postedBy(employer);
  }

  public JobApplication applyWithoutResume(Candidate candidate)
  {
    return new FailedApplication(candidate, this);
  }

  public JobApplication applyWithoutResume(Candidate candidate, Date date)
  {
    return new FailedApplication(candidate, this, date);
  }

  public Job forEmployer(Employer employer)
  {
    Job job = new NullJob();
    if (postedBy(employer))
    {
      job = this;
    }
    return job;
  }
}
