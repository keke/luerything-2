package net.luerything.calibre;

import net.luerything.calibre.model.CalibreModel;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by keke on 4/20/15.
 */
public class CalibreImportTestMain {

  public static void main(String[] args) throws IOException {
    Path path = FileSystems.getDefault().getPath("/Users/keke/Calibre Library/James Cryer/Pro Grunt.js (1783)");
//    CalibreModel calibreModel= new CalibreImporter().read(path);
//    System.out.println(calibreModel.getOpfPackage().getIdentifier());
//    System.out.println(calibreModel.getOpfPackage().getMetadata().getCreators());
//    System.out.println(calibreModel.getOpfPackage().getMetadata().getSubjects());
//    System.out.println(calibreModel.getFiles()[0]);
    new CalibreImporter().walk(FileSystems.getDefault().getPath("/Users/keke/Calibre Library/"), new ImportVisitor() {
      @Override
      public void visit(CalibreModel model) {
        System.out.println("Found : " + model.getOpfPackage().getMetadata().getTitle());
      }
    });
  }
}
