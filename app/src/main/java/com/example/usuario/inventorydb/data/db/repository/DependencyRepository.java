package com.example.usuario.inventorydb.data.db.repository;

import android.database.Cursor;

import com.example.usuario.inventorydb.data.db.dao.DependencyDao;
import com.example.usuario.inventorydb.pojo.Dependency;
import com.example.usuario.inventorydb.ui.Dependency.Interactor.AddDependencyInteractor;

import java.util.ArrayList;

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


    public interface OnDependencyRepository{
        void onSusses();
        void onError();
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

    public ArrayList<Dependency> getDependencies() {
        return dependencyDao.loadAll();
    }


    /**
     * Metodo que añade una dependencia
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
    }


    public void editDependency(Dependency dependencia,OnDependencyRepository callback) {
        int estado;
        estado = this.dependencyDao.update(dependencia);

       if(estado == 0)
            callback.onSusses();
        else
            callback.onError();

    }


    public void deleteDependency(Dependency dependencia) {

    }

    public boolean validateDependency(String name, String sortname) {
        return true;
    }

}
