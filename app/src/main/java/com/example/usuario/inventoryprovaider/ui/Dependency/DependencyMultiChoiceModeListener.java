package com.example.usuario.inventoryprovaider.ui.Dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.usuario.inventoryprovaider.R;
import com.example.usuario.inventoryprovaider.ui.Dependency.Contract.ListDependencyContract;

/**
 * Created by usuario on 18/12/17.
 */

public class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener{

    private ListDependencyContract.Presenter presenter;
    private int count;

    public DependencyMultiChoiceModeListener(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
        count=0;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        if(checked){
            count++;
            presenter.setNewSelection(position);
        }else{
            presenter.removeSelection(position);
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_fragment_listdependency,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_account_setting:
                presenter.deleteSelection();
                break;
        }

        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        this.presenter = null;
        this.count=0;
    }
}
