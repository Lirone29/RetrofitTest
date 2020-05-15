package com.example.test;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.moshi.Json;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private String urlString = "http://mtx.pmlabs.net:8888/";

    private List<Product> productsArrayList;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(urlString)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    IProduct productApi = retrofit.create(IProduct.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();

    }

    public void initView() {
        textViewResult = findViewById(R.id.text_view_result);


       Call<List<Product>> call = productApi.listProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                productsArrayList = response.body();
                Log.d("All Products: ", productsArrayList.get(0).getName());

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

}
