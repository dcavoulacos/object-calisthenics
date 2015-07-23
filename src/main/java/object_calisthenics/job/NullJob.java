package object_calisthenics.job;

import java.util.Date;

import object_calisthenics.employer.Employer;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.FailedApplication;
import object_calisthenics.jobapplication.JobApplication;

public class NullJob implements Job
{
  public boolean postedBy(Employer employer)
  {
    return false;
  }

  public JobApplication applyWithoutResume(Candidate candidate)
  {
    return new FailedApplication(candidate, this);
  }

  public JobApplication applyWithoutResume(Candidate candidate, Date date)
  {
    return  new FailedApplication(candidate, this, date);
  }

  public Job forEmployer(Employer employer)
  {
    return this;
  }
}
