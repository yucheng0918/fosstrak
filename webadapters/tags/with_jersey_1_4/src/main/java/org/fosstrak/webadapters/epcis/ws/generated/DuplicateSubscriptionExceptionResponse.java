package org.fosstrak.webadapters.epcis.ws.generated;

import javax.xml.ws.WebFault;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "DuplicateSubscriptionException", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
public class DuplicateSubscriptionExceptionResponse
        extends Exception {

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DuplicateSubscriptionException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public DuplicateSubscriptionExceptionResponse(String message, DuplicateSubscriptionException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public DuplicateSubscriptionExceptionResponse(String message, DuplicateSubscriptionException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ch.diuf.unifr.softeng.gen.DuplicateSubscriptionException
     */
    public DuplicateSubscriptionException getFaultInfo() {
        return faultInfo;
    }
}