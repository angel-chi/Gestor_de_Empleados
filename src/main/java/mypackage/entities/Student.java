package mypackage.entities;


public class Student {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String facultad;
    private String carrera;
    private String correo_istitucional;
    private String numero_telefono;
    private int semestre;
    private int promedio;

    public Student() {
    }

    public Student(String id, String nombre, String apellido, int edad, String genero, String facultad, String carrera, String correo_institucional, String numero_telefono, int semestre, int promedio){     //(String nombre, String apellido, int edad, String genero, String tipo_documento, String numero_documento, String correo_electronico, String numero_telefono, String fecha_inicio, int cantidad_hs_semanales, float sueldo) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.facultad=facultad;///anexado
        this.carrera=carrera;
        this.correo_istitucional = correo_institucional;///anexado
        this.numero_telefono = numero_telefono;
        this.semestre=semestre;
        this.promedio=promedio;
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

    public String getNumero_telefono() {
        return numero_telefono;
    }
    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

///
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCorreo_istitucional() {
        return correo_istitucional;
    }

    public void setCorreo_istitucional(String correo_istitucional) {
        this.correo_istitucional = correo_istitucional;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    ///
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", facultad=" + facultad + ", carrera=" + carrera + ", correo_institucional=" + correo_istitucional + ", numero_telefono=" + numero_telefono + ",semestre=" + semestre + ", promedio=" + promedio + '}';
    }

    
    
    
    
    
}

