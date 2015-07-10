package object_calisthenics.employer;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Employers
{
  private final Collection<Employer> employers;

  public Employers() {
    employers = Collections.emptyList();
  }

  public Employers(Collection<Employer> newEmployers) {
    employers = newEmployers;
  }

  public Employers addNewEmployer(Employer newEmployer) {
    List<Employer> existingEmployers = new ArrayList<>(employers);
    existingEmployers.add(newEmployer);
    return new Employers(existingEmployers);
  }

  public int size() {
    return employers.size();
  }
}
