package object_calisthenics;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.jobseeker.JobseekerName;
import object_calisthenics.jobseeker.Jobseekers;
import object_calisthenics.system.SystemJobseekers;

public class JobseekerWorkflow
{
  private SystemJobseekers systemJobseekers;

  public JobseekerWorkflow()
  {
    systemJobseekers = new SystemJobseekers();
  }

  public Jobseeker createJobseeker(String name)
  {
    Jobseeker jobseeker = new Jobseeker(new JobseekerName(name));
    return systemJobseekers.addNew(jobseeker);
  }

  public Jobseekers applicantsFor(JobApplications jobApplications)
  {
    return systemJobseekers.applicantsFor(jobApplications);
  }

  public Jobseekers applicantsFor(Job job)
  {
    return systemJobseekers.withApplicationsSubmittedFor(job);
  }

  public int totalJobseekers()
  {
    return systemJobseekers.size();
  }
}
