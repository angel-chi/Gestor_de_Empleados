package mypackage.entities;


public class Student{
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String grado;
    private String matricula;
    private String correo_electronico;
    private String numero_telefono;
    private String semestre;
    private int cantidad_hs_escolares;
    private float mesada;

    public Student() {
    }

    public Student(String nombre, String apellido, int edad, String genero, String grado, String matricula, String correo_electronico, String numero_telefono, String semestre, int cantidad_hs_escolares, float mesada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.grado = grado;
        this.matricula = matricula;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.semestre = semestre;
        this.cantidad_hs_escolares = cantidad_hs_escolares;
        this.mesada = mesada;
    }

    public Student(int id, String nombre, String apellido, int edad, String genero, String grado, String matricula, String correo_electronico, String numero_telefono, String semestre, int cantidad_hs_escolares, float mesada) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.grado = grado;
        this.matricula = matricula;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.semestre = semestre;
        this.cantidad_hs_escolares = cantidad_hs_escolares;
        this.mesada = mesada;
    }




    public float getMesada() {
        return mesada;
    }
    public void setMesada(float mesada) {
        this.mesada = mesada;
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
    public String getGrado() {
        return grado;
    }
    public void setGrado (String grado) {
        this.grado = grado;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public int getCantidad_hs_escolares() {
        return cantidad_hs_escolares;
    }
    public void setCantidad_hs_escolares(int cantidad_hs_escolares) {
        this.cantidad_hs_escolares = cantidad_hs_escolares;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    
    
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", grado=" + grado + ", matricula=" + matricula + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", semestre=" + semestre + ", cantidad_hs_escolares=" + cantidad_hs_escolares + ", mesada=" + mesada + '}';
    }

    
    
    
    
    
}

