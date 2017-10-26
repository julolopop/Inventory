package com.example.usuario.inventory.repository;

import com.example.usuario.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
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
        return this.dependencies;
    }
}
