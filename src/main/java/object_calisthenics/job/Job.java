package object_calisthenics.job;

import object_calisthenics.employer.Employer;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.Resume;
import object_calisthenics.system.SystemJobApplications;

public abstract class Job
{
  private JobDescription jobDescription;
  private JobPostDate    postDate;

  public Job(JobDescription jobDescription)
  {
    this.jobDescription = jobDescription;
    this.postDate        = new JobPostDate();
  }

  public boolean postedBy(Employer employer) {
    return jobDescription.postedBy(employer);
  }

  public abstract void addNewApplication(Jobseeker candidate,
                                         Resume resume,
                                         SystemJobApplications destination);
}
