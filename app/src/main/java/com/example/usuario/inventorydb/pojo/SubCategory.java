package com.example.usuario.inventorydb.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 2/02/18.
 */

public class SubCategory implements Parcelable{
    private int _id;
    private String name;
    private String sortname;
    private String description;

    @Override
    public String toString() {
        return name;
    }

    public SubCategory(int _id, String name, String sortname, String description) {
        this._id = _id;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }


    public SubCategory(String name, String sortname, String description) {
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }


    protected SubCategory(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
    }


    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>() {
        @Override
        public SubCategory createFromParcel(Parcel in) {
            return new SubCategory(in);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
        dest.writeString(sortname);
        dest.writeString(description);
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}