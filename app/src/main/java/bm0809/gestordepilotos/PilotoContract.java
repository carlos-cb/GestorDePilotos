package bm0809.gestordepilotos;


import android.provider.BaseColumns;

public class PilotoContract {

    public PilotoContract() {

    }

    public static class tablaPiloto implements BaseColumns{

        public static final String TABLE_NAME = "pilotos";
        public static final String COL_NAME_ID = "id";
        public static final String COL_NAME_NOMBRE = "nombre";
        public static final String COL_NAME_DORSAL = "dorsal";
        public static final String COL_NAME_MOTO = "moto";
        public static final String COL_NAME_ACTIVO = "activo";
        public static final String COL_NAME_IMAGEN = "imagen_url";
    }



}
