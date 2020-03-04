package com.motorgy.myapplication.di.module;



import com.motorgy.myapplication.presentation.ui.lstuser.UserLstFragment;
import com.motorgy.myapplication.presentation.ui.usrprofiledetails.UserDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuilder {

    @ContributesAndroidInjector
    abstract UserLstFragment contributeUserListFragment();
    @ContributesAndroidInjector
    abstract UserDetailsFragment contributeUserDetailsListFragment();
}
