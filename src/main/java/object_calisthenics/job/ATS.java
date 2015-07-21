package object_calisthenics.job;

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

//  public JobApplication applyWithResume(Resume resume, Jobseeker jobseeker)
//  {
//    return null;
//  }

//  public void applyTo(Jobseeker candidate,
//                      Resume resume,
//                      SystemJobApplications destination) {
//  }
}
