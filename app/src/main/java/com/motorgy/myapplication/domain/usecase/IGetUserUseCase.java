package com.motorgy.myapplication.domain.usecase;

import io.reactivex.disposables.CompositeDisposable;

public interface IGetUserUseCase {
     void executeApi(CompositeDisposable compositeDisposable);
}
