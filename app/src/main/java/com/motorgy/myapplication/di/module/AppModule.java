package com.motorgy.myapplication.di.module;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;

import androidx.room.Room;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application providesApplication() {
        return application;
    }

    @Singleton @Provides
    AudioManager providesAudioManager(Application app){
        return (AudioManager) app.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
    }

    @Provides
    ContentResolver providesContentResolver(Application app){
        return app.getContentResolver();
    }



}
