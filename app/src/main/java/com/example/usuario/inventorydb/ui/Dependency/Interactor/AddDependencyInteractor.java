package com.example.usuario.inventorydb.ui.Dependency.Interactor;

import android.widget.Toast;

import com.example.usuario.inventorydb.data.db.repository.DependencyRepository;
import com.example.usuario.inventorydb.pojo.Dependency;
import com.example.usuario.inventorydb.ui.InteractorCallback;

import java.util.ArrayList;

/**
 * Created by usuario on 24/11/17.
 */

public class AddDependencyInteractor implements InteractorCallback{

    OnAddDependencyListener listener;




    @Override
    public void onSuccess() {
        listener.OnSuccess();
    }


    @Override
    public void onError(Error error) {
        listener.onDatabaseError(error);
    }


    public interface OnAddDependencyListener {
        void OnNameEmpyteError();

        void OnShortNameEmpyteError();

        void OnDesciptionEmpyteError();

        void OnCloneError();

        void OnSuccess();

        void onDatabaseError(Error error);
    }
    public AddDependencyInteractor(OnAddDependencyListener listener) {
        this.listener = listener;
    }

    public void ValidateCredentails(String Name, String ShortName, String Description) {
        boolean pasar = true;



        if (DependencyRepository.getInstance().validateDependency(Name, ShortName)) {
            AddDependency(Name, ShortName, Description);
        }

        if (!(DependencyRepository.getInstance().validateDependency(Name, ShortName))) {
            listener.OnCloneError();
            pasar = false;
        }
        //si el password es vacio
        if (Name.isEmpty()) {
            listener.OnNameEmpyteError();
            pasar = false;
        }
        if (ShortName.isEmpty()) {
            listener.OnShortNameEmpyteError();
            pasar = false;
        }
        if (Description.isEmpty()) {
            listener.OnDesciptionEmpyteError();
            pasar = false;
        }

        if (pasar)
            listener.OnSuccess();
    }


    public void AddDependency(String name, String sortname, String description) {
        ArrayList<Dependency> arrayList = DependencyRepository.getInstance().getDependencies();
        int pos = DependencyRepository.getInstance().getDependencies().get(arrayList.toArray().length-1).get_ID();
        Dependency dependency = new Dependency(pos, name, sortname, description,null);
        DependencyRepository.getInstance().addDependency(dependency,this);

    }



    public void EditDependency(String Name, String ShortName, String Description,int pos) {

        Dependency dependency = new Dependency(pos,Name,ShortName,Description,null);
        DependencyRepository.getInstance().editDependency(dependency,this);
        listener.OnSuccess();
    }
}

