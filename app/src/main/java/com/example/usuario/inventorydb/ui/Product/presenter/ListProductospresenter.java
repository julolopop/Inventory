package com.example.usuario.inventorydb.ui.Product.presenter;

import com.example.usuario.inventorydb.pojo.Productos;
import com.example.usuario.inventorydb.ui.Product.ListProductosFragment;
import com.example.usuario.inventorydb.ui.Product.interactor.ListProductosInteractor;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductospresenter {

    ListProductosFragment view;
    ListProductosInteractor interactor;

    public ListProductospresenter(ListProductosFragment view) {
    this.view = view;
    this.interactor = new ListProductosInteractor(this);
    }

    public void cargarAdapter() {
        interactor.cargarAdapterInteractor();
    }

    public void cargarAdapterPresenter(ArrayList<Productos> products) {
        view.cargarAdapterView(products);
    }

    public void gotoaddProductos() {
        interactor.gotoaddProductosInteractor();
    }

    public void gotoaddProductosPresenter() {
        view.gotoaddProductosView();
    }

    public void verProducto(String shorthname) {
        interactor.verProductoInteractor(shorthname);
    }

    public void verProductoPresenter(String mensage) {
        view.verProductoView(mensage);
    }
}
