package mypackage.entities;


public class Student {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String tipo_documento;
    private String numero_de_matricula;
    private String correo_electronico;
    private String numero_telefono;
    private String fecha_inicio;
    private int SemestreEquivalente;
    private float Promedio;

    public Student() {
    }

    public Student(String nombre, String apellido, int edad, String genero, String tipo_documento, String numero_de_matricula, String correo_electronico, String numero_telefono, String fecha_inicio, int SemestreEquivalente, float Promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.tipo_documento = tipo_documento;
        this.numero_de_matricula = numero_de_matricula;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.SemestreEquivalente = SemestreEquivalente;
        this.Promedio = Promedio;
    }

    public Student(int id, String nombre, String apellido, int edad, String genero, String tipo_documento, String numero_de_matricula, String correo_electronico, String numero_telefono, String fecha_inicio, int SemestreEquivalente, float Promedio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.tipo_documento = tipo_documento;
        this.numero_de_matricula = numero_de_matricula;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.fecha_inicio = fecha_inicio;
        this.SemestreEquivalente = SemestreEquivalente;
        this.Promedio = Promedio;
    }




    public float getPromedio() {
        return Promedio;
    }
    public void setPromedio(float promedio) {
        this.Promedio = promedio;
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
    public String getTipo_documento() {
        return tipo_documento;
    }
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    public String getNumero_de_matricula() {
        return numero_de_matricula;
    }
    public void setNumero_de_matricula(String numero_de_matricula) {
        this.numero_de_matricula = numero_de_matricula;
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
    public String getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public int getSemestreEquivalente() {
        return SemestreEquivalente;
    }
    public void setSemestreEquivalente(int semestreEquivalente) {
        this.SemestreEquivalente = semestreEquivalente;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_de_matricula + ", correo_electronico=" + correo_electronico + ", numero_telefono=" + numero_telefono + ", fecha_inicio=" + fecha_inicio + ", cantidad_hs_semanales=" + SemestreEquivalente + ", sueldo=" + Promedio + '}';
    }

    
    
    
    
    
}

