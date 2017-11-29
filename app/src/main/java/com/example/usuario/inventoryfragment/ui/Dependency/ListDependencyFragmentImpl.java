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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.inventoryfragment.Adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.data.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Presenter.AddDepencencyPresenter;
import com.example.usuario.inventoryfragment.ui.Dependency.Presenter.ListDepencencyPresenter;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

import net.bytebuddy.implementation.bytecode.Throw;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyFragmentImpl extends ListFragment implements ListDependencyContract.View {
    public static final   String TAG = "ListDependencyFragmentImpl";

    private ListDepencencyPresenter presenter;
    private ListDependencyListener listener;
    private FloatingActionButton fabAdd;
    private DependencyAdapter adapter;
    private ListView list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }

    /**
     * este metodo es el que usa la visata para cargar los datos del repositorio
     * @param list
     */
    @Override
    public void ShowDependency(List<Dependency> list) {
        adapter.clear();
        adapter.addAll(list);
    }

    interface  ListDependencyListener{
        void addNewDependency(Bundle bundle);
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

    public static ListDependencyFragmentImpl newInstance(Bundle bundle){
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
                listener.addNewDependency(null);
            }
        });
        presenter.LoadDependency();
                return rootView;
    }

    /**
     * se le asigna el adapter sin datos
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list= (ListView) view.findViewById(android.R.id.list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();

                bundle.putString("nombre", DependencyRepository.getInstance().getDependencies().get(position).getName());
                bundle.putString("shortname",DependencyRepository.getInstance().getDependencies().get(position).getShortname());
                bundle.putString("descripcion", DependencyRepository.getInstance().getDependencies().get(position).getDescription());
                bundle.putInt("posicion",position);

                listener.addNewDependency(bundle);
            }
        });


        //setListAdapter(adapter);
        //setListAdapter(new DependencyAdapter(getActivity()));

    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDepencencyPresenter) presenter;
    }
}
