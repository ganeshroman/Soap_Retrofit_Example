package com.example.soapretrofitexample.webservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */
@Root(name = "Body")
public class WeatherResponseBody {

    @Element(name = "getWeatherbyCityNameResponse", required = false)
    public WeatherResponseModel getWeatherbyCityNameResponse;

}
