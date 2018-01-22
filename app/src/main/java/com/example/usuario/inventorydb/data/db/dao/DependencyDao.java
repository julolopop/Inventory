package com.example.usuario.inventorydb.data.db.dao;

import android.database.Cursor;

import com.example.usuario.inventorydb.data.db.model.InventoryContract;
import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {

    public Cursor loadAll(){
        return InventoryOpenHelper.newInstance().openDatabase().query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                null,null,null,null,
                InventoryContract.DependencyEntry.DEFAULT_ORDER);
    }
}
