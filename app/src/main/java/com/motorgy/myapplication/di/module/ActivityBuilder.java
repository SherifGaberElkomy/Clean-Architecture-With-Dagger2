package com.motorgy.myapplication.di.module;

import com.motorgy.myapplication.MainActivity;
import com.motorgy.myapplication.di.scops.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ActivityScope
   // @ContributesAndroidInjector(modules = MainFragmentBuilder.class)
    @ContributesAndroidInjector
    abstract MainActivity bindVideoListActivity();
}
