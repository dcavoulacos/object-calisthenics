package object_calisthenics.system;

import java.util.List;
import java.util.stream.Collectors;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.jobapplication.JobApplications;
import object_calisthenics.jobseeker.Jobseeker;
import object_calisthenics.jobseeker.Jobseekers;

public class SystemJobseekers
{
  private Jobseekers systemJobseekers;

  public SystemJobseekers()
  {
    this.systemJobseekers = new Jobseekers();
  }

  public Jobseeker addNew(Jobseeker jobseeker)
  {
    systemJobseekers = systemJobseekers.addNew(jobseeker);
    return jobseeker;
  }

  public Jobseekers withApplicationsSubmittedFor(Job job)
  {
    return systemJobseekers.appliedTo(job);
  }

  public Jobseekers applicantsFor(JobApplications jobApplications)
  {
    List<Jobseeker> applicants = jobApplications.toList().stream()
                                                         .map(this::applicantFor)
                                                         .collect(Collectors.toList());
    return new Jobseekers(applicants);
  }

  private Jobseeker applicantFor(JobApplication jobApplication)
  {
    return systemJobseekers.applicantFor(jobApplication);
  }

  public int size()
  {
    return systemJobseekers.size();
  }
}
