package com.example.usuario.inventoryprovaider.data.dao;

import com.example.usuario.inventoryprovaider.data.base.IDependencyDao;
import com.example.usuario.inventoryprovaider.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDao implements IDependencyDao {

    @Override
    public ArrayList<Dependency> loadAll() {
        return null;
    }

    @Override
    public boolean exists(String name, String sortname) {
        return false;
    }

    @Override
    public long add(Dependency dependency) {
        return 0;
    }

    @Override
    public int delete(Dependency dependency) {
        return 0;
    }

    @Override
    public int update(Dependency dependency) {
        return 0;
    }
}
