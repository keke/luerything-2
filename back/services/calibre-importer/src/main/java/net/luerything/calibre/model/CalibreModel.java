package net.luerything.calibre.model;

import java.io.Serializable;

/**
 * @author keke
 */
public class CalibreModel implements Serializable {
  private OpfPackage opfPackage;

  public CalibreModel(OpfPackage opfPackage) {
    this.opfPackage = opfPackage;
  }

  public OpfPackage getOpfPackage() {
    return opfPackage;
  }
}
