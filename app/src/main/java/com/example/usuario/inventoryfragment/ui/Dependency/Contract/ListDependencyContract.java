package com.example.usuario.inventoryfragment.ui.Dependency.Contract;

import com.example.usuario.inventoryfragment.ui.Dependency.Interface.ListDependencyFragment;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View{
        void setPresenter(ListDependencyContract.Presenter presenter);
    }
    interface Presenter{

    }
}
