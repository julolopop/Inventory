package com.example.usuario.inventoryfragment.data.repository;

import com.example.usuario.inventoryfragment.pojo.Dependency;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Creacion del array de Dependencias
 */

public class DependencyRepository {
    //declaración
    ArrayList<Dependency> dependencies;

    private static DependencyRepository dependencyRepository;

    //Inicialización
    //inicialización de todos los atributos de ámbito stático o de la clase
    static {
        dependencyRepository = new DependencyRepository();
    }

    /**
     *El metodo tiene que se privado para asegurar que siempre se ejecute
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        Initialize();
    }


    //Metodos

    public void Initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones Multiplataforma"));
        addDependency(new Dependency(3, "3", "2CFGS", "3"));
        addDependency(new Dependency(4, "AddDependencyInteractor", "2CFGS", "3"));
        addDependency(new Dependency(5, "1", "3CFGS", "3"));
        addDependency(new Dependency(6, "3", "2CFGS", "4"));
        addDependency(new Dependency(7, "2", "1CFGS", "5"));
    }

    //patrón sigletón
    public static DependencyRepository getInstance(){
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
        Collections.sort(this.dependencies);
        return  this.dependencies;
    }
}