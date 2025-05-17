package mypackage.entities;


public class Alumnos {
    private int matricula; //similar al ID
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String semestre;
    private String correo;
    private String telefono;
    private String inicio_semestre;
    private String fin_semestre;
    // la cantidad de materias que esta cursando en el semestre inscrito
    private float promedio;//por presicion
    private int id;


    public Alumnos() {
    }

    public Alumnos(int id, String nombre, String apellido, int edad, String genero, String semestre, String fin_semestre, String correo, String telefono, String inicio_semestre, int matricula, float promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.semestre = semestre;
        this.fin_semestre = fin_semestre;
        this.correo = correo;
        this.telefono = telefono;
        this.inicio_semestre = inicio_semestre;
        this.matricula = matricula;
        this.promedio = promedio;//**************************************
    }

    public Alumnos(int matricula, String nombre, String apellido, int edad, String genero, String semestre, String fin_semestre, String correo, String telefono, String inicio_semestre, float promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.semestre = semestre;
        this.fin_semestre = fin_semestre;
        this.correo = correo;
        this.telefono = telefono;
        this.inicio_semestre = inicio_semestre;
        this.matricula = matricula;
        this.promedio = promedio;//**************************************************
    }




    public float getpromedio() {
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
    public String getfin_semestre() {
        return fin_semestre;
    }
    public void setFin_semestre(String fin_semestre) {
        this.fin_semestre = fin_semestre;
    }
    public String getcorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String gettelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getinicio_semestre() {
        return inicio_semestre;
    }
    public void setInicio_semestre(String inicio_semestre) {
        this.inicio_semestre = inicio_semestre;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
   
    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "id=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", semestre=" + semestre +  ", correo_electronico=" + correo + ", numero_telefono=" + telefono + ", fecha_inicio_periodo=" + inicio_semestre + ", fecha_final_periodo=" + fin_semestre +", materias=" + matricula + ", calificación=" + promedio + '}';
    }

    
    
    
    
    
}

