package com.example.usuario.inventoryprovaider.data.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.usuario.inventoryprovaider.data.db.model.InventoryContract;
import com.example.usuario.inventoryprovaider.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventoryprovaider.pojo.Productos;
import com.example.usuario.inventoryprovaider.pojo.ProductosInner;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface IProductDao {

    ArrayList<Productos> loadAll();

    long add(Productos product);

    int delete(Productos product);

    int update(Productos product);

    ContentValues createContent(Productos product);

    ArrayList<ProductosInner> loadProducto(String shortName);
}
