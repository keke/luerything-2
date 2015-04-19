package net.luerything.extractor;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A basic ISBN extractor handler for Tika.
 *
 * @author keke
 */
public class ISBNExtractorHandler extends ContentHandlerDecorator {
  private static final Logger LOG = LoggerFactory.getLogger(ISBNExtractorHandler.class);
  private static final Pattern ISBN = Pattern.compile("(isbn|International Standard Book Number-13)(\\D)*([\\d-]+)", Pattern.CASE_INSENSITIVE);
  private static final String ISBN_ID = "dc:identifier";
  private static final int CONTEXT_LENGTH = 100;
  private final Metadata metadata;
  private final StringBuffer stringBuilder;

  public ISBNExtractorHandler(ContentHandler handler, Metadata metadata) {
    super(handler);
    this.metadata = metadata;
    this.stringBuilder = new StringBuffer();
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    try {
      final String text = new String(Arrays.copyOfRange(ch, start, start + length));
      stringBuilder.append(text);
      super.characters(ch, start, length);
    } catch (SAXException e) {
      handleException(e);
    }
  }

  @Override
  public void endDocument() throws SAXException {
    super.endDocument();
    Matcher m = ISBN.matcher(stringBuilder);
    int totalLength = stringBuilder.length();
    while (m.find()) {
      if (LOG.isDebugEnabled()) {
        int start = m.start() - CONTEXT_LENGTH;
        if (start < 0) start = 0;
        int end = m.end() + CONTEXT_LENGTH;
        if (end > totalLength) {
          end = totalLength;
        }
        char[] buf = new char[end - start];
        stringBuilder.getChars(start, end, buf, 0);
        LOG.debug("Found ISBN {}, Context:\r\n", m.group(3), new StringBuffer().append(buf).toString());
      }

      metadata.add(ISBN_ID, "urn:isbn:" + m.group(3));
    }
  }

  public ISBNExtractorHandler() {
    this(new DefaultHandler(), new Metadata());
  }

  public ISBNExtractorHandler(Metadata metadata) {
    this(new DefaultHandler(), metadata);
  }
}
