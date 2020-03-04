package com.motorgy.myapplication.domain.usecase;

import io.reactivex.disposables.CompositeDisposable;

public interface IGetUserDetailseProfileUseCase {
    void executeUserDetailseApi(int userId);
}
