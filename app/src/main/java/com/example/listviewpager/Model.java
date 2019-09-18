package com.example.listviewpager;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private int image;
    private String title;
    private String desc;

    protected Model(Parcel in) {
        image = in.readInt();
        title = in.readString();
        desc = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Model(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(desc);
    }
}
