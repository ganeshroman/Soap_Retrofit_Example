package com.example.soapretrofitexample.webservice;

import com.example.soapretrofitexample.webservice.request.RequestEnvelope;
import com.example.soapretrofitexample.webservice.response.ResponseEnvelope;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */
public interface WeatherInterfaceApi {

    @Headers({"Content-Type: text/xml;charset=UTF-8", "SOAPAction: http://WebXml.com.cn/getWeatherbyCityName"})//请求的Action，类似于方法名
    @POST("WeatherWebService.asmx")
    Call<ResponseEnvelope> getWeatherbyCityName(@Body RequestEnvelope requestEnvelope);

}
