package net.luerything.calibre.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;

/**
 * @author keke
 */
@XmlType(name = "identifier")
public class OpfIdentifier implements Serializable {
  private String scheme;
  private String idType;
  private String value;

  @XmlAttribute(name = "scheme", namespace = "http://www.idpf.org/2007/opf")
  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  @XmlAttribute(name = "id")
  public String getIdType() {
    return idType;
  }

  public void setIdType(String idType) {
    this.idType = idType;
  }

  @XmlValue
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "OpfIdentifier{" +
        "scheme='" + scheme + '\'' +
        ", idType='" + idType + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
