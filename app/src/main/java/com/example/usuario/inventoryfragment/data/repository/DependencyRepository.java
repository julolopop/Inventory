package com.example.usuario.inventoryfragment.data.repository;

import com.example.usuario.inventoryfragment.pojo.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Creacion del array de Dependencias
 */

public class DependencyRepository{
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
        /*addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones Multiplataforma"));
        /addDependency(new Dependency(3, "3", "2CFGS", "3"));
        addDependency(new Dependency(4, "AddDependencyInteractor", "2CFGS", "3"));
        addDependency(new Dependency(5, "1", "3CFGS", "3"));
        addDependency(new Dependency(6, "3", "2CFGS", "4"));
        addDependency(new Dependency(7, "2", "1CFGS", "5"));
    */}

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

    public void editDependency(Dependency dependencia) {
        int index = 0;

        while (index < dependencies.size()) {
            if (dependencia.get_ID() == dependencies.get(index).get_ID()) {
                dependencies.get(index).setDescription(dependencia.getDescription());
                index = dependencies.size();
            } else
                index++;
        }

    }


    public void deleteDependency(Dependency dependencia) {
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependency;

        while (iterator.hasNext()){
            dependency = iterator.next();
            if (dependency.getName().equals(dependencia.getName())){
                iterator.remove();
            }
        }
    }

    public boolean validateDependency(String name, String sortname) {
        boolean result = true;
        int index = 0;

        while (index < dependencies.size()) {
            if (name.equals(dependencies.get(index).getName()) || sortname.equals(dependencies.get(index).getShortname())) {
                result = false;
                index = dependencies.size();
            } else
                index++;
        }

        return result;
    }

}
