package net.luerything.calibre;

import net.luerything.calibre.model.CalibreModel;

/**
 * Created by keke on 4/20/15.
 */
public interface ImportVisitor {
  void visit(CalibreModel model);
}
