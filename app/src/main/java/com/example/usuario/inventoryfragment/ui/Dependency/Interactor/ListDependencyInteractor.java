package com.example.usuario.inventoryfragment.ui.Dependency.Interactor;

import com.example.usuario.inventoryfragment.data.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor {
    OnLoadDependencyListener listener;


    public interface OnLoadDependencyListener {
        void OnSuccess(List<Dependency> list);
    }


    public ListDependencyInteractor(OnLoadDependencyListener listener) {
        this.listener = listener;
    }

    public void getDependency() {
        listener.OnSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
