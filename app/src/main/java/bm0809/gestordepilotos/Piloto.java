package bm0809.gestordepilotos;

public class Piloto {
    private int _id;
    private String _nombre;
    private int _dorsal;
    private String _moto;
    private  boolean _activo;


    //Constructor

    public Piloto(int _id, String _nombre, int _dorsal, String _moto, boolean _activo) {
        this._id = _id;
        this._nombre = _nombre;
        this._dorsal = _dorsal;
        this._moto = _moto;
        this._activo = _activo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int get_dorsal() {
        return _dorsal;
    }

    public void set_dorsal(int _dorsal) {
        this._dorsal = _dorsal;
    }

    public String get_moto() {
        return _moto;
    }

    public void set_moto(String _moto) {
        this._moto = _moto;
    }

    public boolean is_activo() {
        return _activo;
    }

    public void set_activo(boolean _activo) {
        this._activo = _activo;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "_id=" + _id +
                ", _nombre='" + _nombre + '\'' +
                ", _dorsal=" + _dorsal +
                ", _moto='" + _moto + '\'' +
                ", _activo=" + _activo +
                '}';
    }
}
