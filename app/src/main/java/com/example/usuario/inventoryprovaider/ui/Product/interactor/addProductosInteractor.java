package com.example.usuario.inventoryprovaider.ui.Product.interactor;

import com.example.usuario.inventoryprovaider.data.db.repository.CategoryRepository;
import com.example.usuario.inventoryprovaider.data.db.repository.SubCategoryRepository;
import com.example.usuario.inventoryprovaider.ui.Product.presenter.addProductospresenter;

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

    public void cargarSppinerInteractor() {
        presenter.cargarSppinerPresenter(CategoryRepository.getInstance().getCategories(), SubCategoryRepository.getInstance().getSubCategories());
    }
}
