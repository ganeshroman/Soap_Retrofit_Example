package com.example.soapretrofitexample;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.soapretrofitexample.adapter.WeatherResponseAdapter;
import com.example.soapretrofitexample.databinding.ActivityMainBinding;
import com.example.soapretrofitexample.webservice.RetrofitGenerator;
import com.example.soapretrofitexample.webservice.request.RequestBody;
import com.example.soapretrofitexample.webservice.request.RequestEnvelope;
import com.example.soapretrofitexample.webservice.request.RequestModel;
import com.example.soapretrofitexample.webservice.request.User;
import com.example.soapretrofitexample.webservice.response.ResponseEnvelope;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * Created by Ganesh on 14/7/2022.
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private WeatherResponseAdapter adapter;
    private List<String> listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.rvElements.setLayoutManager(new LinearLayoutManager(this));
        listResult =  new ArrayList<String>();
        adapter = new WeatherResponseAdapter(listResult);
        binding.rvElements.setAdapter(adapter);

    }

    /**
     *
     * @param view
     */
    public void sendRequest(View view) {
        if(TextUtils.isEmpty(binding.etCityName.getText())) {
            Toast.makeText(this, getString(R.string.make_request), Toast.LENGTH_SHORT).show();
        } else {
            hideKeyboard();
            getWeatherbyCityName();
        }
    }

    /**
     *
     * @param view
     */
    public void sendRequest2(View view) {
        getUsers();
    }

    /**
     *
     * @return
     */
    public void getWeatherbyCityName() {
        binding.progressbar.setVisibility(View.VISIBLE);
        RequestEnvelope requestEnvelop = new RequestEnvelope();
        RequestBody requestBody = new RequestBody();
        RequestModel requestModel = new RequestModel();
        requestModel.theCityName = binding.etCityName.getText().toString();
        requestModel.cityNameAttribute = "http://WebXml.com.cn/";
        requestBody.getWeatherbyCityName = requestModel;
        requestEnvelop.body = requestBody;
        Call<ResponseEnvelope> call = RetrofitGenerator.getWeatherInterfaceApi().getWeatherbyCityName(requestEnvelop);
        call.enqueue(new Callback<ResponseEnvelope>() {
            @Override
            public void onResponse(Response<ResponseEnvelope> response) {
                binding.progressbar.setVisibility(View.GONE);
                ResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope != null ) {
                    List<String> list = responseEnvelope.body.getWeatherbyCityNameResponse.result;
                    listResult.clear();
                    listResult.addAll(list);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.e("getWeatherbyCityName", t.getMessage());
                binding.progressbar.setVisibility(View.GONE);
            }
        });
    }

    /**
     *
     * @return
     */
    public void getUsers() {
        binding.progressbar.setVisibility(View.VISIBLE);
        Call<List<User>> call = RetrofitGenerator.getGithubInterfaceApi().getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response) {
                binding.progressbar.setVisibility(View.GONE);
                List<User> responseEnvelope = response.body();
                if (responseEnvelope != null ) {
                    List<String> list = new ArrayList<>(responseEnvelope.size());
                    for(User user : responseEnvelope) {
                        list.add(user.getLogin());
                    }
                    listResult.clear();
                    listResult.addAll(list);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.e("getUsers", t.getMessage());
                binding.progressbar.setVisibility(View.GONE);
            }
        });
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
