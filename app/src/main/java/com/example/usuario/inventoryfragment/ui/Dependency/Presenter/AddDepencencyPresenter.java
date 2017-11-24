package com.example.usuario.inventoryfragment.ui.Dependency.Presenter;

import com.example.usuario.inventoryfragment.ui.Dependency.AddDependencyFragmentImpl;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.AddDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interactor.AddDependencyInteractor;

/**
 * Created by usuario on 23/11/17.
 */

public class AddDepencencyPresenter implements  AddDependencyContract.Presenter,AddDependencyInteractor.OnAddDependencyListener{
    AddDependencyContract.View view;
    private AddDependencyInteractor addInteractor = new AddDependencyInteractor();


    public AddDepencencyPresenter(AddDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void ValidateCredentails(String Name, String ShortName, String Description) {
       addInteractor.ValidateCredentails(Name,ShortName,Description,this);
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
    public void OnSuccess() {
        view.NavigateToHome();
    }
}
