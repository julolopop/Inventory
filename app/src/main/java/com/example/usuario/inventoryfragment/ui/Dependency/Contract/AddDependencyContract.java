package com.example.usuario.inventoryfragment.ui.Dependency.Contract;

import com.example.usuario.inventoryfragment.ui.Dependency.Interactor.AddDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddDependencyContract {
    interface View extends BaseView{

        void SetNameEmpyteError();
        void SetShortNameEmpyteError();
        void SetDesciptionEmpyteError();
        void SetCloneError();


        void NavigateToHome();
    }
    interface Presenter extends BasePresenter{
        void ValidateCredentails(String Name, String ShortName,String Description);
        void EditDependency(String Name, String ShortName, String Description,int pos);
    }
}
