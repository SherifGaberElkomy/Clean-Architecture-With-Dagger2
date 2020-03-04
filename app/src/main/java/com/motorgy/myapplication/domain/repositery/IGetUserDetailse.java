package com.motorgy.myapplication.domain.repositery;

import com.motorgy.myapplication.domain.model.UserProfileDetailsModel;
import com.motorgy.myapplication.domain.model.UsersModel;


import io.reactivex.Single;

public interface IGetUserDetailse {
    Single<UserProfileDetailsModel> getAllUserDetailse(int userId);
}
