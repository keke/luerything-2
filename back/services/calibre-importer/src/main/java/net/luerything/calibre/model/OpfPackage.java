package net.luerything.calibre.model;


import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by keke on 4/20/15.
 */
@XmlRootElement(name = "package")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class OpfPackage implements Serializable {
  private OpfMetadata metadata;
  private String version;
  private String uniqueIdentifier;
  private OpfGuide guide;

  public OpfIdentifier getIdentifier() {
    for (OpfIdentifier id : metadata.getIdList()) {
      if (id.getIdType() != null && id.getIdType().equals(getUniqueIdentifier())) {
        return id;
      }
    }
    return null;
  }

  @XmlElement
  public OpfMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(OpfMetadata metadata) {
    this.metadata = metadata;
  }

  @XmlAttribute(name = "version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @XmlAttribute(name = "unique-identifier")
  public String getUniqueIdentifier() {
    return uniqueIdentifier;
  }

  public void setUniqueIdentifier(String uniqueIdentifier) {
    this.uniqueIdentifier = uniqueIdentifier;
  }

  @XmlElement
  public OpfGuide getGuide() {
    return guide;
  }

  public void setGuide(OpfGuide guide) {
    this.guide = guide;
  }
}
