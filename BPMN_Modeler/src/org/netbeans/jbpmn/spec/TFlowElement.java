/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jbpmn.spec;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.netbeans.jbpmn.spec.adapter.MultilineString;
import org.netbeans.modeler.core.NBModelerUtil;
import org.netbeans.modeler.specification.model.document.core.IFlowElement;

/**
 * <p>
 * Java class for tFlowElement complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * <complexType name="tFlowElement">
 *   <complexContent>
 *     <extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tBaseElement">
 *       <sequence>
 *         <element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}auditing" minOccurs="0"/>
 *         <element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}monitoring" minOccurs="0"/>
 *         <element name="categoryValueRef" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFlowElement", propOrder = {
    "auditing",
    "monitoring",
    "categoryValueRef"
})
@XmlSeeAlso({
    TSequenceFlow.class,
    TDataObject.class,
    TDataObjectReference.class,
    TDataStoreReference.class,
    TFlowNode.class
})
public abstract class TFlowElement
        extends TBaseElement implements IFlowElement {

    @XmlElement(name = "auditing")
    protected TAuditing auditing;
    @XmlElement(name = "monitoring")
    protected TMonitoring monitoring;
    protected List<QName> categoryValueRef;
    @XmlJavaTypeAdapter(MultilineString.class)
    @XmlAttribute
    protected String name;

    void beforeMarshal(Marshaller marshaller) {
        super.beforeMarshal(marshaller);
//        if (name != null) {
//            name = name.replaceAll("\n", "&#xA;");
//            System.out.println("Name " + name);
//        }
        if (auditing != null) {
            if (auditing.getDocumentation().size() < 1) {
                auditing = null;
            }
        }
        if (monitoring != null) {
            if (monitoring.getDocumentation().size() < 1) {
                monitoring = null;
            }
        }
    }

    /**
     * Gets the value of the auditing property.
     *
     * @return possible object is {@link TAuditing }
     *
     */
    public TAuditing getAuditing() {
        return auditing;
    }

    /**
     * Sets the value of the auditing property.
     *
     * @param value allowed object is {@link TAuditing }
     *
     */
    public void setAuditing(TAuditing value) {
        this.auditing = value;
    }

    public String getAuditingEmbedded() {
        if (auditing == null) {
            auditing = new TAuditing();
        }
        return auditing.getDocumentationEmbedded();
    }

    public void setAuditingEmbedded(String value) {
        if (value == null || value.trim().isEmpty()) {
            auditing = null;
        } else {
            if (auditing == null) {
                auditing = new TAuditing();
                auditing.setId(NBModelerUtil.getAutoGeneratedStringId());
            }
            auditing.setDocumentationEmbedded(value);
        }
    }

    /**
     * Gets the value of the monitoring property.
     *
     * @return possible object is {@link TMonitoring }
     *
     */
    public TMonitoring getMonitoring() {
        return monitoring;
    }

    /**
     * Sets the value of the monitoring property.
     *
     * @param value allowed object is {@link TMonitoring }
     *
     */
    public void setMonitoring(TMonitoring value) {
        this.monitoring = value;
    }

    public String getMonitoringEmbedded() {
        if (monitoring == null) {
            monitoring = new TMonitoring();
        }
        return monitoring.getDocumentationEmbedded();
    }

    public void setMonitoringEmbedded(String value) {
        if (value == null || value.trim().isEmpty()) {
            monitoring = null;
        } else {
            if (monitoring == null) {
                monitoring = new TMonitoring();
                monitoring.setId(NBModelerUtil.getAutoGeneratedStringId());
            }
            monitoring.setDocumentationEmbedded(value);
        }
    }

    /**
     * Gets the value of the categoryValueRef property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the categoryValueRef property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryValueRef().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link QName }
     *
     *
     */
    public List<QName> getCategoryValueRef() {
        if (categoryValueRef == null) {
            categoryValueRef = new ArrayList<QName>();
        }
        return this.categoryValueRef;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

}
