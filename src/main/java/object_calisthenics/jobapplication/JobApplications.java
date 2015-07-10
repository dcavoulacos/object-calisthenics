package object_calisthenics.jobapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JobApplications
{
  private final Collection<JobApplication> jobApplications;
  public JobApplications() {
    this.jobApplications = Collections.emptySet();
  }
  public JobApplications(Collection<JobApplication> newApplications) {
    jobApplications = newApplications;
  }

  public JobApplications add(JobApplication newApplication) {
    List<JobApplication> applications = new ArrayList<>(jobApplications);
    applications.add(newApplication);
    return new JobApplications(applications);
  }

  public int size() {
    return jobApplications.size();
  }
}
