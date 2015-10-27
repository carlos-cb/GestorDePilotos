package bm0809.gestordepilotos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static bm0809.gestordepilotos.PilotoContract.tablaPiloto;

public class AlmacenPilotos extends SQLiteOpenHelper{

    //Nombre del fichero de BD
    protected static final String DEFAULT_DB_FILENAME = "pilotos.db";

    protected static final int DATABASE_VERSION = 1;

    public AlmacenPilotos(Context context){
        super(context, DEFAULT_DB_FILENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String consultaSQL = "CREATE TABLE " + tablaPiloto.TABLE_NAME + " ("
                + tablaPiloto.COL_NAME_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + tablaPiloto.COL_NAME_NOMBRE + " TEST,"
                + tablaPiloto.COL_NAME_DORSAL + " TEXT,"
                + tablaPiloto.COL_NAME_MOTO + " INTEGER,"
                +tablaPiloto.COL_NAME_ACTIVO + " INTEGER)";
        db.execSQL(consultaSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String consultaSQL = "DROP TABLE " + tablaPiloto.TABLE_NAME;
        db.execSQL(consultaSQL);
        onCreate(db);
    }

    public void add(Piloto piloto){
        //String consultaSQL = " INSERT " + tablaPiloto.TABLE_NAME +

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(tablaPiloto.COL_NAME_ID, piloto.get_id());
        values.put(tablaPiloto.COL_NAME_NOMBRE, piloto.get_nombre());
        values.put(tablaPiloto.COL_NAME_DORSAL, piloto.get_dorsal());
        values.put(tablaPiloto.COL_NAME_MOTO, piloto.get_moto());
        values.put(tablaPiloto.COL_NAME_ACTIVO, piloto.is_activo());
        db.insert(tablaPiloto.TABLE_NAME, null, values);

    }



}
