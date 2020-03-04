package com.motorgy.myapplication.domain.usecase;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.motorgy.myapplication.data.repositery.GetApiImple;
import com.motorgy.myapplication.data.repositery.GetUserDetailseImpl;
import com.motorgy.myapplication.domain.model.UserProfileDetailsModel;
import com.motorgy.myapplication.domain.model.UsersModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@Module
public class GetUserDetailseProfileUseCase implements IGetUserDetailseProfileUseCase {

    private GetUserDetailseImpl mGetUserImplItem;
    private MutableLiveData<UserProfileDetailsModel> mLivDataUser = new MutableLiveData<>();
    private MutableLiveData<Throwable> mLivDataError = new MutableLiveData<>();

    @Inject
    public GetUserDetailseProfileUseCase(GetUserDetailseImpl getUserImplItem) {
        mGetUserImplItem = getUserImplItem;
    }



    @Override
    public void executeUserDetailseApi(int userId) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(mGetUserImplItem.getAllUserDetailse(userId).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<UserProfileDetailsModel>() {

                    @Override
                    public void onSuccess(UserProfileDetailsModel userDetailseModel) {
                        mLivDataUser.setValue(userDetailseModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mLivDataError.setValue(e);
                    }
                }));
    }

    public MutableLiveData<UserProfileDetailsModel> getUserDetails(){
        return mLivDataUser;
    }

    public MutableLiveData<Throwable> getErrorResponse(LifecycleOwner viewLifecycleOwner, Observer<Throwable> observer){
        return mLivDataError;
    }


}
