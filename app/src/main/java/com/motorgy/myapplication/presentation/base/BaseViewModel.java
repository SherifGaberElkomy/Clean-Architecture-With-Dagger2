package com.motorgy.myapplication.presentation.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {

  private CompositeDisposable mCompositDisposable = new CompositeDisposable();

  public void addDisposable(Disposable disposable){
      mCompositDisposable.add(disposable);
  }

    @Override
    protected void onCleared() {
       mCompositDisposable.clear();
        super.onCleared();
    }
}
