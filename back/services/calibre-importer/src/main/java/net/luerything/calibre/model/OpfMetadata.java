package net.luerything.calibre.model;

import net.luerything.calibre.model.util.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author keke
 */
@XmlType(name = "metadata")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class OpfMetadata implements Serializable {
  private String title;
  private Date date;
  private List<OpfIdentifier> idList;
  private List<String> subjects;
  private String language;
  private String description;
  private List<OpfCreator> creators;

  @XmlElement(name = "title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @XmlElement(name = "date")
  @XmlJavaTypeAdapter(DateAdapter.class)
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @XmlElement(name = "identifier")
  public List<OpfIdentifier> getIdList() {
    return idList;
  }

  public void setIdList(List<OpfIdentifier> idList) {
    this.idList = idList;
  }

  @XmlElement(name = "subject")
  public List<String> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<String> subjects) {
    this.subjects = subjects;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlElement(name = "creator")
  public List<OpfCreator> getCreators() {
    return creators;
  }

  public void setCreators(List<OpfCreator> creators) {
    this.creators = creators;
  }
}
