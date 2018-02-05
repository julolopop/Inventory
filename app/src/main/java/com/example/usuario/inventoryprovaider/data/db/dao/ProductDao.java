package com.example.usuario.inventoryprovaider.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.usuario.inventoryprovaider.data.db.model.InventoryContract;
import com.example.usuario.inventoryprovaider.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventoryprovaider.pojo.Productos;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {
    /**
     * Método que devuelve un cursor con todas las dependencias
     * de la BD.
     * Se le podrían pasar todos los parámetros
     *
     * @return
     */
    //public Observable<ArrayList<Dependency>> loadAll() <-- Usando ReactiveX
    public ArrayList<Productos> loadAll() {
        ArrayList<Productos> products = new ArrayList<>();
        SQLiteDatabase db = InventoryOpenHelper.newInstance().openDatabase();

        //rawQuery interpreta el comando usando '?' en la consulta.
        //A medio camino entre SQL y SQLite
        Cursor cursor = db.query(
                InventoryContract.ProductEntry.TABLE_NAME,
                InventoryContract.ProductEntry.ALL_COLUMNS,
                null, null, null, null,
                null, null
        );
        if (cursor.moveToFirst()) {
            do {
                products.add(new Productos(
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5),
                                cursor.getInt(6),
                                cursor.getInt(7),
                                cursor.getInt(8),
                                cursor.getInt(9),
                                cursor.getFloat(10),
                                cursor.getString(11),
                                cursor.getInt(12),
                                cursor.getString(13),
                                cursor.getString(14),
                                cursor.getString(15),
                                cursor.getString(16)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.newInstance().closeDatabase();
        return products;
    }

    /**
     * Método que añade una dependencia en la base de datos
     *
     * @param product Producto que se añade
     * @return Devuelve el id del nuevo elemento que se ha insertado
     */
    public long add(Productos product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
        //nullColumnHack crea filas sólo con id para evitar errores
        //por clave ajena, pero no lo vamos a usar
        long id = sqLiteDatabase.insert(
                InventoryContract.ProductEntry.TABLE_NAME,
                null,
                createContent(product)
        );
        InventoryOpenHelper.newInstance().closeDatabase();
        return id;
    }

    public int delete(Productos product) {
        int result;
        try {
            SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
            String[] whereArgs = new String[]{product.get_ID() + ""};
            result = sqLiteDatabase.delete(
                    InventoryContract.ProductEntry.TABLE_NAME,
                    InventoryContract.ProductEntry._ID,
                    whereArgs
            );
            return result;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int update(Productos product) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.newInstance().openDatabase();
        String[] whereArgs = new String[]{"" + product.get_ID()};
        int updatedRows = sqLiteDatabase.update(
                InventoryContract.ProductEntry.TABLE_NAME,
                createContent(product),
                null,
                null
        );
        InventoryOpenHelper.newInstance().closeDatabase();
        return updatedRows;
    }


    public ContentValues createContent(Productos product) {
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.ProductEntry._ID, product.getDependencyId());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_SERIAL, product.getDatePurchase());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_MODELCODE, product.getModelCode());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_SORTNAME, product.getShortname());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_DESCRIPTION, product.getDescription());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_CATEGORYID, product.getCategory());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_PRODUCTCLASS, product.getProductClass());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_SECTOR, product.getSectorID());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_QUANTITY, product.getQuantity());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_VALUE, product.getValue());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_VENDOR, product.getVendor());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_BITMAP, product.getBitmap());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_IMAGENAME, product.getImageName());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_URL, product.getUrl());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_DATEPURCHASE, product.getDatePurchase());
        contentValues.put(InventoryContract.ProductEntry.COLUMN_NOTES, product.getNotes());
        return contentValues;
    }

    public ArrayList<Productos> loadProducto(String shortName) {
        ArrayList<Productos> products = new ArrayList<>();
        SQLiteDatabase db = InventoryOpenHelper.newInstance().openDatabase();


        String[] args =new String[]{shortName};

        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(InventoryContract.ProductInnerEntry.PRODUCT_INNER);
        sqLiteQueryBuilder.setProjectionMap(InventoryContract.ProductInnerEntry.sProductInnerProjectionMap);

        String selection = InventoryContract.ProductInnerEntry.TABLE_NAME+"."+InventoryContract.ProductInnerEntry.COLUMN_DESCRIPTION+"=?";

        // 1. Vamos a mostrar si la consulta es correcta
        Cursor cursor = sqLiteQueryBuilder.query(
                db,
                InventoryContract.ProductInnerEntry.ALL_COLUMNS,
                selection,
                args,
                null,
                null,
                null,
                null
        );



        if (cursor.moveToFirst()) {
            do {
                products.add(new Productos(
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5),
                                cursor.getInt(6),
                                cursor.getInt(7),
                                cursor.getInt(8),
                                cursor.getInt(9),
                                cursor.getFloat(10),
                                cursor.getString(11),
                                cursor.getInt(12),
                                cursor.getString(13),
                                cursor.getString(14),
                                cursor.getString(15),
                                cursor.getString(16)
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.newInstance().closeDatabase();
        return products;
    }
}
