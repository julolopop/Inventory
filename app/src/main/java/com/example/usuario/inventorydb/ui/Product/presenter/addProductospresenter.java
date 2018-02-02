package com.example.usuario.inventorydb.ui.Product.presenter;

import com.example.usuario.inventorydb.pojo.Category;
import com.example.usuario.inventorydb.pojo.Productos;
import com.example.usuario.inventorydb.pojo.SubCategory;
import com.example.usuario.inventorydb.ui.Product.ListProductosFragment;
import com.example.usuario.inventorydb.ui.Product.addProductosFragment;
import com.example.usuario.inventorydb.ui.Product.interactor.ListProductosInteractor;
import com.example.usuario.inventorydb.ui.Product.interactor.addProductosInteractor;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class addProductospresenter {

    addProductosFragment view;
    addProductosInteractor interactor;

    public addProductospresenter(addProductosFragment view) {
    this.view = view;
    this.interactor = new addProductosInteractor(this);
    }


    public void gotoListProductos() {
        interactor.gotoListProductosInteractor();
    }

    public void gotoListProductosPresenter() {
        view.gotoListProductosView();
    }




    public void cargarSppiner() {
        interactor.cargarSppinerInteractor();
    }

    public void cargarSppinerPresenter(ArrayList<Category> categories, ArrayList<SubCategory> subCategories) {
        view.cargarSppinerView(categories,subCategories);
    }
}
