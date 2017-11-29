package com.example.usuario.inventoryfragment.pojo;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Clase que guarda la informacion de dependencias
 */


public class Dependency implements Comparable<Dependency>{
    private int _ID;
    private  String name;
    private  String shortname;
    private String description;

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

    public static class OrderByShortName implements Comparator<Dependency>{
        @Override
        public int compare(Dependency dependency1, Dependency dependency2) {
            return dependency1.getShortname().compareTo(dependency2.getShortname());
        }
    }
}