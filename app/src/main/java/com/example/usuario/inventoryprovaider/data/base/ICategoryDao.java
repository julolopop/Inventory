package com.example.usuario.inventoryprovaider.data.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventoryprovaider.data.db.model.InventoryContract;
import com.example.usuario.inventoryprovaider.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventoryprovaider.pojo.Category;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ICategoryDao {

    ArrayList<Category> loadAll();

    long add(Category category) ;



    ContentValues createContent(Category category) ;

}
