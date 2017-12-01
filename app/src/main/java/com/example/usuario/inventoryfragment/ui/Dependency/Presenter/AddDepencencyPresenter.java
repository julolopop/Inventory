package com.example.usuario.inventoryfragment.ui.Dependency.Presenter;

import com.example.usuario.inventoryfragment.ui.Dependency.Contract.AddDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interactor.AddDependencyInteractor;

/**
 * Created by usuario on 23/11/17.
 */

public class AddDepencencyPresenter implements  AddDependencyContract.Presenter,AddDependencyInteractor.OnAddDependencyListener{
    AddDependencyContract.View view;
    private AddDependencyInteractor interactor ;


    public AddDepencencyPresenter(AddDependencyContract.View view) {
        this.view = view;
        interactor = new AddDependencyInteractor(this);
    }

    @Override
    public void ValidateCredentails(String Name, String ShortName, String Description) {
       interactor.ValidateCredentails(Name,ShortName,Description);
    }
    @Override
    public void EditDependency(String Name, String ShortName, String Description,int pos) {
        interactor.EditDependency(Name,ShortName,Description,pos);
    }

    @Override
    public void OnNameEmpyteError() {
        view.SetNameEmpyteError();
    }

    @Override
    public void OnShortNameEmpyteError() {
        view.SetShortNameEmpyteError();
    }

    @Override
    public void OnDesciptionEmpyteError() {
        view.SetDesciptionEmpyteError();
    }

    @Override
    public void OnCloneError() {
        view.SetCloneError();
    }

    @Override
    public void OnSuccess() {
        view.NavigateToHome();
    }

}
