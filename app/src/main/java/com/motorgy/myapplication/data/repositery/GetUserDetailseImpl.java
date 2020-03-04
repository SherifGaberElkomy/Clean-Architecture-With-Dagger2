package com.motorgy.myapplication.data.repositery;

import android.content.Context;

import com.motorgy.myapplication.ApplicationApp;
import com.motorgy.myapplication.di.module.ApiModule;
import com.motorgy.myapplication.di.module.NetworkModule;
import com.motorgy.myapplication.domain.model.UserProfileDetailsModel;
import com.motorgy.myapplication.domain.repositery.IGetUserDetailse;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class GetUserDetailseImpl implements IGetUserDetailse {

    private ApiModule mApiItem;
    private NetworkModule mNetworkItem;
    private HttpLoggingInterceptor mHttpLogger;
    private OkHttpClient mOkHttpClient;
    private Context mContext;
    @Inject
    public GetUserDetailseImpl(ApiModule apiItem, NetworkModule networkItem){
        mApiItem = apiItem;
        mNetworkItem = networkItem;
        mHttpLogger = networkItem.getInterceptor();
        mContext = ApplicationApp.sContext;
        File file = networkItem.getFile(mContext);
        Cache cach = networkItem.getCache(file);
        mOkHttpClient = networkItem.getOkHttpClient(mHttpLogger, cach);

    }

    @Override
    public Single<UserProfileDetailsModel> getAllUserDetailse(int userId) {
        return mApiItem.getApiInterface(mApiItem.getRetrofit(mOkHttpClient)).getUserDataDetailse(userId);
    }
}
