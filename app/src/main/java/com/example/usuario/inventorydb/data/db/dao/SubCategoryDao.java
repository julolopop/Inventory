package com.example.usuario.inventorydb.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventorydb.data.db.model.InventoryContract;
import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventorydb.pojo.Category;
import com.example.usuario.inventorydb.pojo.SubCategory;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class SubCategoryDao {

    public ArrayList<SubCategory> loadAll() {
        ArrayList<SubCategory> subCategories = new ArrayList<>();
        SQLiteDatabase db = InventoryOpenHelper.newInstance().openDatabase();

        //rawQuery interpreta el comando usando '?' en la consulta.
        //A medio camino entre SQL y SQLite
        Cursor cursor = db.query(
                InventoryContract.SubcategoryEntry.TABLE_NAME,
                InventoryContract.SubcategoryEntry.ALL_COLUMNS,
                null, null, null, null,
                null, null
        );
        if (cursor.moveToFirst()) {
            do {

                subCategories.add(new SubCategory(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.newInstance().closeDatabase();
        return subCategories;
    }

    public long add(SubCategory subCategory) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
        //nullColumnHack crea filas sólo con id para evitar errores
        //por clave ajena, pero no lo vamos a usar
        long id = sqLiteDatabase.insert(
                InventoryContract.SubcategoryEntry.TABLE_NAME,
                null,
                createContent(subCategory)
        );
        InventoryOpenHelper.newInstance().closeDatabase();
        return id;
    }



    public ContentValues createContent(SubCategory subCategory) {
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.CategoryEntry._ID, subCategory.get_id());
        contentValues.put(InventoryContract.CategoryEntry.COLUMN_NAME, subCategory.getName());
        contentValues.put(InventoryContract.CategoryEntry.COLUMN_SORTNAME, subCategory.getSortname());
        contentValues.put(InventoryContract.CategoryEntry.COLUMN_DESCRIPTION, subCategory.getDescription());

        return contentValues;
    }


}
