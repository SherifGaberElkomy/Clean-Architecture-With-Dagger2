package com.motorgy.myapplication.presentation.ui.usrprofiledetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.motorgy.myapplication.R;
import com.motorgy.myapplication.domain.model.UserProfileDetailsModel;
import com.motorgy.myapplication.presentation.factory.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailsFragment extends DaggerFragment {


    TextView mFrstItem;
    TextView mSeconedItem;
    TextView mThirdItem;
    TextView mFourthItem;
    TextView mFifthItem;
    TextView mSixItem;
    TextView mSevenItem;

    @Inject ViewModelFactory viewModelFactory;
    UserDetailsViewModel mUsrDetailsVwModel;

    private int mUserId = 0;
    public UserDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user_details, container, false);
        loadControl(view);
        mUserId = getArguments().getInt("itemId");
        mUsrDetailsVwModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(UserDetailsViewModel.class);
        mUsrDetailsVwModel.getUserDetailse(mUserId);
        mUsrDetailsVwModel.mGetUsrItm.getUserDetails().observe(getViewLifecycleOwner(), new Observer<UserProfileDetailsModel>() {
            @Override
            public void onChanged(UserProfileDetailsModel userProfileDetailsModel) {
                mFrstItem.setText(userProfileDetailsModel.name);
                mSeconedItem.append(userProfileDetailsModel.userName);
                mThirdItem.append(userProfileDetailsModel.address.street);
                mFourthItem.append(userProfileDetailsModel.email);
                mFifthItem.append(userProfileDetailsModel.address.zipcode);
                mSixItem.append(userProfileDetailsModel.company.bs);
                mSevenItem.append(userProfileDetailsModel.company.name);
            }
        });

        mUsrDetailsVwModel.mGetUsrItm.getErrorResponse(getViewLifecycleOwner(), new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {

            }
        });

        return view;
    }

    private void loadControl(View view) {
        mFrstItem = (TextView)view.findViewById(R.id.frstItem);
        mSeconedItem = (TextView)view.findViewById(R.id.seconedItem);
        mThirdItem = (TextView)view.findViewById(R.id.thirdItem);
        mFourthItem = (TextView)view.findViewById(R.id.fourthItem);
        mFifthItem = (TextView)view.findViewById(R.id.fifthItem);
        mSixItem = (TextView)view.findViewById(R.id.sixItem);
        mSevenItem = (TextView)view.findViewById(R.id.sevenItem);
    }
}
