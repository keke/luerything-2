package net.luerything.calibre.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;

/**
 * @author keke
 */
public class CalibreModel implements Serializable {
  private OpfPackage opfPackage;
  private Path root;

  public CalibreModel(Path root, OpfPackage opfPackage) {
    this.opfPackage = opfPackage;
    this.root = root;
  }

  public OpfPackage getOpfPackage() {
    return opfPackage;
  }

  public File[] getFiles() throws IOException {
    return root.toFile().listFiles((dir, name) -> !name.equals("metadata.opf") && !name.equals("cover.jpg"));
  }
}
