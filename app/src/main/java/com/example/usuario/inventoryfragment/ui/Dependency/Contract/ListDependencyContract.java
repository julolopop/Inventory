package com.example.usuario.inventoryfragment.ui.Dependency.Contract;

import android.widget.ListView;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

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
        void EliminarDependency(int pos);
    }
}
