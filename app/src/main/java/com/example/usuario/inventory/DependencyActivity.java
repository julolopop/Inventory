package com.example.usuario.inventory;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DependencyActivity extends ListActivity {

    private ArrayAdapter<Dependency> dependencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        this.dependencies = new ArrayAdapter<Dependency>(DependencyActivity.this,android.R.layout.simple_list_item_1
                ,((InventoryAplication)getApplicationContext()).getDependencies());
        getListView().setAdapter(dependencies);
    }


}

