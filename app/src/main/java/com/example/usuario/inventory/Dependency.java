package com.example.usuario.inventory;

/**
 * Created by usuario on 25/10/17.
 */

class Dependency {
    private int _ID;
    private String name;
    private String shortname;
    private String descripcion;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dependency(int _ID, String name, String shortname, String descripcion) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
