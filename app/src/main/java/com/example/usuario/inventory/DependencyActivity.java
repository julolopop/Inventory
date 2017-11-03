package com.example.usuario.inventory;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.Toolbar;

import com.example.usuario.inventory.Adapter.DependencyAdapter;
import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.repository.DependencyRepository;
/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Dependencias con el cual agregamos el adapter a la vista
 */

public class DependencyActivity extends AppCompatActivity {

    //private ArrayAdapter<Dependency> dependencies;
    private DependencyAdapter adapter;
    private ListView listView;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;
    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        //caso 1
        //dependencies =new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,DependencyRepository.getInstance().getDependencies());
        //getListView().setAdapter(dependencies);

        //caso 2
        this.toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_dependency);
        this.listView = (ListView)findViewById(android.R.id.list);
        this.fab = findViewById(R.id.fab);
        this.coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);


        setSupportActionBar(this.toolbar);

        this.adapter = new DependencyAdapter(this);
        this.listView.setAdapter(adapter);

        //al pulsar sobre el boton cer sisualizara hacia arriba el snackbar
        this.fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Snackbar.make(coordinatorLayout,"Ejemplo de snack",Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(DependencyActivity.this,AddDependencyActivity.class));

            }
        });
    }




}

