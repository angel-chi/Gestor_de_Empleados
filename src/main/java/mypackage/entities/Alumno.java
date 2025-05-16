package mypackage.entities;


public class Alumno{
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String curso;
    private String matricula;;
    private double promedio;
    private String fecha_ingreso;
    private String email;


    public Alumno(String nombre, String apellido, int edad, String genero, String curso, String matricula, double promedio, String fecha_ingreso, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.curso = curso;
        this.matricula = matricula;
        this.promedio = promedio;
        this.fecha_ingreso = fecha_ingreso;
        this.email = email;

    }
    public Alumno(){

    }

    public Alumno(int id, String nombre, String apellido, int edad, String genero, String curso, String matricula, double promedio, String fecha_ingreso, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.curso = curso;
        this.matricula = matricula;
        this.promedio = promedio;
        this.fecha_ingreso = fecha_ingreso;
        this.email = email;

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
    public String getCurso() {return curso;}
    public void setCurso(String curso) {this.curso = curso;}
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public double getPromedio() {return promedio;}
    public void setPromedio(double promedio) {this.promedio = promedio;}
    public String getFecha_ingreso() {return fecha_ingreso;}
    public void setFecha_ingreso(String fecha_ingreso) {this.fecha_ingreso = fecha_ingreso;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", curso='" + curso + '\'' +
                ", matricula='" + matricula + '\'' +
                ", promedio=" + promedio +
                ", fecha_ingreso='" + fecha_ingreso + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

