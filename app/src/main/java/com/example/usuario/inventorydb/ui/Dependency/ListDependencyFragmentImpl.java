package com.example.usuario.inventorydb.ui.Dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.usuario.inventorydb.Adapter.DependencyAdapter;
import com.example.usuario.inventorydb.R;
import com.example.usuario.inventorydb.data.db.repository.DependencyRepository;
import com.example.usuario.inventorydb.pojo.Dependency;
import com.example.usuario.inventorydb.ui.Dependency.Contract.ListDependencyContract;
import com.example.usuario.inventorydb.ui.Dependency.Presenter.ListDepencencyPresenter;
import com.example.usuario.inventorydb.ui.base.BasePresenter;
import com.example.usuario.inventorydb.utils.CommonUtils;
import com.example.usuario.inventorydb.utils.ConfirmationDialog;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyFragmentImpl extends Fragment implements ListDependencyContract.View {
    public static final   String TAG = "ListDependencyFragmentImpl";

    private ListDepencencyPresenter presenter;
    private ListDependencyListener callback;
    private FloatingActionButton fabAdd;
    private DependencyAdapter adapter;
    private ListView list;


    /**
     * crea de adapter
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);

    }

    /**
     * Este metodo se asigna al presentador del contexto
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opción de dependencia");
        getActivity().getMenuInflater().inflate(R.menu.menu_fragment_listdependency,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Dependency dependency = (Dependency) list.getItemAtPosition(info.position);


        switch (item.getItemId()) {
            case R.id.fragment_listdependency:
                Bundle bundle = new Bundle();
                bundle.putString(ConfirmationDialog.MESSAGE ,"Desea eliminar la dependencia");
                bundle.putString(ConfirmationDialog.TITULO ,"Eliminar Dependencia");
                bundle.putParcelable(ConfirmationDialog.DEPENDENCY,dependency);

                CommonUtils.ShowConfirmDialog(bundle,getActivity(),presenter)
                        .show();
                break;
        }
        return  super.onContextItemSelected(item);
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
            callback =(ListDependencyListener)activity;
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
                list.setChoiceMode(ListView.CHOICE_MODE_NONE);
                callback.addNewDependency(null);
            }
        });
        presenter.LoadDependency();
                return rootView;
    }

    /**
     * se le asigna el adapter sin datos y pulsacion larga del menu (Crear despues de crear la vista)
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

                callback.addNewDependency(bundle);
            }
        });

        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new DependencyMultiChoiceModeListener(presenter));
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.setItemChecked(position,!presenter.isPositionCheked(position));
                return true;
            }
        });

        //setListAdapter(adapter);
        //setListAdapter(new DependencyAdapter(getActivity()));
        registerForContextMenu(list);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDepencencyPresenter) presenter;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_dependencyshort, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
}