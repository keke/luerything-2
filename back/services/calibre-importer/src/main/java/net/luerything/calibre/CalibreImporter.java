package net.luerything.calibre;

import net.luerything.calibre.model.CalibreModel;
import net.luerything.calibre.model.OpfPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author keke
 *
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
    try {
      OpfPackage opfPackage = (OpfPackage) UNM.unmarshal(path.toFile());
      return new CalibreModel(opfPackage);
    } catch (JAXBException e) {
      throw new IOException(e);
    }
  }
}