package object_calisthenics.jobseeker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import object_calisthenics.job.Job;
import object_calisthenics.jobapplication.JobApplication;

public class Jobseekers
{
  private final Collection<Jobseeker> jobseekers;

  public Jobseekers()
  {
    this.jobseekers = Collections.emptyList();
  }

  public Jobseekers(Collection<Jobseeker> newJobseekers)
  {
    jobseekers = newJobseekers;
  }

  public Jobseekers addNew(Jobseeker newJobseeker)
  {
    List<Jobseeker> existingJobseekers = new ArrayList<>(jobseekers);
    existingJobseekers.add(newJobseeker);
    return new Jobseekers(existingJobseekers);
  }

  public Jobseeker applicantFor(JobApplication jobApplication)
  {
    return jobseekers.stream().filter(jobApplication::belongsTo).findAny().get();
  }

  public Jobseekers forJob(Job job)
  {
    List<Jobseeker> applicants =  jobseekers.stream().filter(js -> js.hasAppliedTo(job)).collect(Collectors.toList());
    return new Jobseekers(applicants);
  }

  public Jobseekers forDate(Date date)
  {
    List<Jobseeker> applicants = jobseekers.stream().filter(js -> js.appliedToJobOn(date)).collect(Collectors.toList());
    return new Jobseekers(applicants);
  }

  public Jobseekers forJobAndDate(Job job, Date date)
  {
    List<Jobseeker> applicants = jobseekers.stream().filter(js -> js.hasAppliedToJobOnDate(job, date)).collect(Collectors.toList());
    return new Jobseekers(applicants);
  }

  public int size()
  {
    return jobseekers.size();
  }

  public List<Jobseeker> toList()
  {
    return new ArrayList<>(jobseekers);
  }
}
