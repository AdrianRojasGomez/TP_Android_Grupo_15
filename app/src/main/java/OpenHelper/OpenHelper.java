package OpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;

import Entidades.Contacto;

public class OpenHelper extends SQLiteOpenHelper {

    public static String ContactosCreationTable =
            "CREATE TABLE IF NOT EXISTS Contactos" +
                    "(_ID integer primary key autoincrement," +
                    "Nombre text NOT NULL, " +
                    "Apellido text NOT NULL, " +
                    "Telefono text NOT NULL, " +
                    "TipoTelefono text NOT NULL, " +
                    "Email text NOT NULL, " +
                    "TipoEmail text NOT NULL, " +
                    "Direccion text NOT NULL, " +
                    "FechaNacimiento text NOT NULL, " +
                    "NivelEstudios text NOT NULL, " +
                    "InteresDeporte integer NOT NULL DEFAULT 0, " +
                    "InteresMusica integer NOT NULL DEFAULT 0, " +
                    "InteresArte integer NOT NULL DEFAULT 0, " +
                    "InteresTecnologia integer NOT NULL DEFAULT 0, " +
                    "RecibirInformacion integer NOT NULL DEFAULT 0)";

    public static String ContactosTable = "Contactos";
    public static String ContactosColumnaID = "_ID";
    public static String ContactosNombre = "Nombre";
    public static String ContactosApellido = "Apellido";
    public static String ContactosTelefono = "Telefono";
    public static String ContactosTipoTelefono = "TipoTelefono";
    public static String ContactosEmail = "Email";
    public static String ContactosTipoEmail = "TipoEmail";
    public static String ContactosDireccion = "Direccion";
    public static String ContactosFechaNacimiento = "FechaNacimiento";
    public static String ContactosNivelEstudios = "NivelEstudios";
    public static String ContactosInteresDeporte = "InteresDeporte";
    public static String ContactosInteresMusica  = "InteresMusica";
    public static String ContactosInteresArte = "InteresArte";
    public static String ContactosInteresTecnologia = "InteresTecnologia";
    public static String ContactosRecibirInformacion = "RecibirInformacion";

    public OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        /// Query de creacion de tabla
        db.execSQL(ContactosCreationTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertarContacto(Contacto contacto)
    {

    }

    public void EliminarContacto(Contacto contacto)
    {

    }

    public ArrayList<Contacto> getListadoContactos() {

        ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
        return listaContactos;

    }
}
