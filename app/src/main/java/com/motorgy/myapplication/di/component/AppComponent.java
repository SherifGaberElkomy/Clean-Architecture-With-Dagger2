package com.motorgy.myapplication.di.component;

import com.motorgy.myapplication.ApplicationApp;
import com.motorgy.myapplication.di.module.ActivityBuilder;
import com.motorgy.myapplication.di.module.ApiModule;
import com.motorgy.myapplication.di.module.AppModule;
import com.motorgy.myapplication.di.module.MainFragmentBuilder;
import com.motorgy.myapplication.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ApiModule.class,
        ViewModelModule.class,
        ActivityBuilder.class,
        MainFragmentBuilder.class
})

public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(ApplicationApp application);
        Builder appModule(AppModule appModule);
        AppComponent build();
    }

    void inject(ApplicationApp application);

}

