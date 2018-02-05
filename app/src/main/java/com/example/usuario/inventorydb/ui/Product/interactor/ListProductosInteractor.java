package com.example.usuario.inventorydb.ui.Product.interactor;

import com.example.usuario.inventorydb.data.db.repository.ProductRepository;
import com.example.usuario.inventorydb.ui.Product.presenter.ListProductospresenter;
import com.example.usuario.inventorydb.ui.Sector.presenter.ListSectorPresenter;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductosInteractor {

    ListProductospresenter presenter;

    public ListProductosInteractor(ListProductospresenter presenter) {
    this.presenter = presenter;
    }


    public void cargarAdapterInteractor() {
        presenter.cargarAdapterPresenter(ProductRepository.getInstance().getProducts());
    }

    public void gotoaddProductosInteractor() {
        presenter.gotoaddProductosPresenter();
    }

    public void verProductoInteractor(String shorthname) {
        String mensage = ProductRepository.getInstance().getProduct(shorthname).get(0).toString();
        presenter.verProductoPresenter(mensage);
    }
}
