package com.example.usuario.inventorydb.ui.Dependency.Interactor;

import com.example.usuario.inventorydb.data.db.repository.DependencyRepository;
import com.example.usuario.inventorydb.pojo.Dependency;
import com.example.usuario.inventorydb.ui.InteractorCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor implements InteractorCallback{

    OnFinishedLoadDependency listener;


    public ListDependencyInteractor(OnFinishedLoadDependency listener) {
        this.listener = listener;
    }


    public interface OnFinishedLoadDependency {
        void onSuccess(List<Dependency> list);
    }



    public void loadDependencies() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }



    public void loadDependenciesOrderByName() {
        listener.onSuccess(DependencyRepository.getInstance().getDependenciesOrderByName());
    }



    public void loadDependenciesOrderByID() {
        listener.onSuccess(DependencyRepository.getInstance().getDependenciesOrderByID());
    }



    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency, this);
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }



    public void deleteDependencies(ArrayList<Dependency> dependencies) {
        for (int i = 0; i < dependencies.size(); i++)
            DependencyRepository.getInstance().deleteDependency(dependencies.get(i), this);

        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }



    public Dependency getDependency(int position) {
        //return DependencyRepository.getInstance().getDependencyAtPosition(position);
        return null;
    }


    @Override
    public void onSuccess() {

    }


    @Override
    public void onError(Error error) {

    }


}
