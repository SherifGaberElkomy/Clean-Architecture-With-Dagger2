package com.motorgy.myapplication.di.module;

import com.motorgy.myapplication.data.remot.api.ApiTest;
import com.motorgy.myapplication.di.scops.ApplicationScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @ApplicationScope
    public ApiTest getApiInterface(Retrofit retroFit) {
        return retroFit.create(ApiTest.class);
    }

    @Inject
    public ApiModule(){

    }

    @Provides
    @ApplicationScope
    public Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }


}

