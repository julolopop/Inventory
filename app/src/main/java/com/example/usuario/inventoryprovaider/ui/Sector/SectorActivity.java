package com.example.usuario.inventoryprovaider.ui.Sector;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.usuario.inventoryprovaider.R;

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
