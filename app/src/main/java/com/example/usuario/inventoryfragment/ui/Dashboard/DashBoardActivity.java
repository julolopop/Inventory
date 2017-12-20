package com.example.usuario.inventoryfragment.ui.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.usuario.inventoryfragment.data.prefs.AppPreferenceshelper;
import com.example.usuario.inventoryfragment.InventoryApplication;
import com.example.usuario.inventoryfragment.ui.Setting.AccountSettingActivity;
import com.example.usuario.inventoryfragment.ui.Setting.GeneralSettingActivity;
import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.pojo.Imagenes;
import com.example.usuario.inventoryfragment.ui.Dependency.DependencyActivity;
import com.example.usuario.inventoryfragment.ui.Product.ProductosActivity;
import com.example.usuario.inventoryfragment.ui.Sector.SectorActivity;
import com.example.usuario.inventoryfragment.ui.inventory.InventoryActivity;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion layout en el cual se mostrara las imagenes de cada secion
 */

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashBoard;
    private ClickListenerDashBoard listenerDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        gridDashBoard = ((GridLayout) findViewById(R.id.gridDashboard)); // Da problemas ya que pone que no se inicializa = null hay que inicializar con android.support.v7.widget.GridLayout
        listenerDashBoard = new ClickListenerDashBoard();


        //definir un array int que contendrá el id de las imagenes
        Imagenes[] imagenes = {new Imagenes(R.drawable.product, 100),
                new Imagenes(R.drawable.seciones, 101),
                new Imagenes(R.drawable.preferencias, 102),
                new Imagenes(R.drawable.dependencia, 103),
                new Imagenes(R.drawable.inventory, 104)};

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

        int width = (int) getResources().getDimension(R.dimen.imgDashboardWidth);
        int height = (int) getResources().getDimension(R.dimen.imgDashboardHeight);
        ImageView imageView;
        //ArrayList<ImageView> imageViewArrayList = new ArrayList<ImageView>();

        for (int i = 0; i < imagenes.length; i++) {
            imageView = new ImageView(this);
            imageView.setId(imagenes[i].getId());
            imageView.setImageResource(imagenes[i].getImg());

            //imageViewArrayList.add(new ImageView(this));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = width;
            params.height = height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);

            imageView.setLayoutParams(params);
            imageView.setOnClickListener(listenerDashBoard);

            //imageViewArrayList.get(i).setImageResource(imagenes[i]);
            //gridDashBoard.addView(imageViewArrayList.get(i));

            gridDashBoard.addView(imageView);
        }


    }

    //clase para el Onclick de las imagenes
    class ClickListenerDashBoard implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent;
            //la id es el del array de imagenes 0 es la primera imagen del array y asi ...
            switch (view.getId()) {
                case 100:
                    intent = new Intent(DashBoardActivity.this, ProductosActivity.class);
                    startActivity(intent);
                    break;
                case 102:
                    intent = new Intent(DashBoardActivity.this, SectorActivity.class);
                    startActivity(intent);
                    break;
                case 103:
                    intent = new Intent(DashBoardActivity.this, DependencyActivity.class);
                    startActivity(intent);
                    break;
                case 104:
                    intent = new Intent(DashBoardActivity.this, InventoryActivity.class);
                    startActivity(intent);
                    break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_account_setting:
                startActivity(new Intent(DashBoardActivity.this,AccountSettingActivity.class));
                break;

            case R.id.action_general_setting:

                startActivity(new Intent(DashBoardActivity.this,GeneralSettingActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ShowApppreferences(); //hay que comentarlo en application del manifies como name
    }

    private void ShowApppreferences() {
        AppPreferenceshelper sharedPreferences = ((InventoryApplication)getApplicationContext()).getAppPreferencesHelper();
        String message = "Tu usuario es " + sharedPreferences.getCurrentUserName();

        sharedPreferences.setCurrentUserName("juanam Franco");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
