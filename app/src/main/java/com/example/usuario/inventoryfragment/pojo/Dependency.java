package com.example.usuario.inventoryfragment.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Clase que guarda la informacion de dependencias
 */


public class Dependency implements Comparable<Dependency>,Parcelable{
    private int _ID;
    private  String name;
    private  String shortname;
    private String description;

    protected Dependency(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
    }

    public static final Creator<Dependency> CREATOR = new Creator<Dependency>() {
        @Override
        public Dependency createFromParcel(Parcel in) {
            return new Dependency(in);
        }

        @Override
        public Dependency[] newArray(int size) {
            return new Dependency[size];
        }
    };

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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dependency(int _ID, String name, String shortname, String description) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dependency)) return false;

        Dependency that = (Dependency) o;

        if (!getName().equals(that.getName())) return false;
        return getShortname().equals(that.getShortname());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getShortname().hashCode();
        return result;
    }

    @Override
    public int compareTo(@NonNull Dependency dependency) {
        return name.compareTo(dependency.name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(shortname);
        dest.writeString(description);
    }

    public static class OrderByShortName implements Comparator<Dependency>{
        @Override
        public int compare(Dependency dependency1, Dependency dependency2) {
            return dependency1.getShortname().compareTo(dependency2.getShortname());
        }
    }
    public static class OrderByID implements Comparator<Dependency>{
        @Override
        public int compare(Dependency dependency1, Dependency dependency2) {
            return dependency1.get_ID() == dependency2.get_ID()?0:
                    dependency1.get_ID() < dependency2.get_ID()?1:-1;
        }
    }
}