package com.spark.cong.ic3spark.models;

import android.os.Parcel;
import android.os.Parcelable;

public class LythuyetChild implements Parcelable {
    public final String name;
    public final String document;

    public LythuyetChild(String name, String document){
        this.name=name;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    protected LythuyetChild(Parcel in) {
        name = in.readString();
        document = in.readString();
    }

    public static final Creator<LythuyetChild> CREATOR = new Creator<LythuyetChild>() {
        @Override
        public LythuyetChild createFromParcel(Parcel in) {
            return new LythuyetChild(in);
        }

        @Override
        public LythuyetChild[] newArray(int size) {
            return new LythuyetChild[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(document);
    }
}
