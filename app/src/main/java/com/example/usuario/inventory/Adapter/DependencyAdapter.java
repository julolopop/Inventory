package com.example.usuario.inventory.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.R;
import com.example.usuario.inventory.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion DependencyAdapterB Buena con el cual se controla la aparicion y desaparicion de las dependencias
 */


public class DependencyAdapter extends ArrayAdapter<Dependency>{

    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependecy, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DependencyHolder dependencyHolder;
        View view = convertView;



        if (view == null){
            //1. odtener el servivio de sistema layout inflater en el contexto
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. inflar la vista . crear memoria en view con todos los widge del xml
            view= inflater.inflate(R.layout.item_dependecy,null);

            //3 se añade el holder
            dependencyHolder = new DependencyHolder();

            //4.inicializar las variables a los odjetos ya creados de los widget
            dependencyHolder.icon = (MaterialLetterIcon)view.findViewById(R.id.icon);
            dependencyHolder.txv_Name = (TextView)view.findViewById(R.id.txv_name);
            dependencyHolder.txv_SortName = (TextView)view.findViewById(R.id.txv_SortName);
            view.setTag(dependencyHolder);
        }else {
            //base buena con el tag
            dependencyHolder = (DependencyHolder) view.getTag();
        }




        //4.Mostrar los datos del arrayList de la posición mediante position
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0,1));
        dependencyHolder.txv_Name.setText(getItem(position).getName());
        dependencyHolder.txv_SortName.setText(getItem(position).getShortname());


        return view;

    }

    class DependencyHolder {
        MaterialLetterIcon icon;
        TextView txv_Name;
        TextView txv_SortName;
    }
}
