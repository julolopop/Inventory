package com.example.usuario.inventory.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usuario.inventory.R;
import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapterB extends ArrayAdapter<Dependency>{
    public DependencyAdapterB(@NonNull Context context) {
        super(context, R.layout.item_dependecy, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        MaterialLetterIcon icon;
        TextView txv_Name;
        TextView txv_SortName;


        if (view == null){
            //1. odtener el servivio de sistema layout inflater en el contexto
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. inflar la vista . crear memoria en view con todos los widge del xml
            view= inflater.inflate(R.layout.item_dependecy,null);
        }



        //3.inicializar las variables a los odjetos ya creados de los widget
        icon = (MaterialLetterIcon)view.findViewById(R.id.icon);
        txv_Name = (TextView)view.findViewById(R.id.txv_name);
        txv_SortName = (TextView)view.findViewById(R.id.txv_SortName);

        //4.Mostrar los datos del arrayList de la posición mediante position
        icon.setLetter(getItem(position).getShortname().substring(0,1));
        txv_Name.setText(getItem(position).getName());
        txv_SortName.setText(getItem(position).getShortname());


        return view;

    }
}
