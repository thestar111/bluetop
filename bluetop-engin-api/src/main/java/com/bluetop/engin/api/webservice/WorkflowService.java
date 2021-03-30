package com.bluetop.engin.api.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.3
 * 2021-03-30T21:37:23.992+08:00
 * Generated source version: 3.4.3
 *
 */
@WebServiceClient(name = "WorkflowService",
                  wsdlLocation = "file:../../WorkflowService.wsdl",
                  targetNamespace = "webservices.services.weaver.com.cn")
public class WorkflowService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("webservices.services.weaver.com.cn", "WorkflowService");
    public final static QName WorkflowServiceHttpPort = new QName("webservices.services.weaver.com.cn", "WorkflowServiceHttpPort");
    static {
        URL url = null;
        try {
            url = new URL("file:../../WorkflowService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WorkflowService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:../../WorkflowService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WorkflowService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WorkflowService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WorkflowService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public WorkflowService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public WorkflowService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public WorkflowService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns WorkflowServicePortType
     */
    @WebEndpoint(name = "WorkflowServiceHttpPort")
    public WorkflowServicePortType getWorkflowServiceHttpPort() {
        return super.getPort(WorkflowServiceHttpPort, WorkflowServicePortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WorkflowServicePortType
     */
    @WebEndpoint(name = "WorkflowServiceHttpPort")
    public WorkflowServicePortType getWorkflowServiceHttpPort(WebServiceFeature... features) {
        return super.getPort(WorkflowServiceHttpPort, WorkflowServicePortType.class, features);
    }

}
