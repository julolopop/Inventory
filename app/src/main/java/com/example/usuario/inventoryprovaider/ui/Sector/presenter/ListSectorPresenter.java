package com.example.usuario.inventoryprovaider.ui.Sector.presenter;

import com.example.usuario.inventoryprovaider.ui.Sector.ListSectorFragment;
import com.example.usuario.inventoryprovaider.ui.Sector.interactor.ListSectorInteractor;

/**
 * Created by usuario on 5/02/18.
 */

public class ListSectorPresenter {

    ListSectorFragment view;
    ListSectorInteractor interactor;

    public ListSectorPresenter(ListSectorFragment view) {
        this.view = view;
        this.interactor = new ListSectorInteractor(this);
    }
}
