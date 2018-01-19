package com.example.usuario.inventorydb.data.db.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.usuario.inventorydb.InventoryApplication;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {
    static InventoryOpenHelper singleton;
    private InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null, InventoryContract.DATABASE_VERSION);
    }

    public static InventoryOpenHelper newInstance() {
        if(singleton == null)
         singleton = new InventoryOpenHelper();
        return singleton;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
    }

    public void crear(SQLiteDatabase db){
        onUpgrade(db,1,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                db.setForeignKeyConstraintsEnabled(true);
            }else{
                db.execSQL("PRAGMA foreign_key=1");
            }
        }

    }
}
