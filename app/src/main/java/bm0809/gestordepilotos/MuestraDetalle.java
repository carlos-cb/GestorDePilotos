package bm0809.gestordepilotos;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

public class MuestraDetalle extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);

        TextView tvDetalle_id = (TextView) findViewById(R.id.detalle_id);
        TextView tvDetalle_nombre = (TextView) findViewById(R.id.detalle_nombre);
        TextView tvDetalle_dorsal = (TextView) findViewById(R.id.detalle_dorsal);
        TextView tvDetalle_moto = (TextView) findViewById(R.id.detalle_moto);
        CheckBox tvDetalle_activo = (CheckBox) findViewById(R.id.detalle_activo);

        Bundle bundle = this.getIntent().getExtras();

        tvDetalle_id.setText("Id: " + bundle.getInt("_id"));
        tvDetalle_nombre.setText("Nombre: " + bundle.getString("_nombre"));
        tvDetalle_dorsal.setText("Dorsal: " + bundle.getInt("_dorsal"));
        tvDetalle_moto.setText("Moto: " + bundle.getString("_moto"));
        tvDetalle_activo.setChecked(bundle.getBoolean("_activo"));
        tvDetalle_activo.setText("Estado");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setResult(RESULT_OK);


    }
}
