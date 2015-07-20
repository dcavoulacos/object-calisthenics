package object_calisthenics.system;

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

  public JobApplication addNew(JobApplication application)
  {
    systemApplications = systemApplications.addNew(application);
    return application;
  }

  public JobApplications applicationsBy(Jobseeker jobseeker)
  {
    return systemApplications.applicationsBy(jobseeker);
  }

//
//  public void createNewApplication(Job job, Jobseeker jobseeker, Resume resume)
//  {
//    Candidate candidate = new Candidate(jobseeker, resume);
//    ApplicationDetails details = new ApplicationDetails(candidate);
//    systemApplications = systemApplications.addNew(new JobApplication(job, details));
//  }

  public int size()
  {
    return systemApplications.size();
  }
}
