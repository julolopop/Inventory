package com.example.usuario.inventoryprovaider.ui.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.usuario.inventoryprovaider.R;
import com.example.usuario.inventoryprovaider.pojo.Category;
import com.example.usuario.inventoryprovaider.pojo.SubCategory;
import com.example.usuario.inventoryprovaider.ui.Product.presenter.addProductospresenter;

import java.util.ArrayList;


public class addProductosFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "addProductosFragment";
    private OnaddProductFragmentListener listener;

    private FloatingActionButton fab;
    private Spinner spn_Categoria;
    private Spinner spn_SubCategoria;

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
        this.spn_Categoria = view.findViewById(R.id.spn_Categoria);
        this.spn_SubCategoria = view.findViewById(R.id.spn_SubCategoria);
        
        this.fab.setOnClickListener(this);

        presenter.cargarSppiner();
        
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



    public void cargarSppinerView(ArrayList<Category> categories, ArrayList<SubCategory> subCategories) {
        this.spn_Categoria.setAdapter(new ArrayAdapter<Category>(getContext(), android.R.layout.simple_spinner_item,categories));
        this.spn_SubCategoria.setAdapter(new ArrayAdapter<SubCategory>(getContext(), android.R.layout.simple_spinner_item,subCategories));
    }


    public interface OnaddProductFragmentListener {

        void gotoListProductosActivity();
    }
}
