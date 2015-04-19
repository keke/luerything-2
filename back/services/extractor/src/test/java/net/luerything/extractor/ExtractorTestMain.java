package net.luerything.extractor;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;

/**
 * @author keke
 */
public class ExtractorTestMain {

  public static void main(String[] args) throws IOException, TikaException {
//    TikaConfig config = TikaConfig.getDefaultConfig();
    File file = new File("./src/test/resources/local_data/test.pdf");
    Tika tika = new Tika();
//    InputStream is = ExtractorMain.class.getResourceAsStream("./src/test/resources/local_data/test.pdf");


    Metadata metadata = new Metadata();

    Reader reaer = tika.parse(new FileInputStream(file), metadata);
//    System.out.println("Content is " + type);
    System.out.println("Metadata is " + metadata);

//    PDDocument doc = PDDocument.load(file);
//    PDDocumentInformation info = doc.getDocumentInformation();
//    Set<String> keys = info.getMetadataKeys();
//    for(String key : keys){
//      System.out.println(key+"= " + info.getCustomMetadataValue(key));
//    }
//    PDMetadata md = doc.getDocumentCatalog().getMetadata();
//
//    System.out.println(md.get);
  }
}
