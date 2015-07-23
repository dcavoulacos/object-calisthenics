package object_calisthenics.jobapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import object_calisthenics.job.Job;
import object_calisthenics.jobseeker.Jobseeker;

public class JobApplications
{
  private final Collection<JobApplication> jobApplications;

  public JobApplications()
  {
    this.jobApplications = Collections.emptySet();
  }

  public JobApplications(Collection<JobApplication> newApplications)
  {
    jobApplications = newApplications;
  }

  public JobApplications addNew(JobApplication newApplication)
  {
    Set<JobApplication> applications = new HashSet<>(jobApplications);
    applications.add(newApplication);
    return new JobApplications(applications);
  }

  public JobApplications forJob(Job job)
  {
    return filterBy(a -> a.isForJob(job));
  }

  public JobApplications submittedOn(Date date)
  {
    return filterBy(a -> a.submittedOn(date));
  }

  public JobApplications submittedBy(Jobseeker jobseeker)
  {
    return filterBy(a -> a.belongsTo(jobseeker));
  }

  public JobApplications successes()
  {
    return filterBy(JobApplication::wasSuccessful);
  }

  public JobApplications failures()
  {
    return filterBy(a -> !a.wasSuccessful());
  }

  private JobApplications filterBy(Predicate<JobApplication> predicate)
  {
    List<JobApplication> filteredApplications = jobApplications.stream()
                                                               .filter(predicate)
                                                               .collect(Collectors.toList());
    return new JobApplications(filteredApplications);
  }

  public List<JobApplication> toList()
  {
    return new ArrayList<>(jobApplications);
  }

  public int size()
  {
    return jobApplications.size();
  }
}
