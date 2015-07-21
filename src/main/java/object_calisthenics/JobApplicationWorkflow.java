package object_calisthenics;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.Candidate;
import object_calisthenics.jobapplication.FailedApplication;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobapplication.SuccessfulApplication;
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
    JobApplication application =  buildApplication(resume.forJobseeker(jobseeker),
                                                   jobseeker,
                                                   job);
    return systemJobApplications.addNew(application);

//    Candidate candidate = new Candidate(jobseeker, resume);
//    JobApplication application;
//    if (resume.belongsTo(jobseeker))
//    {
//      application = new SuccessfulApplication(candidate, job);
//    }
//    else
//    {
//      application = new FailedApplication(candidate, job);
//    }
//      return systemJobApplications.addNew(application);
  }

  private JobApplication buildApplication(Resume resume, Jobseeker jobseeker, Job job)
  {
    Candidate candidate = new Candidate(jobseeker, resume);
    return resume.buildApplicationFor(candidate, job);
  }

  public JobApplications applicationsBy(Jobseeker jobseeker)
  {
    return systemJobApplications.applicationsBy(jobseeker);
  }

  public JobApplications successfulApplicationsBy(Jobseeker jobseeker)
  {
    return applicationsBy(jobseeker).successes();
  }

  public int totalApplications()
  {
    return systemJobApplications.size();
  }
}
