package com.example.usuario.inventoryprovaider.ui.Product.interactor;

import com.example.usuario.inventoryprovaider.data.db.repository.ProductInnerRepository;
import com.example.usuario.inventoryprovaider.data.db.repository.ProductRepository;
import com.example.usuario.inventoryprovaider.ui.Product.presenter.ListProductospresenter;

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
        String mensage = ProductInnerRepository.getInstance().getProduct(shorthname).get(0).toString();
        presenter.verProductoPresenter(mensage);
    }
}
