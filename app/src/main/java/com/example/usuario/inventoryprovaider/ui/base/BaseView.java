package com.example.usuario.inventoryprovaider.ui.base;

/**
 * Created by usuario on 24/11/17.
 */

public interface BaseView {
    void setPresenter(BasePresenter presenter);

    void showDatabaseError(Error error);
}