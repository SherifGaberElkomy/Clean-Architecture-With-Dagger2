package com.motorgy.myapplication.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersModel implements Parcelable {


    @SerializedName("id")
    @Expose
    public int id = 0;

    @SerializedName("name")
    @Expose
    public String name = "";

    @SerializedName("username")
    @Expose
    public String userName = "";

    @SerializedName("email")
    @Expose
    public String email = "";

    @SerializedName("address")
    @Expose
    public AddressModel address;


    protected UsersModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        userName = in.readString();
        email = in.readString();
        address = in.readParcelable(AddressModel.class.getClassLoader());
    }

    public static final Creator<UsersModel> CREATOR = new Creator<UsersModel>() {
        @Override
        public UsersModel createFromParcel(Parcel in) {
            return new UsersModel(in);
        }

        @Override
        public UsersModel[] newArray(int size) {
            return new UsersModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(userName);
        dest.writeString(email);
        dest.writeParcelable(address, flags);
    }
}
