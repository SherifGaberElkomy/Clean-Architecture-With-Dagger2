package com.motorgy.myapplication.presentation.ui.lstuser;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.motorgy.myapplication.ApplicationApp;
import com.motorgy.myapplication.R;
import com.motorgy.myapplication.domain.model.UsersModel;
import com.motorgy.myapplication.presentation.factory.ViewModelFactory;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserLstFragment extends DaggerFragment implements ICallBkNavigateToDetailse {

    private RecyclerView mLstUserRecyclerView;
    @Inject ViewModelFactory viewModelFactory;
    UserLstViewModel mLstVwModel;
    private UserListAdapter mAdapter;
    private View mView = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(mView == null) {
            mView = inflater.inflate(R.layout.fragment_user_lst, container, false);
            loadControl(mView);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ApplicationApp.sContext);
            mLstUserRecyclerView.setLayoutManager(mLayoutManager);
            mLstUserRecyclerView.setHasFixedSize(true);
            mLstUserRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mLstVwModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(UserLstViewModel.class);
            mLstVwModel.getUserList();
            mLstVwModel.mGetUsrItm.getUserList().observe(getViewLifecycleOwner(), new Observer<ArrayList<UsersModel>>() {
                @Override
                public void onChanged(ArrayList<UsersModel> usersModels) {
                    mAdapter = new UserListAdapter(getActivity().getApplicationContext(), UserLstFragment.this, usersModels);
                    mLstUserRecyclerView.setAdapter(mAdapter);
                }
            });
            mLstVwModel.mGetUsrItm.getErrorResponse().observe(getViewLifecycleOwner(), new Observer<Throwable>() {
                @Override
                public void onChanged(Throwable throwable) {
                    int y = 0;
                }
            });
        }
        return mView;
    }

    private void loadControl(View view) {
        mLstUserRecyclerView = view.findViewById(R.id.listUser);
    }

    @Override
    public void navigationToDetailse(View view, int idItem) {
        Bundle bundle = new Bundle();
        bundle.putInt("itemId", idItem);
        Navigation.findNavController(view).navigate(R.id.action_userListFragment_to_userDetailsFragment, bundle);
    }
}
