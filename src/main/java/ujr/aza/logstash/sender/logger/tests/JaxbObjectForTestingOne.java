
package ujr.aza.logstash.sender.logger.tests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for Output_ApplicationDetails_RandomNumber_TYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Output_ApplicationDetails_RandomNumber_TYPE">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://proteo.bs.com/engine/entity/decisionengineretailRs/v1>Output_ApplicationDetails_RandomNumber_VALUE">
 *       &lt;attribute name="RepeatingBlockName" use="required" type="{http://proteo.bs.com/engine/entity/decisionengineretailRs/v1}Output_ApplicationDetails_RandomNumber_RepeatingBlockName_TYPE" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Output_ApplicationDetails_RandomNumber_TYPE", propOrder = {
    "value"
})
public class JaxbObjectForTestingOne {

    @XmlValue
    protected int value;
    @XmlAttribute(name = "RepeatingBlockName", required = true)
    protected int repeatingBlockName;

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
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
