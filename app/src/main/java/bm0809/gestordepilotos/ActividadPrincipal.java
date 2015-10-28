package bm0809.gestordepilotos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActividadPrincipal extends AppCompatActivity {

    protected Context contexto;
    protected ArrayList<Piloto> pilotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contexto = getApplicationContext();


    }

    @Override
    protected void onStart() {
        super.onStart();

        AlmacenPilotos db = new AlmacenPilotos(getApplicationContext());


        db.add(new Piloto(7, "piloto7", 5, "Jaaa", true, "es"));
        db.add(new Piloto(8, "piloto8", 77, "Ksss", false, "es"));
        db.add(new Piloto(9, "piloto9", 88, "Lddd", true, "es"));

        pilotos = db.getAll();
        //Log.i("Numero de filas", String.format("%d", db.count()));
        PilotoAdapter pilotoAdapter = new PilotoAdapter(contexto, pilotos);

        final ListView listView = (ListView) findViewById(R.id.lvListadoPilotos);

        ArrayAdapter<Piloto> adapter = pilotoAdapter;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcionElegida = listView.getItemAtPosition(position).toString();
                //Integer opcionElegida2 = new Integer(position).toString();
                Log.i("Opción elegida", opcionElegida);
                //Toast.makeText(getApplicationContext(), opcionElegida, Toast.LENGTH_SHORT).show();

                lanzarDetallePiloto((Piloto) parent.getItemAtPosition(position));

            }
        });

        ImageButton imageButton = (ImageButton) findViewById(R.id.fab);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNuevoPiloto();
            }
        });

    }

    public void lanzarDetallePiloto(Piloto piloto){

        Intent nuevoIntent = new Intent(ActividadPrincipal.this, MuestraDetalle.class);
        Bundle bundle = new Bundle();
        bundle.putInt("_id", piloto.get_id());
        bundle.putInt("_dorsal", piloto.get_dorsal());
        bundle.putBoolean("_activo", piloto.is_activo());
        bundle.putString("_nombre", piloto.get_nombre());
        bundle.putString("_moto", piloto.get_moto());
        bundle.putString("_imagen_url", piloto.get_imagen());


        nuevoIntent.putExtras(bundle);
        startActivity(nuevoIntent);
    }

    private void addNuevoPiloto() {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
