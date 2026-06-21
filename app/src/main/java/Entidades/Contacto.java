package Entidades;

public class Contacto {
    /// Datos Primer formulario: Agregar Contactos
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoTelefono;
    private String email;
    private String tipoEmail;
    private String direccion;
    private String fechaNacimiento;


    /// Datos Segundo formulario: Mas Datos Contacto
    private String nivelEstudios;   // valor del RadioGroup
    private boolean interesDeporte;
    private boolean interesMusica;
    private boolean interesArte;
    private boolean interesTecnologia;
    private boolean recibirInformacion; // valor del Switch

    public Contacto() {
    }

    public Contacto(int id, String nombre, String apellido, String telefono, String tipoTelefono, String email, String tipoEmail, String direccion, String fechaNacimiento, String nivelEstudios, boolean interesDeporte, boolean interesMusica, boolean interesArte, boolean interesTecnologia, boolean recibirInformacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoTelefono = tipoTelefono;
        this.email = email;
        this.tipoEmail = tipoEmail;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelEstudios = nivelEstudios;
        this.interesDeporte = interesDeporte;
        this.interesMusica = interesMusica;
        this.interesArte = interesArte;
        this.interesTecnologia = interesTecnologia;
        this.recibirInformacion = recibirInformacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public boolean isInteresDeporte() {
        return interesDeporte;
    }

    public void setInteresDeporte(boolean interesDeporte) {
        this.interesDeporte = interesDeporte;
    }

    public boolean isInteresMusica() {
        return interesMusica;
    }

    public void setInteresMusica(boolean interesMusica) {
        this.interesMusica = interesMusica;
    }

    public boolean isInteresArte() {
        return interesArte;
    }

    public void setInteresArte(boolean interesArte) {
        this.interesArte = interesArte;
    }

    public boolean isInteresTecnologia() {
        return interesTecnologia;
    }

    public void setInteresTecnologia(boolean interesTecnologia) {
        this.interesTecnologia = interesTecnologia;
    }

    public boolean isRecibirInformacion() {
        return recibirInformacion;
    }

    public void setRecibirInformacion(boolean recibirInformacion) {
        this.recibirInformacion = recibirInformacion;
    }
}
