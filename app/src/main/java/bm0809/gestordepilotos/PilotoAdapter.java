package bm0809.gestordepilotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class PilotoAdapter extends ArrayAdapter<Piloto> {
    private Context _contexto;
    private ArrayList<Piloto> _pilotos;

    public PilotoAdapter(Context contexto, ArrayList<Piloto> pilotos){
        super(contexto, R.layout.listado, pilotos);
        this._contexto = contexto;
        this._pilotos = pilotos;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) _contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listado, null);
        }

        Piloto piloto = _pilotos.get(position);
        if (piloto != null){
            TextView tvID = (TextView) convertView.findViewById(R.id.tvId);
            tvID.setText(String.format("%d", piloto.get_id()));

            TextView tvNAME = (TextView) convertView.findViewById(R.id.tvName);
            tvNAME.setText(piloto.get_nombre());

            TextView tvDORSAL = (TextView) convertView.findViewById(R.id.tvDorsal);
            tvDORSAL.setText(String.format("%d", piloto.get_dorsal()));

            TextView tvMOTO = (TextView) convertView.findViewById(R.id.tvMoto);
            tvMOTO.setText(piloto.get_moto());

            CheckBox tvACTIVO = (CheckBox) convertView.findViewById(R.id.tvActivo);
            tvACTIVO.setClickable(false);
            tvACTIVO.setFocusable(false);
            tvACTIVO.setFocusableInTouchMode(false);
            tvACTIVO.setChecked(piloto.is_activo());
        }

        return convertView;
    }


}
