package net.luerything.calibre;

import net.luerything.calibre.model.CalibreModel;
import net.luerything.calibre.model.OpfPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author keke
 */
public class CalibreImporter {
  private static final Logger LOG = LoggerFactory.getLogger(CalibreImporter.class);
  private static Unmarshaller UNM;

  static {
    try {
      UNM = JAXBContext.newInstance("net.luerything.calibre.model").createUnmarshaller();
    } catch (JAXBException e) {
      LOG.error("Unable to load unmarshallel for net.luerything.calibre.model", e);
      throw new RuntimeException("Unable to start", e);
    }
  }

  public CalibreModel read(Path path) throws IOException {
    if (!Files.isDirectory(path)) {
      throw new IllegalArgumentException("Require directory but receive " + path);
    }
    try {
      OpfPackage opfPackage = (OpfPackage) UNM.unmarshal(path.resolve("metadata.opf").toFile().toURI().toURL());
      return new CalibreModel(path, opfPackage);
    } catch (JAXBException e) {
      throw new IOException(e);
    }
  }

  public void walk(Path calibreRepoRoot, ImportVisitor visitor) throws IOException {
    Files.walkFileTree(calibreRepoRoot, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (Files.exists(dir.resolve("metadata.opf"))) {
          visitor.visit(read(dir));
        }
        return FileVisitResult.CONTINUE;
      }


    });
  }
}
