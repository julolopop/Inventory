package com.example.usuario.inventoryfragment.ui.Dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.Adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interface.ListDependencyFragment;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

import net.bytebuddy.implementation.bytecode.Throw;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyFragmentImpl extends ListFragment implements ListDependencyFragment,ListDependencyContract.View {
    public static final   String TAG = "ListDependencyFragmentImpl";

    private BasePresenter presenter;
    private ListDependencyListener listener;
    private FloatingActionButton fabAdd;



    interface  ListDependencyListener{
        void addNewDependency();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener =(ListDependencyListener)activity;
        }catch (ClassCastException e){
            throw  new ClassCastException(getActivity().getLocalClassName()+"must implement ListDependencyListener");
        }
    }

    public static ListDependencyFragment newInstance(Bundle bundle){
        ListDependencyFragmentImpl listDependency = new ListDependencyFragmentImpl();
        if (bundle!=null){
            listDependency.setArguments(bundle);
        }
        return  listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_dependency,container,false);


        fabAdd = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.addNewDependency();
            }
        });
                return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter =  presenter;
    }
}
