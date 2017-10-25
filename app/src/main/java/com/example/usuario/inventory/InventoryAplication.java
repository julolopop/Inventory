package com.example.usuario.inventory;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class InventoryAplication extends Application {


    ArrayList<Dependency> dependencies;

    public InventoryAplication() {
        this.dependencies = new ArrayList(); ;
    }

    @Override
    public void onCreate() {
        super.onCreate();



        addDependencency(new Dependency(1,"Primer Ciclo Formativo Grado Superior","1ºCFGS","1ºCFGS Aplicaciones Multiplataforma"));
        addDependencency(new Dependency(2,"Segundo Ciclo Formativo Grado Superior","2ºCFGS","2ºCFGS Aplicaciones Multiplataforma"));

    }

    public  void addDependencency(Dependency dependency){
        this.dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
