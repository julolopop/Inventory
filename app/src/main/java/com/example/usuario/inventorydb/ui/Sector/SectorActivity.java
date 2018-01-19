package com.example.usuario.inventorydb.ui.Sector;

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
public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SectorAdapter sectorAdapter;
    private OnItemClickListener listener;


    public interface  OnItemClickListener{
        void onItemClick(Sector sector);
    }
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int spanCount = 2;

        setContentView(R.layout.activity_sector);
        recyclerView = (RecyclerView) findViewById(R.id.rcv_Sectores);
        this.toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_dependency);
        //Para que pinte los elementos
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        //inicializo el adapter y lo asocio


        setSupportActionBar(this.toolbar);

        if (savedInstanceState != null)
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"),listener);
        else
            sectorAdapter = new SectorAdapter(listener);

        recyclerView.setAdapter(sectorAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno los sectores que han modificado en la vista y no han sido guardados
     * para
     * @param outState
     */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }
}
