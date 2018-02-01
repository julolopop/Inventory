package com.example.usuario.inventorydb.ui.Product;

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

import com.example.usuario.inventorydb.Adapter.ProductAdapter;
import com.example.usuario.inventorydb.R;
import com.example.usuario.inventorydb.pojo.Productos;
import com.example.usuario.inventorydb.ui.Product.presenter.ListProductospresenter;
import com.example.usuario.inventorydb.ui.Product.presenter.addProductospresenter;

import java.util.ArrayList;


public class addProductosFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "addProductosFragment";
    private OnaddProductFragmentListener listener;

    private FloatingActionButton fab;

    private addProductospresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new addProductospresenter(this);

        if (getArguments() != null) {
        }
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_productos, container, false);

        this.fab = view.findViewById(R.id.fab);
        
        
        this.fab.setOnClickListener(this);
        
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnaddProductFragmentListener) {
            listener = (OnaddProductFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onClick(View v) {
        if(v == fab){
            presenter.gotoListProductos();
        }
    }

    public void gotoListProductosView() {
        listener.gotoListProductosActivity();
    }


    public interface OnaddProductFragmentListener {

        void gotoListProductosActivity();
    }
}
