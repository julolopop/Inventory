package com.example.usuario.inventory;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class InventoryApplication extends Application {



    ArrayList<Dependency> dependencies;

    public InventoryApplication(){}

    public InventoryApplication(ArrayList<Dependency> dependencies) {
        dependencies = new ArrayList<>();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dependencies=new ArrayList<>();
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS", "1CFGS Desarrollo aplicaciones Multiplataforma" ));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS", "2CFGS Desarrollo aplicaciones Multiplataforma" ));
    }

    /**
     * Metodo que añade una dependencia
     * @param dependency
     */

    public void addDependency(Dependency dependency)
    {
        dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies()
    {
        return dependencies;
    }
}
