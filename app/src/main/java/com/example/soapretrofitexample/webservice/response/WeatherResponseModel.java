package com.example.soapretrofitexample.webservice.response;



import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */

@Root(name = "getWeatherbyCityNameResponse")
@Namespace(reference = "http://WebXml.com.cn/")
public class WeatherResponseModel {

    @ElementList(name = "getWeatherbyCityNameResult")
    public List<String> result;

}
