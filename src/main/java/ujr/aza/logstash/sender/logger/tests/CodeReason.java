
package ujr.aza.logstash.sender.logger.tests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Output_DecisionDetails_ReasonCodes_ReasonCode_TYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Output_DecisionDetails_ReasonCodes_ReasonCode_TYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Text" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DocumentEvidenceRequired" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[MPN](?#Not a Valid Enumeration M, P or N)"/>
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *       &lt;attribute name="RepeatingBlockName" use="required" type="{http://proteo.bs.com/engine/entity/decisionengineretailRs/v1}Output_DecisionDetails_ReasonCodes_ReasonCode_RepeatingBlockName_TYPE" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Output_DecisionDetails_ReasonCodes_ReasonCode_TYPE", propOrder = {

})
public class CodeReason {

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Text")
    protected String text;
    @XmlElement(name = "DocumentEvidenceRequired")
    protected String documentEvidenceRequired;
    @XmlAttribute(name = "RepeatingBlockName", required = true)
    protected int repeatingBlockName;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the documentEvidenceRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentEvidenceRequired() {
        return documentEvidenceRequired;
    }

    /**
     * Sets the value of the documentEvidenceRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentEvidenceRequired(String value) {
        this.documentEvidenceRequired = value;
    }

    /**
     * Gets the value of the repeatingBlockName property.
     * 
     */
    public int getRepeatingBlockName() {
        return repeatingBlockName;
    }

    /**
     * Sets the value of the repeatingBlockName property.
     * 
     */
    public void setRepeatingBlockName(int value) {
        this.repeatingBlockName = value;
    }

}
