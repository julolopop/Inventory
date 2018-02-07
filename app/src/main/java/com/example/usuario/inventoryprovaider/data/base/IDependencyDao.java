package com.example.usuario.inventoryprovaider.data.base;

import com.example.usuario.inventoryprovaider.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public interface IDependencyDao {
    ArrayList<Dependency> loadAll();

    boolean exists(String name, String sortname);
    long add(Dependency dependency);
    int delete(Dependency dependency);
    int update(Dependency dependency);
}
