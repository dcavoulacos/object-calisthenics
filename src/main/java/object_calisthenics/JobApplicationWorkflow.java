package object_calisthenics;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.NullResume;
import object_calisthenics.resume.Resume;
import object_calisthenics.system.SystemJobApplications;

public class JobApplicationWorkflow
{
  private SystemJobApplications systemJobApplications;

  public JobApplicationWorkflow()
  {
    systemJobApplications = new SystemJobApplications();
  }

  public JobApplication createApplicationFor(Job job, Jobseeker jobseeker)
  {
    return createApplicationFor(job, jobseeker, new NullResume());
  }

  public JobApplication createApplicationFor(Job job, Jobseeker jobseeker, Resume resume)
  {
    JobApplication application = buildApplication(resume.forJobseeker(jobseeker), jobseeker, job);
    if (jobseeker.hasNotAppliedTo(job))
    {
      systemJobApplications.addNew(application, jobseeker);
    }
    return application;
  }

  public JobApplications applicationsFor(Jobs jobs)
  {
    return systemJobApplications.forJobs(jobs);
  }

  public JobApplications applicationsFor(Job job)
  {
    return systemJobApplications.forJob(job);
  }

  public int totalApplications()
  {
    return systemJobApplications.size();
  }

  private JobApplication buildApplication(Resume resume, Jobseeker jobseeker, Job job)
  {
    Candidate candidate = new Candidate(jobseeker, resume);
    return resume.buildApplicationFor(candidate, job);
  }
}
