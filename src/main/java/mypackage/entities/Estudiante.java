package mypackage.entities;

public class Estudiante {
    private int id;
    private String matricula;
    private String nombre;
    private String apellido_primero;
    private String apellido_segundo;
    private int edad;
    private String genero;
    private String correo_electronico;
    private String numero_telefono;
    private int horas_semanales;
    private String fecha_inicio;
    private int num_clsases;

    public Estudiante() {
    }

    public Estudiante(
            String matricula,
            String nombre,
            String apellido_primero,
            int edad,
            String genero,
            String correo_electronico,
            String numero_telefono,
            int horas_semanales,
            String fecha_inicio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido_primero = apellido_primero;
        this.apellido_segundo = "";
        this.edad = edad;
        this.genero = genero;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.horas_semanales = horas_semanales;
        this.fecha_inicio = fecha_inicio;
    }

    public Estudiante(int id,
            String nombre,
            String apellido_primero,
            int edad,
            String genero,
            String correo_electronico,
            String numero_telefono,
            String fecha_inicio,
            int horas_semanales,
            int num_clases) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_primero = apellido_primero;
        this.edad = edad;
        this.genero = genero;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.horas_semanales = horas_semanales;
        this.num_clsases = num_clases;
    }

    // Getters

    public Estudiante(
            int id,
            String matricula,
            String nombre,
            String apellido_primero,
            String apellido_segundo,
            int edad,
            String genero,
            String correo_electronico,
            String numero_telefono,
            String fecha_inicio,
            int horas_semanales,
            int num_clases) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido_primero = apellido_primero;
        this.apellido_segundo = apellido_segundo;
        this.edad = edad;
        this.genero = genero;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.horas_semanales = horas_semanales;
        this.fecha_inicio = fecha_inicio;
        this.num_clsases = num_clases;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNum_clsases() {
        return num_clsases;
    }

    public String getApellido_segundo() {
        return apellido_segundo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getApellido_primero() {
        return apellido_primero;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public int getId() {
        return id;
    }

    // Setters

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_primero(String apellido_primero) {
        this.apellido_primero = apellido_primero;
    }

    public void setApellido_segundo(String apellido_segundo) {
        this.apellido_segundo = apellido_segundo;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    public void setNum_clsases(int num_clsases) {
        this.num_clsases = num_clsases;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido_primero + apellido_segundo
                + ", edad=" + edad + ", genero=" + genero + ", correo_electronico=" + correo_electronico
                + ", numero_telefono=" + numero_telefono + ", fecha_inicio=" + fecha_inicio + '}';
    }

}
