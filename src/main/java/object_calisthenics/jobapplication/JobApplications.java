package object_calisthenics.jobapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import object_calisthenics.jobseeker.Jobseeker;

import static java.util.stream.Collectors.toList;

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
    List<JobApplication> applications = new ArrayList<>(jobApplications);
    applications.add(newApplication);
    return new JobApplications(applications);
  }

  public JobApplications applicationsBy(Jobseeker jobseeker)
  {
    List<JobApplication> applications = jobApplications.stream().filter(a -> a.belongsTo(jobseeker)).collect(toList());
    return new JobApplications(applications);
  }

  public JobApplications successes()
  {
    List<JobApplication> successes = jobApplications.stream().filter(a -> a.wasSuccessful()).collect(toList());
    return new JobApplications(successes);
  }

  public int size()
  {
    return jobApplications.size();
  }
}
