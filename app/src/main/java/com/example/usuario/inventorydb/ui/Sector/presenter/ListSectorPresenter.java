package com.example.usuario.inventorydb.ui.Sector.presenter;

import com.example.usuario.inventorydb.ui.Product.ListProductosFragment;
import com.example.usuario.inventorydb.ui.Product.interactor.ListProductosInteractor;
import com.example.usuario.inventorydb.ui.Sector.ListSectorFragment;
import com.example.usuario.inventorydb.ui.Sector.interactor.ListSectorInteractor;

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
