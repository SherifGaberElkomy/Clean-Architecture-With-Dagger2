package com.motorgy.myapplication.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.motorgy.myapplication.di.ViewModelKey;
import com.motorgy.myapplication.presentation.factory.ViewModelFactory;
import com.motorgy.myapplication.presentation.ui.lstuser.UserLstViewModel;
import com.motorgy.myapplication.presentation.ui.usrprofiledetails.UserDetailsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @SuppressWarnings("unused")
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @SuppressWarnings("unused")
    @Binds
    @IntoMap
    @ViewModelKey(value = UserLstViewModel.class)
    abstract ViewModel provideUserListViewModel(UserLstViewModel userListViewModel);


    @SuppressWarnings("unused")
    @Binds
    @IntoMap
    @ViewModelKey(value = UserDetailsViewModel.class)
    abstract ViewModel provideUserDetailseViewModel(UserDetailsViewModel userDetailsViewModel);

}