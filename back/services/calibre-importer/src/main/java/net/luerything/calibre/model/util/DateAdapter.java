package net.luerything.calibre.model.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by keke on 4/20/15.
 */
public class DateAdapter extends XmlAdapter<String, Date> {
  //2014-12-23T16:23:02+00:00
  private static SimpleDateFormat FMT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

  @Override
  public Date unmarshal(String v) throws Exception {
    return FMT.parse(v);
  }

  @Override
  public String marshal(Date v) throws Exception {
    return FMT.format(v);
  }
}
