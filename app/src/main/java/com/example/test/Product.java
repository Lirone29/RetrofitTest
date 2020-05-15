package com.example.test;

import com.google.gson.annotations.SerializedName;

import java.io.File;

public class Product {

    //@SerializedName("id")
    //public int mId;

    @SerializedName("name")
    public String name;

    @SerializedName("daysToExpire")
    public int daysToExpire;

    @SerializedName("weight")
    public int weight;


    @SerializedName("calories")
    public int calories;

    @SerializedName("photo")
    private File photo;

    public Product(){

    }

    //public int getmId() {
    //    return mId;
    //}


    public String getName() {
        return name;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public int getWeight() {
        return weight;
    }

    public int getCalories() {
        return calories;
    }

    public File getPhoto() {
        return photo;
    }
}

