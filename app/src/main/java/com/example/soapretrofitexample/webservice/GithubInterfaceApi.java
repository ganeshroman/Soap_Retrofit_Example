package com.example.soapretrofitexample.webservice;


import com.example.soapretrofitexample.webservice.request.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * @Description: //todo
 * @anthor Ganesh Email:ganesh.roman.edu@gmail.com
 * @time 2022/7/14 10:00
 */
public interface GithubInterfaceApi {

    String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";

    @Headers({HEADER_API_VERSION})
    @GET("/users")
    Call<List<User>> getUsers();
}
