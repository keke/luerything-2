package net.luerything.extractor;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

/**
 * Created by keke on 4/19/15.
 */
public class CalibreOpfParser extends AbstractParser {
  private static final Set<MediaType> SUPPORT_TYPE = Collections.singleton(MediaType.application("oebps-package+xml"));

  @Override
  public Set<MediaType> getSupportedTypes(ParseContext context) {
    return SUPPORT_TYPE;
  }

  @Override
  public void parse(InputStream stream, ContentHandler handler, Metadata metadata, ParseContext context) throws IOException, SAXException, TikaException {
    System.out.println("To parse :");
  }
}
