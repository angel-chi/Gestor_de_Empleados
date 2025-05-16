package mypackage.entities;


public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String matricula;
    private String semestre;
    private String correo_electronico;
    private String numero_telefono;
    private String fecha_inicio;
    private String facultad;
    private int hrsclases;
    private float gastada;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int edad, String genero, String matricula, String semestre, String correo_electronico, String numero_telefono, String fecha_inicio, String facultad, int hrsclases, float gastada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.matricula = matricula;
        this.semestre = semestre;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.facultad = facultad;
        this.hrsclases = hrsclases;
        this.gastada = gastada;
    }

    public Estudiante(int id, String nombre, String apellido, int edad, String genero, String matricula, String semestre, String correo_electronico, String numero_telefono, String fecha_inicio, String facultad, int hrsclases, float gastada) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.matricula = matricula;
        this.semestre = semestre;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.facultad = facultad;
        this.hrsclases = hrsclases;
        this.gastada = gastada;
    }




    public float getGastada() {
        return gastada;
    }
    public void setGastada(float gastada) {
        this.gastada = gastada;
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
    public int getHrsclases() {return hrsclases;}
    public void setHrsclases(int hrsclases) {this.hrsclases = hrsclases;}
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
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    
    
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", matricula=" + matricula + ", semestre=" + semestre + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", fecha_inicio=" + fecha_inicio + ", facultad=" + facultad + "horas de clases="+ hrsclases+ ", gastada=" + gastada + '}';
    }

    
    
    
    
    
}

