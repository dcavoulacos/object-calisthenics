package object_calisthenics.employer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Employers implements Iterable<Employer>
{
  private static Collection<Employer> employers = new ArrayList<Employer>();

  public Employers() {}

  public Employers(Collection<Employer> newEmployers)
  {
    employers = newEmployers;
  }

  @Override
  public Iterator<Employer> iterator() {
    return employers.iterator();
  }

  public Employer createEmployerNamed(String employerName) {
    EmployerName name = new EmployerName(employerName);
    Employer employer = new Employer((name));
    employers.add(employer);
    return employer;
  }

  public int size() {
    return employers.size();
  }
}
