package com.example.usuario.inventoryprovaider.ui.Sector;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryprovaider.Adapter.SectorAdapter;
import com.example.usuario.inventoryprovaider.R;
import com.example.usuario.inventoryprovaider.pojo.Sector;


public class ListSectorFragment extends Fragment {

    private RecyclerView recyclerView;
    private SectorAdapter sectorAdapter;
    private OnListSectorFragmentListener mListener;
    private OnItemClickListener listener;
    private Toolbar toolbar;



    public interface  OnItemClickListener{
        void onItemClick(Sector sector);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_sector, container, false);


        int spanCount = 2;

        recyclerView = (RecyclerView) view.findViewById(R.id.rcv_Sectores);
        this.toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_dependency);
        //Para que pinte los elementos
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        //inicializo el adapter y lo asocio


        ((SectorActivity)mListener).setSupportActionBar(this.toolbar);

        if (savedInstanceState != null)
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"),listener);
        else
            sectorAdapter = new SectorAdapter(listener);

        recyclerView.setAdapter(sectorAdapter);



        return view;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListSectorFragmentListener) {
            mListener = (OnListSectorFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_activity, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * Almaceno los sectores que han modificado en la vista y no han sido guardados
     * para
     * @param outState
     */

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }
    public interface OnListSectorFragmentListener {

    }
}
