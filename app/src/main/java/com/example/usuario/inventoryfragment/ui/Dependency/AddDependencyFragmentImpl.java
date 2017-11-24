package com.example.usuario.inventoryfragment.ui.Dependency;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.Dependency.Contract.AddDependencyContract;
import com.example.usuario.inventoryfragment.ui.Dependency.Interface.AddDependencyFragment;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;

public class AddDependencyFragmentImpl extends Fragment implements AddDependencyFragment ,AddDependencyContract.View{


    private AddDependencyContract.Presenter presenter;
    public static final String TAG = "AddDependencyFragmentImpl";
    TextInputEditText name ;
    TextInputEditText shortName;
    TextInputEditText description;


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

        FloatingActionButton fabadd = (FloatingActionButton)rootView.findViewById(R.id.fab);
        name = (TextInputEditText)rootView.findViewById(R.id.tie_NombreLargo);
        shortName = (TextInputEditText)rootView.findViewById(R.id.tie_NombreCorto);
        description = (TextInputEditText)rootView.findViewById(R.id.tie_Description);
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
    public void NavigateToHome() {

    }
}
