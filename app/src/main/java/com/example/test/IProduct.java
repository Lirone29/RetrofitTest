package com.example.test;

import com.squareup.moshi.Json;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface IProduct {
    //@GET("api/products/")
    //Call<String> getStringProducts();

    //@GET("api/products/?page=1")
    //Call<JSONObject> listProductsJson();

    @GET("api/products/")
    Call<List<Product>> listProducts();

    //@GET("api/products/")
    //Call<Product[]> arrayProducts();
}
