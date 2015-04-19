package net.luerything.extractor;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by keke on 4/19/15.
 */
public class ExtractOpfMain {
  public static void main(String[] args) throws IOException, TikaException, SAXException {
    File file = new File("/Users/keke/Calibre Library/James Cryer/Pro Grunt.js (1783)/metadata.opf");
    Tika tika = new Tika();
    Metadata metadata = new Metadata();
    metadata.add(Metadata.RESOURCE_NAME_KEY, file.getName());
    String type = tika.parseToString(new FileInputStream(file),metadata);
    System.out.println(type);
  }
}
