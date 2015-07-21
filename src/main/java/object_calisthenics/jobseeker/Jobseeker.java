package object_calisthenics.jobseeker;

import object_calisthenics.job.Job;
import object_calisthenics.job.Jobs;
import object_calisthenics.jobapplication.JobApplication;
import object_calisthenics.resume.Resume;

public class Jobseeker
{
  private JobseekerName name;
  private Jobs          savedJobs;

  public Jobseeker(JobseekerName jobseekerName)
  {
    name       = jobseekerName;
    savedJobs  = new Jobs();
  }

  public void saveJob(Job job)
  {
    savedJobs = savedJobs.addNew(job);
  }

  public int numberOfSavedJobs()
  {
    return savedJobs.size();
  }

//  public boolean jobseekerDoesNotOwn(Resume resume)
//  {
//    return resume.belongsTo(this);
//  }

//  public JobApplication applyToJobWithResume(Job job, Resume resume)
//  {
//    if (jobseekerDoesNotOwn(resume))
//    {
//      resume = new InvalidResume();
//    }
//    return job.applyWithResume(this, resume);
//  }

//  public JobApplicationBuilder startNewApplication()
//  {
//    return new JobApplicationBuilder(this);
//  }

//  public Resume addResume(Resume resume)
//  {
//    resources.addResume(resume);
//    return resume;
//  }
//

//  public boolean hasSaved(Job job)
//  {
//    return resources.hasSaved(job);
//  }
//
//  public void applyTo(Job job, SystemJobApplications destination)
//  {
//    this.applyTo(job, new NullResume(), destination);
//  }
//
//  public void applyTo(Job job, Resume resume, SystemJobApplications destination)
//  {
////    job.applyTo(this, resume, destination);
//  }
}
