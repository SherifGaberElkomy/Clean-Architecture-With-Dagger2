package com.motorgy.myapplication.domain.repositery;



import com.motorgy.myapplication.domain.model.UsersModel;

import java.util.ArrayList;

import io.reactivex.Single;

public interface IGetApiRepositery {
    Single<ArrayList<UsersModel>> getAllUserList();
}
