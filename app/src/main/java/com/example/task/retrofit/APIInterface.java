package com.example.task.retrofit;


import com.example.task.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/v2021-10-21/data/query/production?query=*%5B_type%20%3D%3D%20'card'%5D%7B%0A%20%20_id%2C%20title%2Cdescription%2CpublishedAt%2C%0A%20%20%22imageUrl%22%3A%20image.asset-%3Eurl%2C%0A%7D")
    Call<Data> getData();


}