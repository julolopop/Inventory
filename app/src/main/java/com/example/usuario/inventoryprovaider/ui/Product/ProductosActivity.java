package com.example.usuario.inventoryprovaider.ui.Product;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.usuario.inventoryprovaider.R;
import com.example.usuario.inventoryprovaider.ui.Dependency.ListDependencyFragmentImpl;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Lista de del DependencyAdapter
 */

public class ProductosActivity extends AppCompatActivity implements ListProductosFragment.OnListProductFragmentListener ,addProductosFragment.OnaddProductFragmentListener {

    ListProductosFragment listProductos;
    addProductosFragment addProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);





        FragmentManager fragmentManager = getSupportFragmentManager();
        listProductos = (ListProductosFragment) fragmentManager.findFragmentByTag(ListProductosFragment.TAG);
        if(listProductos == null){
            listProductos = new ListProductosFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace( android.R.id.content,listProductos, ListDependencyFragmentImpl.TAG);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void gotoaddProductosActivity() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        addProductos = (addProductosFragment) fragmentManager.findFragmentByTag(addProductosFragment.TAG);
        if(addProductos == null){
            addProductos = new addProductosFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace( android.R.id.content,addProductos, addProductosFragment.TAG);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void gotoListProductosActivity() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        listProductos = (ListProductosFragment) fragmentManager.findFragmentByTag(ListProductosFragment.TAG);
        if(listProductos == null){
            listProductos = new ListProductosFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace( android.R.id.content,listProductos, ListDependencyFragmentImpl.TAG);
            fragmentTransaction.commit();
        }
    }
}
