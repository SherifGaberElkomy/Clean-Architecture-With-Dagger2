package com.motorgy.myapplication.presentation.ui.lstuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.motorgy.myapplication.R;
import com.motorgy.myapplication.domain.model.UsersModel;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private ArrayList<UsersModel> mUserLstItems;
    private ICallBkNavigateToDetailse mCallBkItm;
    private Context mContext;
    private LayoutInflater mInflater;
    public UserListAdapter(){

    }
    public UserListAdapter(Context context, ICallBkNavigateToDetailse callBkItm, ArrayList<UsersModel> userLstItems){
        mUserLstItems = userLstItems;
        mContext = context;
        mCallBkItm = callBkItm;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.userrowitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UsersModel mUsrModel = mUserLstItems.get(position);
        holder.mContrainerItm.setTag(position);
        holder.mTitleTxtView.setText(mUsrModel.userName);
        holder.mDescriptionTxtView.setText(mUsrModel.address.street);
        holder.mPhonTxtView.append(" " + mUsrModel.address.zipcode);
      //    holder.mContrainerItm.setOnClickListener(new View.OnClickListener() {
        //                @Override
        //                public void onClick(View v) {
        //                    int mIndex = (int)v.getTag();
        //                    UsersModel mUsrModelObj = mUserLstItems.get(mIndex);
        //                    int mUsrId = mUsrModelObj.id;
        //                    mCallBkItm.navigationToDetailse(v, mUsrId);
        //                }
        //            });
    }

    @Override
    public int getItemCount() {
        return mUserLstItems.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitleTxtView;
        TextView mDescriptionTxtView;
        TextView mPhonTxtView;
        LinearLayout mContrainerItm;
        ViewHolder(View itemView) {
            super(itemView);

            mTitleTxtView = itemView.findViewById(R.id.titleItem);
            mDescriptionTxtView = itemView.findViewById(R.id.descripItem);
            mPhonTxtView = itemView.findViewById(R.id.phoneItem);
            mContrainerItm = itemView.findViewById(R.id.linearContainer);

            mContrainerItm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mIndex = (int)v.getTag();
                    UsersModel mUsrModelObj = mUserLstItems.get(mIndex);
                    int mUsrId = mUsrModelObj.id;
                    mCallBkItm.navigationToDetailse(v, mUsrId);
                }
            });
        }
    }

}
