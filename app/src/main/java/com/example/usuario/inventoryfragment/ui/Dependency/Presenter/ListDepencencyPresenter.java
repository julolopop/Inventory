package com.example.usuario.inventoryfragment.ui.Dependency.Presenter;

import android.view.View;
import android.widget.ListView;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interactor.ListDependencyInteractor;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDepencencyPresenter implements ListDependencyContract.Presenter ,ListDependencyInteractor.OnLoadDependencyListener{

    ListDependencyContract.View view;
    ListDependencyInteractor interactor;

    public ListDepencencyPresenter(ListDependencyContract.View view ) {
        this.view = view;
        this.interactor = new ListDependencyInteractor(this);
    }

    @Override
    public void LoadDependency() {
        interactor.getDependency();
    }

    @Override
    public void EliminarDependency(Dependency dependencia) {
        interactor.EliminarDependency(dependencia);
    }


    @Override
    public void OnSuccess(List<Dependency> list) {
        view.ShowDependency(list);
    }



}
