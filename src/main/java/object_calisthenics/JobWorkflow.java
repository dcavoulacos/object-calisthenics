package object_calisthenics;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.ATS;
import object_calisthenics.job.JREQ;
import object_calisthenics.job.Job;
import object_calisthenics.job.JobDescription;
import object_calisthenics.job.JobTitle;
import object_calisthenics.job.Jobs;
import object_calisthenics.system.SystemJobs;

public class JobWorkflow
{
  private SystemJobs systemJobs;

  public JobWorkflow()
  {
    systemJobs = new SystemJobs();
  }

  public Job createJREQForEmployer(String jobTitle, Employer employer)
  {
    JREQ jReq = new JREQ(new JobDescription(new JobTitle(jobTitle), employer));
    return systemJobs.addNew(jReq);
  }

  public Job createATSForEmployer(String jobTitle, Employer employer)
  {
    ATS ats = new ATS(new JobDescription(new JobTitle(jobTitle), employer));
    return systemJobs.addNew(ats);
  }

  public Jobs jobsPostedBy(Employer employer)
  {
    return systemJobs.postedBy(employer);
  }

  public int totalJobs()
  {
    return systemJobs.size();
  }
}
