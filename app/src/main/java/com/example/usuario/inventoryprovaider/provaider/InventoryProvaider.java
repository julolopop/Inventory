package com.example.usuario.inventoryprovaider.provaider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.usuario.inventoryprovaider.data.db.model.InventoryContract;
import com.example.usuario.inventoryprovaider.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 7/02/18.
 */

public class InventoryProvaider extends ContentProvider {

    public static final int PRODUCT = 1;
    public static final int PRODUCT_ID = 2;
    public static final int DEPENDENCY = 3;
    public static final int DEPENDENCY_ID= 4;
    public static final int SECTOR = 5;
    public static final int SECTOR_ID = 6;

    public static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(InventoryProvaiderContract.AUTHORITY,InventoryProvaiderContract.Product.CONTENT_PATH,PRODUCT);
        URI_MATCHER.addURI(InventoryProvaiderContract.AUTHORITY,InventoryProvaiderContract.Product.CONTENT_PATH+"/#",PRODUCT_ID);

        URI_MATCHER.addURI(InventoryProvaiderContract.AUTHORITY,InventoryProvaiderContract.Dependency.CONTENT_PATH,DEPENDENCY);
        URI_MATCHER.addURI(InventoryProvaiderContract.AUTHORITY,InventoryProvaiderContract.Dependency.CONTENT_PATH+"/#",DEPENDENCY_ID);

        URI_MATCHER.addURI(InventoryProvaiderContract.AUTHORITY,InventoryProvaiderContract.Sector.CONTENT_PATH,SECTOR);
        URI_MATCHER.addURI(InventoryProvaiderContract.AUTHORITY,InventoryProvaiderContract.Sector.CONTENT_PATH+"/#",SECTOR_ID);

    }

    SQLiteDatabase sqLiteDatabase;

    @Override
    public boolean onCreate() {
        sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (URI_MATCHER.match(uri)){
            case PRODUCT:
                break;
            case PRODUCT_ID:
                break;
            case DEPENDENCY:
                sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case DEPENDENCY_ID:
                break;
            case SECTOR:
                break;
            case SECTOR_ID:
                break;

        }

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
