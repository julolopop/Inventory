package com.example.usuario.inventoryfragment.ui.Dependency.Presenter;

import com.example.usuario.inventoryfragment.ui.Dependency.Contract.AddDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddDepencencyPresenter {
    AddDependencyContract.View view;

    public AddDepencencyPresenter(AddDependencyContract.View view) {
        this.view = view;
    }
}
