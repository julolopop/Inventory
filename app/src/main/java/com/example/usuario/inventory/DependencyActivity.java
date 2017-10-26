package com.example.usuario.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.usuario.inventory.Adapter.DependencyAdapter;
import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.repository.DependencyRepository;

public class DependencyActivity extends ListActivity {

    //private ArrayAdapter<Dependency> dependencies;
    private DependencyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        //caso 1
        //dependencies =new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,DependencyRepository.getInstance().getDependencies());
        //getListView().setAdapter(dependencies);

        //caso 2
        adapter = new DependencyAdapter(this);
        getListView().setAdapter(adapter);
    }


}

