package com.example.usuario.inventoryfragment.ui.Dependency.Presenter;

import android.support.v4.app.Fragment;

import com.example.usuario.inventoryfragment.ui.Dependency.Contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDepencencyPresenter implements ListDependencyContract.Presenter {

    ListDependencyContract.View view;

    public ListDepencencyPresenter(ListDependencyContract.View view) {
        this.view = view;
    }
}
