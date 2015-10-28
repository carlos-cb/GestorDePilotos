package bm0809.gestordepilotos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
        ImageView tvDetalle_imagen = (ImageView) findViewById(R.id.detalle_imagen);

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

        tvDetalle_imagen.setTag(bundle.getString("_imagen_url"));
        MostrarImagen mostrar = new MostrarImagen();
        mostrar.execute(tvDetalle_imagen);

    }

    protected class MostrarImagen extends AsyncTask<ImageView, Void, Bitmap> {

        ImageView imageView = null;
        @Override
        protected Bitmap doInBackground(ImageView... imageViews) {
            this.imageView = imageViews [0];
            return download_Image((String) imageView.getTag());
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }

        private Bitmap download_Image(String url) {
            Bitmap bmp = null;

            try {
                URL ulrn = new URL(url);
                HttpURLConnection con = (HttpURLConnection) ulrn.openConnection();
                InputStream is = con.getInputStream();
                bmp = BitmapFactory.decodeStream(is);
                if (bmp != null)
                    return bmp;

            } catch (Exception e) {
                Log.e("ERROR", e.getMessage());
            }
            return bmp;
        }
    }

}
