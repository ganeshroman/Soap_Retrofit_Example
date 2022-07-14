package com.example.soapretrofitexample.webservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "enc"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv")
})
public class ResponseEnvelope {
    @Element(name = "Body")
    public WeatherResponseBody body;

}
