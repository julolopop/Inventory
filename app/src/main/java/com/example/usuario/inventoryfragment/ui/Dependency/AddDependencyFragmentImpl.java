package com.example.usuario.inventoryfragment.ui.Dependency;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.AddDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interface.AddDependencyFragment;

public class AddDependencyFragmentImpl extends Fragment implements AddDependencyFragment ,AddDependencyContract.View{


    private AddDependencyContract.Presenter presenter;
    public static final String TAG = "AddDependencyFragmentImpl";

    public static AddDependencyFragmentImpl newInstance(Bundle bundle){
        AddDependencyFragmentImpl addDependencyFragment = new AddDependencyFragmentImpl();
        if (bundle!=null){
            addDependencyFragment.setArguments(bundle);
        }
        return  addDependencyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_dependency,container,false);
        if(getArguments()!=null){

        }
        return rootView;
    }

    @Override
    public void setPresenter(AddDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
