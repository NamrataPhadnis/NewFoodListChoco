package com.example.newfoodlistchoco;



import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("chocolatejson.php")
    abstract public Call<Chocolatelist> getChocolateList();

}