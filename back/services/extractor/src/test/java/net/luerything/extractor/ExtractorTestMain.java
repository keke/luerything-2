package net.luerything.extractor;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author keke
 */
public class ExtractorTestMain {
  private static final Set<String> SUPPORT_TYPES = new HashSet<>(Arrays.asList("pdf", "epub+zip"));

  public static void main(String[] args) throws IOException, TikaException, SAXException {
    String root = "/Users/keke/Calibre Library";
    AutoDetectParser parser = new AutoDetectParser();
    Tika tika = new Tika();
    Files.walkFileTree(FileSystems.getDefault().getPath(root), EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        System.out.println("Visit path : " + file);
        if (attrs.isRegularFile() && !file.toFile().isHidden()) {
          try {
//            String type = tika.detect(file.toFile());

            MediaType type = MediaType.parse(tika.detect(file.toFile()));
            if (type.getType().equals("application") && SUPPORT_TYPES.contains(type.getSubtype())) {

              Metadata metadata = new Metadata();
              parser.parse(new FileInputStream(file.toFile()), new TeeContentHandler(new ISBNExtractorHandler(metadata)), metadata, new ParseContext());
//    System.out.println("Content is " + type);
              if (metadata.getValues("dc:identifier").length == 0) {
                System.out.println("Visit path : " + file);
                System.out.println("Metadata is " + metadata);
              }
            }
          } catch (IOException e) {
            System.out.println("Can not access: " + file);
          } catch (SAXException e) {
            e.printStackTrace();
          } catch (TikaException e) {
            e.printStackTrace();
          }
        }
        return FileVisitResult.CONTINUE;
      }
    });
//    File file = new File("./src/test/resources/local_data/test.pdf");
    File file = new File("/Users/keke/Calibre Library/Unknown/Springer.Social Group Utility Maximization.2015 (1754)/Springer.Social Group Utility Maximization - Unknown.pdf");


    Metadata metadata = new Metadata();

    parser.parse(new FileInputStream(file), new TeeContentHandler(new ISBNExtractorHandler(metadata)), metadata, new ParseContext());
//    System.out.println("Content is " + type);
    System.out.println("Metadata is " + metadata);


  }
}
