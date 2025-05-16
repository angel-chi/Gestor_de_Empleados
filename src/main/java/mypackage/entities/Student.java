package mypackage.entities;


public class Student {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String correo_electronico;
    private long numero_telefono;
    private int cantidad_materias;
    private long matricula;
    private int semestre;


    public Student() {
    }

    public Student(int i, String nombre, String apellido, int edad, int semestre, String genero, int cantidad_materias, String correo_electronico, long numero_telefono, long matricula, int i1, float v) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.semestre = semestre;
        this.genero = genero;
        this.cantidad_materias = cantidad_materias;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.matricula = matricula;
    }

    public Student(int id, String nombre, String apellido,int edad,  String genero, String correo_electronico, long numero_telefono, int cantidad_materias, long matricula, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.edad = edad;
        this.genero = genero;
        this.cantidad_materias = cantidad_materias;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.matricula = matricula;
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
    public void setSemestre(int semestre) {this.semestre = semestre;}
    public int getSemestre() { return semestre; }
    public int getCantidad_materias() {
        return cantidad_materias;
    }
    public void setCantidad_materias(int cantidad_materias) {
        this.cantidad_materias = cantidad_materias;
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
    public long getMatricula() {
        return matricula;
    }
    public void setMatricula(long matricula) {
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
        return "Student{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", Materias=" + cantidad_materias + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", cantidad_hs_semanales=" + matricula + '}';
    }

    
    
    
    
    
}

