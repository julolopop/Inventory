package com.example.usuario.inventorydb.ui.Product.interactor;

import com.example.usuario.inventorydb.data.db.repository.ProductRepository;
import com.example.usuario.inventorydb.ui.Product.presenter.ListProductospresenter;
import com.example.usuario.inventorydb.ui.Product.presenter.addProductospresenter;

/**
 * Created by usuario on 1/02/18.
 */

public class addProductosInteractor {

    addProductospresenter presenter;

    public addProductosInteractor(addProductospresenter presenter) {
    this.presenter = presenter;
    }

    public void gotoListProductosInteractor() {
        presenter.gotoListProductosPresenter();
    }
}
