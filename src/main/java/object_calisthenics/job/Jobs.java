package object_calisthenics.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import object_calisthenics.employer.Employer;

public class Jobs implements Iterable<Job>
{
  private static Collection<Job> jobs = new ArrayList<Job>();

  public Jobs() {}

  public Jobs(Collection<Job> newJobs)
  {
    jobs = newJobs;
  }

  @Override
  public Iterator<Job> iterator() {
    return jobs.iterator();
  }

  public static Job postJob(JobTitle title, Employer employer, JobType type) {
    JobDescription description = new JobDescription(title, type);
    JobDetails details = new JobDetails(employer);
    Job newJob = Job.createNewJob(description, details);
    jobs.add(newJob);
    return newJob;
  }

  public int size() {
    return jobs.size();
  }
}
