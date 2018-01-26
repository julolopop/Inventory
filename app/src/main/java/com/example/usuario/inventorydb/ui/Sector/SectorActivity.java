package com.example.usuario.inventorydb.ui.Sector;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.usuario.inventorydb.Adapter.SectorAdapter;
import com.example.usuario.inventorydb.R;
import com.example.usuario.inventorydb.pojo.Sector;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Dependencias con el cual agregamos el adapter a la vista
 */
public class SectorActivity extends AppCompatActivity implements ListSectorFragment.OnListSectorFragmentListener {

    ListSectorFragment listSectorFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        listSectorFragment = (ListSectorFragment) getSupportFragmentManager().findFragmentByTag("ListSector");
        if(listSectorFragment == null){
            listSectorFragment = new ListSectorFragment();
            FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content,listSectorFragment,"ListSector");
            fragmentTransaction.commit();
        }

    }



}
