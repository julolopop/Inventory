package com.example.usuario.inventoryprovaider.ui.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usuario.inventoryprovaider.Adapter.ProductAdapter;
import com.example.usuario.inventoryprovaider.R;
import com.example.usuario.inventoryprovaider.pojo.Productos;
import com.example.usuario.inventoryprovaider.ui.Product.presenter.ListProductospresenter;

import java.util.ArrayList;


public class ListProductosFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    public static final String TAG = "ListProductosFragment";
    private OnListProductFragmentListener listener;

    private Toolbar toolbar;
    private ListView listView;
    private ProductAdapter adapter;
    private FloatingActionButton fab;
    private ListProductospresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListProductospresenter(this);

        if (getArguments() != null) {
        }
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_productos, container, false);

        this.listView = view.findViewById(android.R.id.list);
        this.toolbar = view.findViewById(R.id.toolbar);
        this.fab = view.findViewById(R.id.fab);

        adapter = new ProductAdapter(getContext());
        this.listView.setAdapter(adapter);

        presenter.cargarAdapter();

        this.listView.setOnItemClickListener(this);
        this.fab.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListProductFragmentListener) {
            listener = (OnListProductFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String shorthname = ((TextView)view.findViewById(R.id.txv_name)).getText().toString();
        presenter.verProducto(shorthname);
    }

    public void cargarAdapterView(ArrayList<Productos> products) {
        adapter.clear();
        adapter.addAll(products);
    }

    @Override
    public void onClick(View v) {
        if (v == fab){
            presenter.gotoaddProductos();
        }
    }

    public void gotoaddProductosView() {
        listener.gotoaddProductosActivity();
    }

    public void verProductoView(String mensage) {
        Toast.makeText(getContext(),mensage,Toast.LENGTH_LONG).show();
    }


    public interface OnListProductFragmentListener {

        void gotoaddProductosActivity();
    }
}
