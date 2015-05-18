package object_calisthenics.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import object_calisthenics.employer.Employer;

public class Jobs
{
  private final Collection<Job> jobs;

  public Jobs() { jobs = Collections.emptyList(); }
  public Jobs(Collection<Job> newJobs) { jobs = newJobs; }

  public Jobs addJob(Job newJob) {
    List<Job> existingJobs = new ArrayList<>(jobs);
    existingJobs.add(newJob);
    return new Jobs(existingJobs);
  }

  public Jobs postedBy(Employer employer) {
    List<Job> allJobs = new ArrayList<>(jobs);
    allJobs.removeIf(j -> !j.postedBy(employer));
    return new Jobs(allJobs);
  }

  public int size() { return jobs.size(); }
}
