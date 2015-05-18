package object_calisthenics.system;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.*;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.*;

public class SystemJobApplications
{
  private JobApplications systemApplications;
  public SystemJobApplications() { this.systemApplications = new JobApplications(); }

  public JobApplication createApplication(Job job, Jobseeker applicant) {
    Candidate candidate = new Candidate(applicant, new NullResume());
    ApplicationSuccess success = getSuccess(job, new NullResume());
    ApplicationDetails details = new ApplicationDetails(candidate, new ApplicationStatus(success));
    return new JobApplication(job, details);
  }

  public ApplicationSuccess getSuccess (Job job, Resume resume) {
    if (job.isJReq() && !resume.exists()) { return ApplicationSuccess.FAILURE; }
    return ApplicationSuccess.SUCCESS;
  }
}
