package com.example.usuario.inventory.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 30/10/17.
 */

public class Sector implements Parcelable{
    private int _ID;
    private String name;
    private String shortName;
    private String depcription;
    private int dependencyId;
    private boolean enable;
    private boolean defaultState;



    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDepcription() {
        return depcription;
    }

    public void setDepcription(String depcription) {
        this.depcription = depcription;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isDefaultState() {
        return defaultState;
    }

    public void setDefaultState(boolean defaultState) {
        this.defaultState = defaultState;
    }

    public Sector(int _ID, String name, String shortName, String depcription, int dependencyId, boolean enable, boolean defaultState) {
        this._ID = _ID;
        this.name = name;
        this.shortName = shortName;
        this.depcription = depcription;
        this.dependencyId = dependencyId;
        this.enable = enable;
        this.defaultState = defaultState;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", depcription='" + depcription + '\'' +
                ", dependencyId=" + dependencyId +
                ", enable=" + enable +
                ", defaultState=" + defaultState +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(shortName);
        dest.writeString(depcription);
        dest.writeInt(dependencyId);
        dest.writeByte((byte) (enable ? 1 : 0));
        dest.writeByte((byte) (defaultState ? 1 : 0));
    }

    protected Sector(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortName = in.readString();
        depcription = in.readString();
        dependencyId = in.readInt();
        enable = in.readByte() != 0;
        defaultState = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

}
