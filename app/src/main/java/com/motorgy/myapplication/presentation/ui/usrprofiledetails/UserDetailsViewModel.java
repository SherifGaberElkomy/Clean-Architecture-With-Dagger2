package com.motorgy.myapplication.presentation.ui.usrprofiledetails;

import com.motorgy.myapplication.data.repositery.GetUserDetailseImpl;
import com.motorgy.myapplication.domain.model.UsersModel;
import com.motorgy.myapplication.domain.usecase.GetUserDetailseProfileUseCase;
import com.motorgy.myapplication.domain.usecase.GetUserUseCaseImple;
import com.motorgy.myapplication.presentation.base.BaseViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class UserDetailsViewModel extends BaseViewModel {
    public GetUserDetailseProfileUseCase mGetUsrItm;
    public ArrayList<UsersModel> itemUsrModl;
    public Throwable errorItm;

    @Inject
    public UserDetailsViewModel(GetUserDetailseProfileUseCase getUsrItm){
        mGetUsrItm = getUsrItm;
    }




    public void getUserDetailse(int userId){
        CompositeDisposable mCompose = new CompositeDisposable();
        mGetUsrItm.executeUserDetailseApi(userId);
    }
}
