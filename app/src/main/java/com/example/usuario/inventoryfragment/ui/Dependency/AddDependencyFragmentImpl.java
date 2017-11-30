package com.example.usuario.inventoryfragment.ui.Dependency;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.data.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.AddDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Presenter.ListDepencencyPresenter;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.utils.AddEdit;

public class AddDependencyFragmentImpl extends Fragment implements AddDependencyContract.View{


    private AddDependencyListener listener;
    private AddDependencyContract.Presenter presenter;
    public static final String TAG = "AddDependencyFragmentImpl";
    TextInputEditText name ;
    TextInputEditText shortName;
    TextInputEditText description;
    int posicion;
    private AddEdit mode;

    interface  AddDependencyListener{
        void listNewDependency();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (AddDependencyListener) activity;
        }catch (ClassCastException e){
            throw  new ClassCastException(getActivity().getLocalClassName()+"must implement ListDependencyListener");
        }
    }

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
        final View rootView = inflater.inflate(R.layout.fragment_add_dependency,container,false);

        posicion = -1;
        mode = new AddEdit();
        FloatingActionButton fabadd = (FloatingActionButton)rootView.findViewById(R.id.fab);
        name = (TextInputEditText)rootView.findViewById(R.id.tie_NombreLargo);
        shortName = (TextInputEditText)rootView.findViewById(R.id.tie_NombreCorto);
        description = (TextInputEditText)rootView.findViewById(R.id.tie_Description);

        if(this.getArguments()!=null) {
            name.setText(this.getArguments().getString("nombre"));
            shortName.setText(this.getArguments().getString("shortname"));
            description.setText(this.getArguments().getString("descripcion"));
            posicion = this.getArguments().getInt("posicion");
            mode.setMode(AddEdit.EDIT_MODE);
        }
        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.ValidateCredentails(name.getText().toString(),shortName.getText().toString(),description.getText().toString());
            }
        });
        return rootView;
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddDependencyContract.Presenter) presenter;
    }

    @Override
    public void SetNameEmpyteError() {
        this.name.setError("Error");
    }

    @Override
    public void SetShortNameEmpyteError() {
        this.shortName.setError("Error");
    }

    @Override
    public void SetDesciptionEmpyteError() {
        this.description.setError("Error");
    }

    @Override
    public void SetCloneError() {
        this.name.setError("EL nombre ya existe");
        this.shortName.setError("EL shortname ya existe");
    }

    @Override
    public void NavigateToHome() {
        DependencyRepository d = DependencyRepository.getInstance();

        if(mode.getMode() == AddEdit.EDIT_MODE) {
            d.getDependencies().get(posicion).setName(name.getText().toString());
            d.getDependencies().get(posicion).setShortname(shortName.getText().toString());
            d.getDependencies().get(posicion).setDescription(description.getText().toString());

        }else{
            d.addDependency(new Dependency(d.getDependencies().toArray().length, name.getText().toString(), shortName.getText().toString(), description.getText().toString()));
        }
        listener.listNewDependency();
    }

}
