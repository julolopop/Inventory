package com.example.usuario.inventoryprovaider.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.usuario.inventoryprovaider.R;
import com.example.usuario.inventoryprovaider.pojo.Sector;
import com.example.usuario.inventoryprovaider.data.db.repository.SectorRepository;
import com.example.usuario.inventoryprovaider.ui.Sector.ListSectorFragment;

import java.util.ArrayList;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion SectorAdapter Buena con el cual se controla la aparicion y desaparicion de las dependencias
 */


public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorHolder>{
    ArrayList<Sector> sectors;
    ArrayList<Sector> sectorsModified;
    private OnSwithCheckedChangeListener onSwithCheckedChangeListener;
    ListSectorFragment.OnItemClickListener listener;
    /**
     *Constructor que almacenará los cector que se han modifiado en la interfaz y no han guardado aún la base de datos
     */
    public SectorAdapter(ListSectorFragment.OnItemClickListener listener){
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = new ArrayList<>();
        onSwithCheckedChangeListener = new OnSwithCheckedChangeListener();
        this.listener = listener;
    }

    public SectorAdapter(ArrayList<Sector> sectorsModified, ListSectorFragment.OnItemClickListener listener){
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = sectorsModified;
        onSwithCheckedChangeListener = new OnSwithCheckedChangeListener();
        this.listener = listener;
    }

    @Override
    public SectorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // inflo la vista
        View view = inflater.inflate(R.layout.item_sector,null);
        // se crea el view holder a partir de la vista
        SectorHolder holder = new SectorHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(SectorHolder holder, int position) {
        holder.swt_enable.setChecked(sectors.get(position).isEnable());
        holder.swt_enable.setOnCheckedChangeListener(onSwithCheckedChangeListener);
        holder.swt_enable.setId(sectors.get(position).get_ID());
        holder.txv_Name.setText(sectors.get(position).getName());
        if(sectors.get(position).isDefaultState())
            holder.txv_SectoDefault.setText(R.string.default_text);

        holder.bind(sectors.get(position),listener);

    }

    /**
     * Se creara tantos elementos viewholder como elementos haya definido en el arraylist de la clase
     * @return
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }


    public static class SectorHolder extends RecyclerView.ViewHolder{
        private Switch swt_enable;
        private TextView txv_Name,txv_SectoDefault;

        public SectorHolder(View itemView) {
            super(itemView);
            swt_enable = (Switch) itemView.findViewById(R.id.swt_enable);
            txv_Name = (TextView) itemView.findViewById(R.id.txv_nameSector);
            txv_SectoDefault = (TextView) itemView.findViewById(R.id.txv_SortNameSector);
        }

        public void bind(final Sector sector, final ListSectorFragment.OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(sector);
                }
            });
        }
    }


    /**
     * Devuelve el array de los sectores que el usuario a modificado cuando
     * la activity estaba visible(esta dinamico) y que al guardado en la base de datos
     * (Persistente)
     *
     * @return ArrayList
     */



    public ArrayList<Sector> getSectorsModified()
    {
        return  sectorsModified;
    }


    class OnSwithCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int sectorID = buttonView.getId();
            SectorRepository.getInstance().modifySector(sectorID, isChecked);

        }
    }

}
