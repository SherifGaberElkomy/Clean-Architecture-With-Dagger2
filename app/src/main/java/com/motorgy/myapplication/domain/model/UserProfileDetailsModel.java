package com.motorgy.myapplication.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileDetailsModel implements Parcelable {

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

    @SerializedName("company")
    @Expose
    public Company company;


    protected UserProfileDetailsModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        userName = in.readString();
        email = in.readString();
        address = in.readParcelable(AddressModel.class.getClassLoader());
        company = in.readParcelable(Company.class.getClassLoader());
    }

    public static final Creator<UserProfileDetailsModel> CREATOR = new Creator<UserProfileDetailsModel>() {
        @Override
        public UserProfileDetailsModel createFromParcel(Parcel in) {
            return new UserProfileDetailsModel(in);
        }

        @Override
        public UserProfileDetailsModel[] newArray(int size) {
            return new UserProfileDetailsModel[size];
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
        dest.writeParcelable(company, flags);
    }
}
