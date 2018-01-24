package com.example.usuario.inventorydb.data.db.dao;

import android.database.Cursor;

import com.example.usuario.inventorydb.data.db.model.InventoryContract;
import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventorydb.pojo.Dependency;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by usuario on 22/01/18.
 */

public class DependencyDao {



    public ArrayList<Dependency> loadAll(){
        ArrayList<Dependency> arrayList = new ArrayList<>();

        Cursor c = InventoryOpenHelper.newInstance().openDatabase().query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                null,null,null,null,
                InventoryContract.DependencyEntry.DEFAULT_ORDER);
        if (c != null) {
            while (c.moveToNext()) {
                arrayList.add(new Dependency(c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3),c.getString(4)));
            }
        }

        return arrayList;

    }


}
