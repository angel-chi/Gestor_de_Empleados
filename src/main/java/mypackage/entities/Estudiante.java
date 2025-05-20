package mypackage.entities;


public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String correo_electronico;
    private long numero_telefono;
    private int num_materias;
    private long matricula;
    private int semestre;

    public Estudiante(String oscar, String mastruli, int i, String masculino, String dni, String number, String mail, String id, String s, int i1, float v) {
    }

    public Estudiante(String nombre, String apellido, int edad, String genero, String correo_electronico, long numero_telefono, int num_materias, long matricula, int semestre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.num_materias = num_materias;
        this.matricula = matricula;
        this.semestre = semestre;
    }

    public Estudiante(int id, String nombre, String apellido, int edad, String genero, String correo_electronico, long numero_telefono, int num_materias, long matricula, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.num_materias = num_materias;
        this.matricula = matricula;
        this.semestre = semestre;
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
    public String getCorreo_electronico() {
        return correo_electronico;
    }
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    public long getNumero_telefono() {
        return numero_telefono;
    }
    public void setNumero_telefono(long numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
    public float getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public int getNum_materias() {
        return num_materias;
    }
    public void setNum_materias(int num_materias) {
        this.num_materias = num_materias;
    }
    public long getMatricula() {return matricula; }
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

   
    
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", num:materias=" + num_materias + ", matricula=" + matricula + ", semestreo=" + semestre + '}';
    }

    
    
    
    
    
}

