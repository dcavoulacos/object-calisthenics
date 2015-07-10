package object_calisthenics.system;

import object_calisthenics.employer.Employer;
import object_calisthenics.job.*;

public class SystemJobs
{
  private Jobs systemJobs;
  public SystemJobs() {
    this.systemJobs = new Jobs();
  }

  public void postNewJob(Job newJob) {
    systemJobs = systemJobs.addJob(newJob);
  }

  public int size() {
    return systemJobs.size();
  }

  public Jobs postedBy(Employer employer) {
    return systemJobs.postedBy(employer);
  }

  public JReqJob createJReqJob(String jobTitle, Employer employer) {
    JobDescription description = new JobDescription(new JobTitle(jobTitle), employer);
    return new JReqJob(description);
  }

  public ATSJob createATSJob(String jobTitle, Employer employer) {
    JobDescription description = new JobDescription(new JobTitle(jobTitle), employer);
    return new ATSJob(description);
  }
}