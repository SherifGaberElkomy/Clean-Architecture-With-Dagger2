package com.motorgy.myapplication.data.repositery;

import android.content.Context;


import com.motorgy.myapplication.ApplicationApp;
import com.motorgy.myapplication.di.module.ApiModule;
import com.motorgy.myapplication.di.module.NetworkModule;
import com.motorgy.myapplication.domain.model.UsersModel;
import com.motorgy.myapplication.domain.repositery.IGetApiRepositery;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.Single;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class GetApiImple implements IGetApiRepositery {

    private ApiModule mApiItem;
    private NetworkModule mNetworkItem;
    private HttpLoggingInterceptor mHttpLogger;
    private OkHttpClient mOkHttpClient;
    private Context mContext;
    @Inject
    public GetApiImple(ApiModule apiItem, NetworkModule networkItem){
        mApiItem = apiItem;
        mNetworkItem = networkItem;
        mHttpLogger = networkItem.getInterceptor();
        mContext = ApplicationApp.sContext;
        File file = networkItem.getFile(mContext);
        Cache cach = networkItem.getCache(file);
        mOkHttpClient = networkItem.getOkHttpClient(mHttpLogger, cach);

    }

    @Override
    public Single<ArrayList<UsersModel>> getAllUserList() {
        return mApiItem.getApiInterface(mApiItem.getRetrofit(mOkHttpClient)).getUsersData();
    }
}
