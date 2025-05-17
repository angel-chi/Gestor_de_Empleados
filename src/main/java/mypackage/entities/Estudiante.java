package mypackage.entities;


public class Estudiante {
    private int matricula;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String numero_telefono;
    private String domicilio;
    private String correo_electronico;
    private String tipo_estudiante;
    private String modalidad;
    private int anio_ingreso;
    private float promedio_ingreso;

    public Estudiante() {
    }



    public Estudiante(String nombre, String apellido, int edad, String genero, String modalidad, String tipo_estudiante, String correo_electronico, String numero_telefono, String domicilio, int anio_ingreso, float promedio_ingreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.modalidad = modalidad;
        this.tipo_estudiante = tipo_estudiante;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.domicilio = domicilio;
        this.anio_ingreso = anio_ingreso;
        this.promedio_ingreso = promedio_ingreso;
    }

    public Estudiante(int matricula, String nombre, String apellido, int edad, String genero, String modalidad, String tipo_estudiante, String correo_electronico, String numero_telefono, String domicilio, int anio_ingreso, float promedio_ingreso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.modalidad = modalidad;
        this.tipo_estudiante = tipo_estudiante;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.domicilio = domicilio;
        this.anio_ingreso = anio_ingreso;
        this.promedio_ingreso = promedio_ingreso;
    }




    public float getPromedio_ingreso() {
        return promedio_ingreso;
    }
    public void setPromedio_ingreso(float promedio_ingreso) {
        this.promedio_ingreso = promedio_ingreso;
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
    public String getModalidad() {
        return modalidad;
    }
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
    public String getTipo_estudiante() {
        return tipo_estudiante;
    }
    public void setTipo_estudiante(String tipo_estudiante) {
        this.tipo_estudiante = tipo_estudiante;
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
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public int getAnio_ingreso() {
        return anio_ingreso;
    }
    public void setAnio_ingreso(int anio_ingreso) {
        this.anio_ingreso = anio_ingreso;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
   
    
    
    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", modalidad=" + modalidad + ", tipo_estudiante=" + tipo_estudiante + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", domicilio=" + domicilio + ", año ingreso=" + anio_ingreso + ", promedio_ingreso=" + promedio_ingreso + '}';
    }

    
    
    
    
    
}

