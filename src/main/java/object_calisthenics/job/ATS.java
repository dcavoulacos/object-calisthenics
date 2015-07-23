package object_calisthenics.job;

import java.util.Date;

import object_calisthenics.employer.Employer;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.SuccessfulApplication;

public class ATS implements Job
{
  private final JobDescription description;
  private final JobPostDate    postDate;

  public ATS(JobDescription jobDescription)
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
    return new SuccessfulApplication(candidate, this);
  }

  public JobApplication applyWithoutResume(Candidate candidate, Date date)
  {
    return new SuccessfulApplication(candidate, this, date);
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
