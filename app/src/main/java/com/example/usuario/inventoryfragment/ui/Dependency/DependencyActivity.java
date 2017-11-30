package com.example.usuario.inventoryfragment.ui.Dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.Dependency.Presenter.AddDepencencyPresenter;
import com.example.usuario.inventoryfragment.ui.Dependency.Presenter.ListDepencencyPresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseActivity;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Dependencias con el cual agregamos el adapter a la vista
 */

public class DependencyActivity extends BaseActivity  implements ListDependencyFragmentImpl.ListDependencyListener,AddDependencyFragmentImpl.AddDependencyListener{

    private ListDependencyFragmentImpl listDependency;
    private AddDependencyFragmentImpl addeditDependency;
    //private Fragment detailDependency;

    private ListDepencencyPresenter listDepencencyPresenter;
    private  AddDepencencyPresenter addDepencencyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        //1. se crea la vista
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //listDependency = (ListDependencyFragmentImpl) fragmentManager.findFragmentByTag(ListDependencyFragmentImpl.TAG);
        if(listDependency == null){
            listDependency = (ListDependencyFragmentImpl) ListDependencyFragmentImpl.newInstance(null);
            fragmentTransaction.replace( android.R.id.content,listDependency, ListDependencyFragmentImpl.TAG);
            fragmentTransaction.commit();

        }
        //2. se crea el presentador y se le pasa
        listDepencencyPresenter = new ListDepencencyPresenter(listDependency);

        listDependency.setPresenter(listDepencencyPresenter);
    }


    @Override
    public void addNewDependency(Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        addeditDependency = (AddDependencyFragmentImpl)fragmentManager.findFragmentByTag(AddDependencyFragmentImpl.TAG);
        if(addeditDependency == null){
            addeditDependency = (AddDependencyFragmentImpl) AddDependencyFragmentImpl.newInstance(bundle);
            fragmentTransaction.replace( android.R.id.content,addeditDependency, ListDependencyFragmentImpl.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        addDepencencyPresenter = new AddDepencencyPresenter(addeditDependency);//-
        addeditDependency.setPresenter(addDepencencyPresenter);
    }


    public void listNewDependency(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(listDependency == null){
            listDependency = (ListDependencyFragmentImpl) fragmentManager.findFragmentByTag(ListDependencyFragmentImpl.TAG);
        }
        fragmentTransaction.replace( android.R.id.content,listDependency, ListDependencyFragmentImpl.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //2. se crea el presentador y se le pasa
        listDepencencyPresenter = new ListDepencencyPresenter(listDependency);
        listDependency.setPresenter(listDepencencyPresenter);
    }
}

