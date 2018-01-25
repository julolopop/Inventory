package com.example.usuario.inventorydb.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.example.usuario.inventorydb.data.db.model.InventoryContract;
import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventorydb.pojo.Dependency;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {



    public ArrayList<Dependency> loadAll(){
        ArrayList<Dependency> arrayList = new ArrayList<>();

        Cursor c = InventoryOpenHelper.newInstance().openDatabase().query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                null,null,null,null,
                InventoryContract.DependencyEntry.DEFAULT_ORDER);
        if (c != null) {
            while (c.moveToNext()) {
                arrayList.add(new Dependency(c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3),c.getString(4)));
            }
        }

        return arrayList;

    }


    public int update(Dependency dependencia) {
        int estado;

        String whereClasure = BaseColumns._ID+"=?";
        String[] whereArgs = new String[]{""+dependencia.get_ID()};


        estado =InventoryOpenHelper.newInstance().openDatabase().update(InventoryContract.DependencyEntry.TABLE_NAME,contentValues(dependencia),whereClasure,whereArgs);

        InventoryOpenHelper.newInstance().closeDatabase();

        return estado;
    }

    private ContentValues contentValues(Dependency dependencia) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(InventoryContract.DependencyEntry._ID,dependencia.get_ID());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME,dependencia.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME,dependencia.getShortname());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION,dependencia.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME,dependencia.getImage());

        return contentValues;
    }
}
