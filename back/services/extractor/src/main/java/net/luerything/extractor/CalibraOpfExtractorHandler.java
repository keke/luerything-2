package net.luerything.extractor;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by keke on 4/19/15.
 */
public class CalibraOpfExtractorHandler extends ContentHandlerDecorator {
  private Metadata metadata;


  public CalibraOpfExtractorHandler(Metadata metadata) {
    super(new DefaultHandler());
    this.metadata = metadata;
  }

  @Override
  public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {
    System.out.println("start : " + uri + ":" + localName + ":" + name);
    super.startElement(uri, localName, name, atts);

  }

  @Override
  public void endElement(String uri, String localName, String name) throws SAXException {
    System.out.println("end : " + uri + ":" + localName + ":" + name);
    super.endElement(uri, localName, name);

  }
}
