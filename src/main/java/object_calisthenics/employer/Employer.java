package object_calisthenics.employer;

import object_calisthenics.job.*;

public class Employer
{
  private EmployerName name;
  private EmployerJobs jobListings;

  public Employer(EmployerName employerName) {
    this.name         = employerName;
    this.jobListings  = new EmployerJobs();
  }

  public Job postJReqJobTitled(String jobTitle) {
    JobTitle title = new JobTitle(jobTitle);
    Job newJob = Jobs.postJob(title, this, JobType.JReq);
    jobListings.listNewJob(newJob);
    return newJob;
  }

  public Job postATSJobTitled(String jobTitle) {
    JobTitle title = new JobTitle(jobTitle);
    Job newJob = Jobs.postJob(title, this, JobType.ATS);
    jobListings.listNewJob(newJob);
    return newJob;
  }

  public boolean hasListedJob(Job job) { return jobListings.includes(job); }
}
