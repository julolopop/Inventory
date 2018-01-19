package com.example.usuario.inventorydb.ui.Dependency.Contract;

import com.example.usuario.inventorydb.pojo.Dependency;
import com.example.usuario.inventorydb.ui.base.BasePresenter;
import com.example.usuario.inventorydb.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void ShowDependency(List<Dependency> list);

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
