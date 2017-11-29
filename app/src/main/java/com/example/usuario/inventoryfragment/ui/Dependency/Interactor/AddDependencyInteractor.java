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


    public void ValidateCredentails(String Name, String ShortName,String Description, AddDependencyInteractor.OnAddDependencyListener listener) {

        DependencyRepository d = DependencyRepository.getInstance();

        for (int i = 0; i < d.getDependencies().toArray().length; i++) {
            if (d.getDependencies().get(i).getName() == Name && d.getDependencies().get(i).getShortname() == ShortName)
                listener.OnCloneError();
        }
        //si el password es vacio
        if (Name.isEmpty())
            listener.OnNameEmpyteError();
        else
        if (ShortName.isEmpty())
            listener.OnShortNameEmpyteError();
        else
        if (Description.isEmpty())
            listener.OnDesciptionEmpyteError();
        else
            listener.OnSuccess();
    }
}

