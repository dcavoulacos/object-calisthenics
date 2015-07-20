package object_calisthenics.jobseeker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

  public int size()
  {
    return jobseekers.size();
  }
}
