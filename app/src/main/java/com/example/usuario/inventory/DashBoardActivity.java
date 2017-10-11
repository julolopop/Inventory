package com.example.usuario.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        gridDashBoard = ((GridLayout) findViewById(R.id.gridDashboard)); // Da problemas ya que pone que no se inicializa = null

        //definir un array int que contendrá el id de las imagenes
        int[] imagenes = {R.drawable.chair, R.drawable.closet, R.drawable.cpu, R.drawable.inventory, R.drawable.keyboard, R.drawable.monitor, R.drawable.mouse,
                R.drawable.printer, R.drawable.proyector, R.drawable.table, R.drawable.whiteboard};

        //Definir in array de imageView
        //ImageView[] imageViews = new ImageView[imagenes.length];  // no se utiliza array de objetos se deve utilizar vector o coleciones
        //no se utiliza la clase vector por que no trabajamos con hilos y no se requiere sincronizacion
        /*
        una manera que no se utiliza hay que refactorizar

        ArrayList imageViewArrayList = new ArrayList<ImageView>();

        for (int i=0;i<imagenes.length;i++){
            imageViewArrayList.add(new ImageView(this));
            if (imageViewArrayList.get(i) instanceof ImageView)
                ((ImageView)imageViewArrayList.get(i)).setImageResource(imagenes[i]);
        }*/
        int with = (int) getResources().getDimension(R.dimen.imgDashboardWidth);
        int height = (int) getResources().getDimension(R.dimen.imgDashboardHeight);

        ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();

        for (int i = 0; i < imagenes.length; i++) {
            imageViewArrayList.add(new ImageView(this));
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = with;
            params.height= height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            imageViewArrayList.get(i).setImageResource(imagenes[i]);
            gridDashBoard.addView(imageViewArrayList.get(i));
        }


    }
}
