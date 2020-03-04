package com.motorgy.myapplication.di.module;

import android.content.Context;


import com.motorgy.myapplication.di.qualifiers.ApplicationContextQualifier;
import com.motorgy.myapplication.di.scops.ApplicationScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class NetworkModule {

    @Inject
    public NetworkModule(){

    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
    @Provides
    @ApplicationScope
    public Cache getCache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000);  // 10 MiB cache
    }
    @Provides
    @ApplicationScope
    public File getFile(@ApplicationContextQualifier Context context) {
        File file = new File(context.getFilesDir(), "cache_dir");
        if (!file.exists())
            file.mkdirs();
        return file;
    }
    @Provides
    @ApplicationScope
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor interceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .cache(cache)
                .addInterceptor(interceptor)
                .build();
    }
}
