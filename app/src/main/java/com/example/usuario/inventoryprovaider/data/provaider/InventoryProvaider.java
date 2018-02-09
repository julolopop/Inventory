package com.example.usuario.inventoryprovaider.data.provaider;

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

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;

        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;

            case PRODUCT_ID:
                break;

            case DEPENDENCY:
                cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME, projection,selection,
                        selectionArgs, null, null, sortOrder);
                break;

            case DEPENDENCY_ID:
                break;

            case SECTOR:
                cursor = sqLiteDatabase.query(InventoryContract.SectorEntry.TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;

            case SECTOR_ID:
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return cursor;
    }


    @Override
    public String getType(Uri uri) {
        String result = "";

        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                result = "vnd.android.cursor.dir/vnd.com.example.usuario.inventoryprovaider/" +
                        InventoryProvaiderContract.Product.CONTENT_PATH;
                break;

            case PRODUCT_ID:
                result = "vnd.android.cursor.item/vnd.com.example.usuario.inventoryprovaider/" +
                        InventoryProvaiderContract.Product.CONTENT_PATH;
                break;

            case DEPENDENCY:
                result = "vnd.android.cursor.dir/vnd.com.example.usuario.inventoryprovaider/" +
                        InventoryProvaiderContract.Dependency.CONTENT_PATH;
                break;

            case DEPENDENCY_ID:
                result = "vnd.android.cursor.item/vnd.com.example.usuario.inventoryprovaider/" +
                        InventoryProvaiderContract.Dependency.CONTENT_PATH;
                break;

            case SECTOR:
                result = "vnd.android.cursor.dir/vnd.com.example.usuario.inventoryprovaider/" +
                        InventoryProvaiderContract.Sector.CONTENT_PATH;
                break;

            case SECTOR_ID:
                result = "vnd.android.cursor.item/vnd.com.example.usuario.inventoryprovaider/" +
                        InventoryProvaiderContract.Sector.CONTENT_PATH;
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return result;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri result = null;
        long rows = 0;

        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                rows = sqLiteDatabase.insert(InventoryContract.ProductEntry.TABLE_NAME, null, values);
                break;

            case DEPENDENCY:
                rows = sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, values);
                result = Uri.parse(InventoryProvaiderContract.AUTHORITY + InventoryProvaiderContract.Dependency.CONTENT_URI +
                        "/" + rows);
                break;

            case SECTOR:
                rows = sqLiteDatabase.insert(InventoryContract.SectorEntry.TABLE_NAME, null, values);
                result = Uri.parse(InventoryProvaiderContract.AUTHORITY + InventoryProvaiderContract.Sector.CONTENT_URI +
                        "/" + rows);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return result;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rows = 0;

        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                rows = sqLiteDatabase.delete(InventoryContract.ProductEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case DEPENDENCY:
                rows = sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case SECTOR:
                rows = sqLiteDatabase.delete(InventoryContract.SectorEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return rows;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int rows = 0;

        switch (URI_MATCHER.match(uri)) {
            case PRODUCT:
                rows = sqLiteDatabase.update(InventoryContract.ProductEntry.TABLE_NAME, values, selection, selectionArgs);
                break;

            case DEPENDENCY:
                rows = sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, values, selection, selectionArgs);
                break;

            case SECTOR:
                rows = sqLiteDatabase.update(InventoryContract.SectorEntry.TABLE_NAME, values, selection, selectionArgs);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return rows;
    }
}
