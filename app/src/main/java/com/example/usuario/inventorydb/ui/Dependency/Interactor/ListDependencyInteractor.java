package com.example.usuario.inventorydb.ui.Dependency.Interactor;

import com.example.usuario.inventorydb.data.db.repository.DependencyRepository;
import com.example.usuario.inventorydb.pojo.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor implements DependencyRepository.OnDependencyRepository{
    OnLoadDependencyListener listener;

    @Override
    public void onSusses() {

    }

    @Override
    public void onError() {

    }


    public interface OnLoadDependencyListener {
        void OnSuccess(List<Dependency> list);

    }


    public ListDependencyInteractor(OnLoadDependencyListener listener) {
        this.listener = listener;
    }

    public void getDependency() {
        listener.OnSuccess(DependencyRepository.getInstance().getDependencies());
    }

    public void EliminarDependency(Dependency dependencia){


        DependencyRepository d = DependencyRepository.getInstance();
        d.getInstance().deleteDependency(dependencia);
        listener.OnSuccess(d.getInstance().getDependencies());
    }



}
