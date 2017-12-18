package com.example.usuario.inventoryfragment.ui.Dependency.Presenter;

import android.view.View;
import android.widget.ListView;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interactor.ListDependencyInteractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

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

    HashMap<Integer,Boolean> selection = new HashMap<>();

    @Override
    public void deleteSelection() {
        for (Map.Entry<Integer,Boolean> tmp: selection.entrySet()) {
            interactor.EliminarSeletion(tmp.getKey());
        }
    }

    @Override
    public void setNewSelection(int position) {
        selection.put(position,true);
    }

    /**
     * Comprobar si el aelemento esiste en el mapa
     * @param position
     * @return
     */
    @Override
    public boolean isPositionCheked(int position) {
        return selection.get(position)==null?false:true;
    }

    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }


    @Override
    public void OnSuccess(List<Dependency> list) {
        view.ShowDependency(list);
    }



}
