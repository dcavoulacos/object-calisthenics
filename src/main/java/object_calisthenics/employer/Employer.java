package object_calisthenics.employer;

import java.util.Date;

import object_calisthenics.JobApplicationWorkflow;
import object_calisthenics.JobseekerWorkflow;
import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseekers;

public class Employer
{
  private EmployerName name;
  private Jobs         jobPosts;

  public Employer(EmployerName employerName)
  {
    name     = employerName;
    jobPosts = new Jobs();
  }

  public void postJob(Job newJob)
  {
    jobPosts = jobPosts.addNew(newJob);
  }

  public Jobs postedJobs()
  {
    //todo: can't have a getter! find another way to do this - query over jobs?
    return jobPosts;
  }

  public JobApplications receivedApplications(JobApplicationWorkflow applicationWorkflow)
  {
    return applicationWorkflow.applicationsFor(jobPosts);
  }

  public Jobseekers applicants(JobseekerWorkflow jobseekerWorkflow)
  {
    return jobseekerWorkflow.jobseekersWithApplicationsFor(jobPosts);
  }

  public JobApplications applicationsFor(Job job, JobApplicationWorkflow applicationWorkflow)
  {
      return applicationWorkflow.applicationsFor(job);
//    return jobseekerWorkflow.jobseekersWithApplicationsFor(job.forEmployer(this));
  }

  public void forDate(Date date)
  {
//    return jobseekerWorkflow.jobseekersWithApplicationsSubmitted(date);
  }

  public void forJobAndDate(Job job, Date date)
  {
//    return jobseekerWorkflow.jobseekersWithApplicationsFor(job).forDate(date);
  }
}