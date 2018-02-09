package com.example.usuario.inventoryprovaider.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventoryprovaider.data.base.IDependencyDao;
import com.example.usuario.inventoryprovaider.data.db.model.InventoryContract;
import com.example.usuario.inventoryprovaider.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventoryprovaider.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao implements IDependencyDao {


    ArrayList<Dependency> mDependencies;



    public ArrayList<Dependency> loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
        mDependencies = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,InventoryContract.DependencyEntry.ALL_COLUMN,
                null,null,null,null,InventoryContract.DependencyEntry.ORDER_BY,null);

        if(cursor.moveToFirst()){
            do{
                Dependency dependency = new Dependency(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3),
                        cursor.getString(4));
                mDependencies.add(dependency);
            } while(cursor.moveToNext());
        }


        InventoryOpenHelper.newInstance().closeDatabase();
        return mDependencies;
    }


    public boolean exists(String name, String sortname) {
        boolean result = true;
        int index = 0;

        while (index < mDependencies.size()) {
            if (name.equals(mDependencies.get(index).getName()) || sortname.equals(mDependencies.get(index).getShortname())) {
                result = false;
                index = mDependencies.size();
            } else
                index++;
        }

        return result;
    }


    /**
     * Añade un objeto dependency en la base de datos.
     * @param dependency
     * @return
     */
    public long add(Dependency dependency) {
        SQLiteDatabase database = InventoryOpenHelper.newInstance().openDatabase();
        ContentValues values = new ContentValues();
        long id;

        values.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        values.put(InventoryContract.DependencyEntry.COLUMN_SORTNAME, dependency.getShortname());
        values.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        values.put(InventoryContract.DependencyEntry.COLUMN_IMAGE, dependency.getImage());

        id = database.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, values);
        InventoryOpenHelper.newInstance().closeDatabase();

        return id;
    }


    public int delete(Dependency dependency) {
        SQLiteDatabase database = InventoryOpenHelper.newInstance().openDatabase();
        String whereClause = InventoryContract.DependencyEntry._ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(dependency.get_ID())};
        int rows;

        rows = database.delete(InventoryContract.DependencyEntry.TABLE_NAME, whereClause, whereArgs);
        InventoryOpenHelper.newInstance().closeDatabase();

        return rows;
    }


    public int update(Dependency dependency) {
        SQLiteDatabase database = InventoryOpenHelper.newInstance().openDatabase();
        ContentValues values = new ContentValues();
        String whereClause = InventoryContract.DependencyEntry._ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(dependency.get_ID())};
        int rows;

        values.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        values.put(InventoryContract.DependencyEntry.COLUMN_SORTNAME, dependency.getShortname());
        values.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        values.put(InventoryContract.DependencyEntry.COLUMN_IMAGE, dependency.getImage());

        rows = database.update(InventoryContract.DependencyEntry.TABLE_NAME, values, whereClause, whereArgs);
        InventoryOpenHelper.newInstance().closeDatabase();

        return rows;
    }

}