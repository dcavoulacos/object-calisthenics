package object_calisthenics.employer;

import object_calisthenics.JobApplicationWorkflow;
import object_calisthenics.JobWorkflow;
import object_calisthenics.JobseekerWorkflow;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseekers;

public class Employer
{
  private EmployerName name;

  public Employer(EmployerName employerName)
  {
    this.name = employerName;
  }

  public Jobs postedJobs(JobWorkflow jobWorkflow)
  {
    return jobWorkflow.jobsPostedBy(this);
  }

  public JobApplications receivedApplications(JobApplicationWorkflow applicationWorkflow, Jobs myJobs)
  {
    return applicationWorkflow.applicationsFor(myJobs);
  }

  public Jobseekers applicants(JobseekerWorkflow jobseekerWorkflow, JobApplications applications)
  {
    return jobseekerWorkflow.applicantsFor(applications);
  }
}