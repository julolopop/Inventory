package com.example.usuario.inventoryprovaider.data.db.repository;

import com.example.usuario.inventoryprovaider.data.db.dao.DependencyDao;
import com.example.usuario.inventoryprovaider.pojo.Dependency;
import com.example.usuario.inventoryprovaider.pojo.Dependency.OrderByID;
import com.example.usuario.inventoryprovaider.pojo.Dependency.OrderByShortName;
import com.example.usuario.inventoryprovaider.ui.InteractorCallback;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Creacion del array de Dependencias
 */

public class DependencyRepository {
    //declaración
    private static DependencyRepository mInstance;
    private DependencyDao mDao;


    private DependencyRepository() {
        this.mDao = new DependencyDao();
    }


    public static DependencyRepository getInstance() {
        if (mInstance == null)
            mInstance = new DependencyRepository();

        return mInstance;
    }


    public ArrayList<Dependency> getDependencies() {
        return mDao.loadAll();
    }


    public ArrayList<Dependency> getDependenciesOrderByName() {
        ArrayList<Dependency> dependencies = mDao.loadAll();
        Collections.sort(dependencies, new OrderByShortName());
        return dependencies;
    }


    public ArrayList<Dependency> getDependenciesOrderByID() {
        ArrayList<Dependency> dependencies = mDao.loadAll();
        Collections.sort(dependencies, new OrderByID());
        return dependencies;
    }


    public void addDependency(Dependency dependency,  InteractorCallback callback) {
        long id = mDao.add(dependency);
        Error error = new Error();

        if (id == -1)
            callback.onError(error);
        else
            callback.onSuccess();
    }


    public boolean validateDependency(String name, String sortname) {
        return mDao.exists(name, sortname);
    }


    public void editDependency(Dependency dependency, InteractorCallback callback) {
        int rows = mDao.update(dependency);
        Error error = new Error();

        if (rows == 0)
            callback.onError(error);
        else
            callback.onSuccess();
    }


    public void deleteDependency(Dependency dependency, InteractorCallback callback) {
        int rows = mDao.delete(dependency);
        Error error = new Error();

        if (rows == 0)
            callback.onError(error);
        else
            callback.onSuccess();
    }


}
