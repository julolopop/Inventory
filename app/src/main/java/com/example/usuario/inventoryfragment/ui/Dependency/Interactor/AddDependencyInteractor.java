package com.example.usuario.inventoryfragment.ui.Dependency.Interactor;

/**
 * Created by usuario on 24/11/17.
 */

public class AddDependencyInteractor {
    public interface OnAddDependencyListener {
        void OnNameEmpyteError();
        void OnShortNameEmpyteError();
        void OnDesciptionEmpyteError();

        void OnSuccess();
    }


    public void ValidateCredentails(String Name, String ShortName,String Description, AddDependencyInteractor.OnAddDependencyListener listener) {
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

