/**
 * Created by keke on 4/20/15.
 */
@XmlSchema(namespace = "http://www.idpf.org/2007/opf",
    xmlns = {@XmlNs(prefix = "dc",
        namespaceURI = "http://purl.org/dc/elements/1.1/"),
        @XmlNs(prefix = "opf", namespaceURI = "http://www.idpf.org/2007/opf")},
    elementFormDefault = XmlNsForm.QUALIFIED)
package net.luerything.calibre.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;