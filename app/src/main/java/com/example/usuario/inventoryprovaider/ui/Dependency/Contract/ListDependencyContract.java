package com.example.usuario.inventoryprovaider.ui.Dependency.Contract;

import com.example.usuario.inventoryprovaider.pojo.Dependency;
import com.example.usuario.inventoryprovaider.ui.base.BasePresenter;
import com.example.usuario.inventoryprovaider.ui.base.BaseView;

import java.util.List;
import java.util.Set;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void ShowDependency(List<Dependency> dependencies);

        void showDeleteMessage();

        void deleteSelectedDependencies(Set<Integer> positions);
        void showProgressDialog();

        void dismissProgressDialog();
    }
    interface Presenter extends BasePresenter{
        void LoadDependency();
        void EliminarDependency(Dependency dependencia);

        void deleteSelection();

        void setNewSelection(int position);

        boolean isPositionCheked(int position);

        void removeSelection(int position);

    }
}
