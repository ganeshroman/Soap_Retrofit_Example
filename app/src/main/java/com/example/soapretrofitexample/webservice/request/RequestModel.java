package com.example.soapretrofitexample.webservice.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */

public class RequestModel {
    @Attribute(name = "xmlns")
    public String cityNameAttribute;

    @Element(name = "theCityName", required = false)
    public String theCityName;     //城市名字

}
