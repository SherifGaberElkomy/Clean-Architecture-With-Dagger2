package com.motorgy.myapplication.data.remot.api;

import com.motorgy.myapplication.domain.model.UserProfileDetailsModel;
import com.motorgy.myapplication.domain.model.UsersModel;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiTest {
    @GET("/users/")
    Single<ArrayList<UsersModel>> getUsersData();

    @GET("/users/{user_id}")
    Single<UserProfileDetailsModel> getUserDataDetailse(@Path("user_id") int userId);

}
