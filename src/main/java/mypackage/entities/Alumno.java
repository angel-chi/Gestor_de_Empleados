package mypackage.entities;


public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String semestre;
    private String correo_electronico;
    private String numero_telefono;
    private int matricula;
    private float promedio;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido, int edad, String genero, String semestre, String correo_electronico, String numero_telefono, int matricula, float promedio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.semestre = semestre;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.matricula = matricula;
        this.promedio = promedio;
    }


    public float getPromedio() {
        return promedio;
    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
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
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
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
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    
    
    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", semestre=" + semestre + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", matricula=" + matricula + ", promedio=" + promedio + '}';
    }

    
    
    
    
    
}

