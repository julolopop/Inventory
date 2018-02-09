package com.example.usuario.inventoryprovaider.data.db.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.usuario.inventoryprovaider.InventoryApplication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {
    static InventoryOpenHelper singleton;
    private volatile SQLiteDatabase sqLiteDatabase;
    private AtomicInteger openCounter = new AtomicInteger();

    public synchronized SQLiteDatabase openDatabase() {
        if(openCounter.incrementAndGet() == 1)
            sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase;
    }
    public synchronized void closeDatabase() {
        if(openCounter.decrementAndGet() == 0)
            sqLiteDatabase.close();
    }

    private InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null, InventoryContract.DATABASE_VERSION);
    }

    public  synchronized static InventoryOpenHelper newInstance() {
        if(singleton == null)
         singleton = new InventoryOpenHelper();
        return singleton;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.ProductEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.ProductClassEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.CategoryEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.SubcategoryEntry.SQL_CREATE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.ProductEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.ProductClassEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.CategoryEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.SubcategoryEntry.SQL_INSERT_ENTRIES);
    }

    public void crear(SQLiteDatabase db){
        onUpgrade(db,1,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.ProductEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.ProductClassEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.CategoryEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.SubcategoryEntry.SQL_DELETE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.ProductEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.ProductClassEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.CategoryEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.SubcategoryEntry.SQL_CREATE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.ProductEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.ProductClassEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.CategoryEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.SubcategoryEntry.SQL_INSERT_ENTRIES);
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