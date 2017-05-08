
package ujr.aza.logstash.sender.logger.tests;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Output_DecisionDetails_ReasonCodes_TYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Output_DecisionDetails_ReasonCodes_TYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ReasonCode" type="{http://proteo.bs.com/engine/entity/decisionengineretailRs/v1}Output_DecisionDetails_ReasonCodes_ReasonCode_TYPE" maxOccurs="20" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Output_DecisionDetails_ReasonCodes_TYPE", propOrder = {
    "reasonCode"
})
public class DetailsAppl {

    @XmlElement(name = "ReasonCode")
    public List<CodeReason> reasonCode;

    /**
     * Gets the value of the reasonCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reasonCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReasonCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeReason }
     * 
     * 
     */
    public List<CodeReason> getReasonCode() {
        if (reasonCode == null) {
            reasonCode = new ArrayList<CodeReason>();
        }
        return this.reasonCode;
    }

}
