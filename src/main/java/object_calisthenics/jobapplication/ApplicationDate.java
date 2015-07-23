package object_calisthenics.jobapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationDate
{
  private final Date applicationDate;
  private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  public ApplicationDate()
  {
    applicationDate = new Date();
  }

  public ApplicationDate(Date date)
  {
    applicationDate = date;
  }

  public boolean is(Date date)
  {
    return dateFormat.format(applicationDate).equals(dateFormat.format(date));
  }
}
