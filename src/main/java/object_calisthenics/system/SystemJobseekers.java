package object_calisthenics.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
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

  public Jobseekers appliedOnDate(Date date)
  {
    return systemJobseekers.forDate(date);
  }

  public Jobseekers appliedToJob(Job job)
  {
    return systemJobseekers.forJob(job);
  }

  public Jobseekers appliedToJobs(Jobs jobs)
  {
    List<Jobseeker> applicants = new ArrayList<>();
    for (Job job : jobs.toList())
    {
       applicants.addAll(appliedToJob(job).toList());
    }
    return new Jobseekers(applicants.stream().distinct().collect(Collectors.toList()));
  }

  public Jobseekers appliedToJobOnDate(Job job, Date date)
  {
    return systemJobseekers.forJobAndDate(job, date);
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
