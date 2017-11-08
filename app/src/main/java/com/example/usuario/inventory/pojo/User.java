package com.example.usuario.inventory.pojo;

/**
 * Created by usuario on 8/11/17.
 */

public class User {
    private int _ID;
    private String user;
    private String password;
    private String name;
    private String mail;
    private boolean root;
    private boolean management;
    //private ArrayList<Permission> permissions;

    public User(int _ID, String user, String password, String name, String mail, boolean root, boolean management) {
        this._ID = _ID;
        this.user = user;
        this.password = password;
        this.name = name;
        this.mail = mail;
        this.root = root;
        this.management = management;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public boolean isManagement() {
        return management;
    }

    public void setManagement(boolean management) {
        this.management = management;
    }
}
