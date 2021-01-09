package mypackage.entities;


public class Empleado{
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String tipo_documento;
    private String numero_documento;
    private String correo_electronico;
    private String numero_telefono;
    private String fecha_inicio;
    private int cantidad_hs_semanales;
    private float sueldo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int edad, String genero, String tipo_documento, String numero_documento, String correo_electronico, String numero_telefono, String fecha_inicio, int cantidad_hs_semanales, float sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.cantidad_hs_semanales = cantidad_hs_semanales;
        this.sueldo = sueldo;
    }

    public Empleado(int id, String nombre, String apellido, int edad, String genero, String tipo_documento, String numero_documento, String correo_electronico, String numero_telefono, String fecha_inicio, int cantidad_hs_semanales, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.cantidad_hs_semanales = cantidad_hs_semanales;
        this.sueldo = sueldo;
    }




    public float getSueldo() {
        return sueldo;
    }
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getTipo_documento() {
        return tipo_documento;
    }
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    public String getNumero_documento() {
        return numero_documento;
    }
    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }
    public String getCorreo_electronico() {
        return correo_electronico;
    }
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    public String getNumero_telefono() {
        return numero_telefono;
    }
    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public int getCantidad_hs_semanales() {
        return cantidad_hs_semanales;
    }
    public void setCantidad_hs_semanales(int cantidad_hs_semanales) {
        this.cantidad_hs_semanales = cantidad_hs_semanales;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", fecha_inicio=" + fecha_inicio + ", cantidad_hs_semanales=" + cantidad_hs_semanales + ", sueldo=" + sueldo + '}';
    }

    
    
    
    
    
}

