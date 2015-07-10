package object_calisthenics.system;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.*;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.resume.*;

public class SystemJobApplications
{
  private JobApplications systemApplications;
  public SystemJobApplications() {
    this.systemApplications = new JobApplications();
  }

  public void createNewApplication(Job job, Jobseeker applicant, Resume resume) {
    Candidate candidate = new Candidate(applicant, resume);
    ApplicationSuccess success = resume.canBeUsedForJReq();
    ApplicationDetails details = new ApplicationDetails(candidate, new ApplicationStatus(success));
    systemApplications = systemApplications.add(new JobApplication(job, details));
  }

  public int size() {
    return systemApplications.size();
  }
//  public ApplicationSuccess getSuccess (Job job, Resume resume) {
//    if (job.isJReq() && !resume.exists()) { return ApplicationSuccess.FAILURE; }
//    return ApplicationSuccess.SUCCESS;
//  }
}
