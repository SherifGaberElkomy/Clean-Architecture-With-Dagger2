package com.motorgy.myapplication.domain.usecase;

import androidx.lifecycle.MutableLiveData;


import com.motorgy.myapplication.data.repositery.GetApiImple;
import com.motorgy.myapplication.domain.model.UsersModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@Module
public class GetUserUseCaseImple implements IGetUserUseCase {

    private GetApiImple mGetApiImplItem;
    private MutableLiveData<ArrayList<UsersModel>> mLivDataUser = new MutableLiveData<>();
    private MutableLiveData<Throwable> mLivDataError = new MutableLiveData<>();

    @Inject
    public GetUserUseCaseImple(GetApiImple getApiImplItem) {
        mGetApiImplItem = getApiImplItem;
    }

    @Override
    public void executeApi(CompositeDisposable compositeDisposable) {
        compositeDisposable.add(mGetApiImplItem.getAllUserList().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ArrayList<UsersModel>>() {

                    @Override
                    public void onSuccess(ArrayList<UsersModel> usersModels) {
                        mLivDataUser.setValue(usersModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mLivDataError.setValue(e);
                    }
                }));
    }


    public MutableLiveData<ArrayList<UsersModel>> getUserList(){
        return mLivDataUser;
    }

    public MutableLiveData<Throwable> getErrorResponse(){
        return mLivDataError;
    }

}
