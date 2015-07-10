package object_calisthenics.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import object_calisthenics.employer.Employer;

import static java.util.stream.Collectors.toList;

public class Jobs
{
  private final Collection<Job> jobs;

  public Jobs() {
    jobs = Collections.emptyList();
  }

  public Jobs(Collection<Job> newJobs) {
    jobs = newJobs;
  }

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

//  public Jobs postedBy(Employer employer) {
//    List<Job> selectJobs = jobs.stream().filter(j -> j.postedBy(employer)).collect(toList());
//    return new Jobs(selectJobs);
//  }

  public boolean include(Job job) {
    return jobs.contains(job);
  }

  public int size() {
    return jobs.size();
  }
}
