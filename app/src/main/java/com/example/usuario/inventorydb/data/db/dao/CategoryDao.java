package com.example.usuario.inventorydb.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventorydb.data.db.model.InventoryContract;
import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventorydb.pojo.Category;
import com.example.usuario.inventorydb.pojo.Productos;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class CategoryDao {

    public ArrayList<Category> loadAll() {
        ArrayList<Category> categories = new ArrayList<>();
        SQLiteDatabase db = InventoryOpenHelper.newInstance().openDatabase();

        //rawQuery interpreta el comando usando '?' en la consulta.
        //A medio camino entre SQL y SQLite
        Cursor cursor = db.query(
                InventoryContract.CategoryEntry.TABLE_NAME,
                InventoryContract.CategoryEntry.ALL_COLUMNS,
                null, null, null, null,
                null, null
        );
        if (cursor.moveToFirst()) {
            do {

                categories.add(new Category(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.newInstance().closeDatabase();
        return categories;
    }

    public long add(Category category) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
        //nullColumnHack crea filas sólo con id para evitar errores
        //por clave ajena, pero no lo vamos a usar
        long id = sqLiteDatabase.insert(
                InventoryContract.CategoryEntry.TABLE_NAME,
                null,
                createContent(category)
        );
        InventoryOpenHelper.newInstance().closeDatabase();
        return id;
    }



    public ContentValues createContent(Category category) {
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.CategoryEntry._ID, category.get_id());
        contentValues.put(InventoryContract.CategoryEntry.COLUMN_NAME, category.getName());
        contentValues.put(InventoryContract.CategoryEntry.COLUMN_SORTNAME, category.getSortname());
        contentValues.put(InventoryContract.CategoryEntry.COLUMN_DESCRIPTION, category.getDescription());

        return contentValues;
    }


}
