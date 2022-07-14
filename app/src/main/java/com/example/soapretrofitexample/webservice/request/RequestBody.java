package com.example.soapretrofitexample.webservice.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */
@Root(name = "soapenv:Body", strict = false)
public class RequestBody {

    @Element(name = "getWeatherbyCityName", required = false)
    public RequestModel getWeatherbyCityName;
}
