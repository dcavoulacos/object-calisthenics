package object_calisthenics.job;

import object_calisthenics.employer.Employer;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;

public interface Job
{
  boolean postedBy(Employer employer);

  JobApplication applyWithoutResume(Candidate candidate);
}
