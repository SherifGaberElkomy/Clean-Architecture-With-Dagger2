package com.motorgy.myapplication.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressModel implements Parcelable {

    @SerializedName("street")
    @Expose
    public String street = "";

    @SerializedName("suite")
    @Expose
    public String suite = "";

    @SerializedName("city")
    @Expose
    public String city = "";

    @SerializedName("zipcode")
    @Expose
    public String zipcode = "";

    @SerializedName("geo")
    @Expose
    public Geo geo;


    protected AddressModel(Parcel in) {
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipcode = in.readString();
        geo = in.readParcelable(Geo.class.getClassLoader());
    }

    public static final Creator<AddressModel> CREATOR = new Creator<AddressModel>() {
        @Override
        public AddressModel createFromParcel(Parcel in) {
            return new AddressModel(in);
        }

        @Override
        public AddressModel[] newArray(int size) {
            return new AddressModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(street);
        dest.writeString(suite);
        dest.writeString(city);
        dest.writeString(zipcode);
        dest.writeParcelable(geo, flags);
    }
}
