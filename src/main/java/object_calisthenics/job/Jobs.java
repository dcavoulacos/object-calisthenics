package object_calisthenics.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import object_calisthenics.employer.Employer;

public class Jobs
{
  private final Collection<Job> jobs;

  public Jobs()
  {
    jobs = Collections.emptyList();
  }

  public Jobs(Collection<Job> newJobs)
  {
    jobs = newJobs;
  }

  public Jobs addNew(Job newJob)
  {
    List<Job> existingJobs = new ArrayList<>(jobs);
    existingJobs.add(newJob);
    return new Jobs(existingJobs);
  }

  public Jobs postedBy(Employer employer) {
    List<Job> selectJobs = jobs.stream().filter(j -> j.postedBy(employer)).collect(
            Collectors.toList());
    return new Jobs(selectJobs);
  }

  public List<Job> toList()
  {
    return new ArrayList<>(jobs);
  }

  public int size()
  {
    return jobs.size();
  }
}
