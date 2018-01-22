package com.example.usuario.inventorydb.data.db.repository;

import android.database.Cursor;

import com.example.usuario.inventorydb.data.db.dao.DependencyDao;
import com.example.usuario.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.usuario.inventorydb.pojo.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Creacion del array de Dependencias
 */

public class DependencyRepository {
    //declaración
    DependencyDao dependencyDao;
    ArrayList<Dependency> dependencies;

    private static DependencyRepository dependencyRepository;
    static {
        dependencyRepository = new DependencyRepository();
    }

    /**
     * El metodo tiene que se privado para asegurar que siempre se ejecute
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        this.dependencyDao = new DependencyDao();
    }



    //patrón sigletón
    public static DependencyRepository getInstance() {
        if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }

    /**
     * Metodo que añade una dependencia
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies() {
        dependencies.clear();
        Cursor c = getDependencyDao();

        if (c != null) {
            while (c.moveToNext()) {
                addDependency(new Dependency(c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3),c.getString(4)));
            }
        }

        return dependencies;
    }

    public Cursor getDependencyDao(){
        return dependencyDao.loadAll();
    }

    public void editDependency(Dependency dependencia) {


    }


    public void deleteDependency(Dependency dependencia) {

    }

    public boolean validateDependency(String name, String sortname) {
        return true;
    }

}
