package object_calisthenics.system;

import java.util.ArrayList;
import java.util.List;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseeker;

public class SystemJobApplications
{
  private JobApplications systemApplications;

  public SystemJobApplications()
  {
    this.systemApplications = new JobApplications();
  }

  public JobApplication addNew(JobApplication application, Jobseeker jobseeker)
  {
    systemApplications = systemApplications.addNew(application);
    jobseeker.saveApplication(application);
    return application;
  }

  public JobApplications forJobs(Jobs jobs)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (Job job : jobs.toList())
    {
      applications.addAll(forJob(job).toList());
    }
    return new JobApplications(applications);
  }

  public JobApplications forJob(Job job)
  {
     return systemApplications.forJob(job);
  }

  public JobApplications applicationsBy(Jobseeker jobseeker)
  {
    return systemApplications.submittedBy(jobseeker);
  }

  public JobApplications successesBy(Jobseeker jobseeker)
  {
    return applicationsBy(jobseeker).successes();
  }

  public JobApplications failuresBy(Jobseeker jobseeker)
  {
    return applicationsBy(jobseeker).failures();
  }

  public int size()
  {
    return systemApplications.size();
  }
}
