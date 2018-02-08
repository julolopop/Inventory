package com.example.usuario.inventoryprovaider.data.provaider.dao;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.usuario.inventoryprovaider.InventoryApplication;
import com.example.usuario.inventoryprovaider.data.base.IDependencyDao;
import com.example.usuario.inventoryprovaider.data.provaider.InventoryProvaider;
import com.example.usuario.inventoryprovaider.data.provaider.InventoryProvaiderContract;
import com.example.usuario.inventoryprovaider.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDao implements IDependencyDao {

    @Override
    public ArrayList<Dependency> loadAll() {
        ArrayList<Dependency> list = new ArrayList<>();

        String[] projection = new String[]{
                InventoryProvaiderContract.Dependency._ID,
                InventoryProvaiderContract.Dependency.NAME,
                InventoryProvaiderContract.Dependency.SORTNAME,
                InventoryProvaiderContract.Dependency.DESCRIPTION,
                InventoryProvaiderContract.Dependency.IMAGE
        };

        //String projection = InventoryProvaiderContract.Dependency.ALL_COLUMNS;


        ContentResolver cr =  InventoryApplication.getContext().getContentResolver();

        Cursor cursor = cr.query(InventoryProvaiderContract.Dependency.CONTENT_URI, projection, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Dependency dependency = new Dependency(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4));
                list.add(dependency);
            } while (cursor.moveToNext());
        }


        return list;
    }


    public ContentValues createContent(Dependency dependency) {
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryProvaiderContract.Dependency._ID, dependency.get_ID());
        contentValues.put(InventoryProvaiderContract.Dependency.NAME, dependency.getName());
        contentValues.put(InventoryProvaiderContract.Dependency.SORTNAME, dependency.getShortname());
        contentValues.put(InventoryProvaiderContract.Dependency.DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryProvaiderContract.Dependency.IMAGE, dependency.getDescription());

        return contentValues;
    }


    @Override
    public boolean exists(String name, String sortname) {

        String selection = InventoryProvaiderContract.Dependency.NAME + "=?," + InventoryProvaiderContract.Dependency.SORTNAME + "=?";
        String[] args = {name, sortname};

        ContentResolver cr = InventoryApplication.getContext().getContentResolver();

        Cursor cursor = cr.query(InventoryProvaiderContract.Dependency.CONTENT_URI, InventoryProvaiderContract.Dependency.ALL_COLUMNS
                , selection, args, null);


        if (cursor == null)
            return false;
        else
            return true;
    }

    @Override
    public long add(Dependency dependency) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();

        Uri uri = cr.insert(InventoryProvaiderContract.Dependency.CONTENT_URI, createContent(dependency));

        if (uri == null)
            return -1;

        return Long.parseLong(uri.getLastPathSegment());
    }

    @Override
    public int delete(Dependency dependency) {
        return 0;
    }

    @Override
    public int update(Dependency dependency) {
        return 0;
    }
}
