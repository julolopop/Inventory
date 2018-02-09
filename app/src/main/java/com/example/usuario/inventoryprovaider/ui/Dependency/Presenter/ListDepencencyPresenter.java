package com.example.usuario.inventoryprovaider.ui.Dependency.Presenter;

import android.os.AsyncTask;

import com.example.usuario.inventoryprovaider.pojo.Dependency;
import com.example.usuario.inventoryprovaider.ui.Dependency.Contract.ListDependencyContract;
import com.example.usuario.inventoryprovaider.ui.Dependency.DependencyActivity;
import com.example.usuario.inventoryprovaider.ui.Dependency.Interactor.ListDependencyInteractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDepencencyPresenter implements ListDependencyContract.Presenter ,ListDependencyInteractor.OnFinishedLoadDependency{

    ListDependencyContract.View view;
    ListDependencyInteractor interactor;

    HashMap<Integer, Boolean> mSelection = new HashMap<>();

    public ListDepencencyPresenter(ListDependencyContract.View view ) {
        this.view = view;
        this.interactor = new ListDependencyInteractor(this);
    }




    public void loadDependency() {
        DependencyAsyncTask asyncTask = new DependencyAsyncTask();
        asyncTask.execute();
    }


    public void loadDependencyOrderByName() {
        interactor.loadDependenciesOrderByName();
    }


    public void loadDependencyOrderByID() {
        interactor.loadDependenciesOrderByID();
    }


    public void deleteDependency(Dependency dependency) {
        interactor.deleteDependency(dependency);
        view.showDeleteMessage();
    }


    @Override
    public void setNewSelection(int position) {
        mSelection.put(position, true);
    }

    @Override
    public boolean isPositionCheked(int position) {
        return false;
    }


    @Override
    public void removeSelection(int position) {
        mSelection.remove(position);
    }


    @Override
    public void LoadDependency() {
            DependencyAsyncTask asyncTask = new DependencyAsyncTask();
            asyncTask.execute();
        }

    @Override
    public void EliminarDependency(Dependency dependencia) {

    }

    @Override
    public void deleteSelection() {
        view.deleteSelectedDependencies(mSelection.keySet());
    }



    public boolean isPositionChecked(int position) {
        return mSelection.get(position) == null ? false : true;
    }



    public void clearSelection() {
        mSelection.clear();
    }


    public void deleteSelectedDependencies(ArrayList<Dependency> dependencies) {
        interactor.deleteDependencies(dependencies);
    }


    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.ShowDependency(dependencies);
    }


    public void onDestroy() {
        view = null;
        interactor = null;
    }


    class DependencyAsyncTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {


            interactor.loadDependencies();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showProgressDialog();
        }



        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            view.dismissProgressDialog();
        }
    }
}
