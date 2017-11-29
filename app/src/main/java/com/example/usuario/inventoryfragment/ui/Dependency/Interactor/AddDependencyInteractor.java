package com.example.usuario.inventoryfragment.ui.Dependency.Interactor;

import com.example.usuario.inventoryfragment.data.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public class AddDependencyInteractor {
    public interface OnAddDependencyListener {
        void OnNameEmpyteError();

        void OnShortNameEmpyteError();

        void OnDesciptionEmpyteError();

        void OnCloneError();

        void OnSuccess();
    }


    public void ValidateCredentails(String Name, String ShortName, String Description, AddDependencyInteractor.OnAddDependencyListener listener) {
        boolean pasar = true;

        DependencyRepository d = DependencyRepository.getInstance();


        for (int i = 0; i < d.getDependencies().toArray().length; i++) {
            if (d.getDependencies().get(i).getName().compareTo(Name) == 0 && d.getDependencies().get(i).getShortname().compareTo(ShortName) == 0)
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
}

