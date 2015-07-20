package object_calisthenics.resume;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Resumes
{
  private final Collection<Resume> resumes;

  public Resumes()
  {
    resumes = Collections.emptySet();
  }

  public Resumes(Collection<Resume> newResumes)
  {
    resumes = newResumes;
  }

  public Resumes addNew(Resume newResume)
  {
    Set<Resume> existingResumes = new HashSet<>(resumes);
    existingResumes.add(newResume);
    return new Resumes(existingResumes);
  }
}
