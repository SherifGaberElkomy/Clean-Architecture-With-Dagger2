package com.motorgy.myapplication.presentation.ui.lstuser;


import com.motorgy.myapplication.domain.model.UsersModel;
import com.motorgy.myapplication.domain.usecase.GetUserUseCaseImple;
import com.motorgy.myapplication.presentation.base.BaseViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class UserLstViewModel extends BaseViewModel {
    public GetUserUseCaseImple mGetUsrItm;
    public ArrayList<UsersModel> itemUsrModl;
    public Throwable errorItm;

    @Inject
    public UserLstViewModel(GetUserUseCaseImple getUsrItm){
        mGetUsrItm = getUsrItm;
    }


    public void getUserList(){
        CompositeDisposable mCompose = new CompositeDisposable();
        mGetUsrItm.executeApi(mCompose);
    }
}
