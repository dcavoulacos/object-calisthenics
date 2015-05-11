package object_calisthenics.employer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import object_calisthenics.job.Job;

public class EmployerJobs implements Iterable<EmployerJob>
{
  private static Collection<EmployerJob> postedJobs = new ArrayList<EmployerJob>();

  public EmployerJobs() {}

  @Override
  public Iterator<EmployerJob> iterator()
  {
    return postedJobs.iterator();
  }

  public void listNewJob(Job newJob)
  {
    postedJobs.add(new EmployerJob(newJob));
  }
  public boolean includes(Job job) {
    return true;
  }
}
