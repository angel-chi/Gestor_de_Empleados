
package mypackage.entities;


public class Profesores {
    
    private int id;
    private int id_empleados;
    private String puesto;
    private String titulo;
    private int antiguedad;
    
    public Profesores() {
    }
    
    public Profesores(int id_empleados, String puesto, String titulo, int antiguedad) {
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.titulo = titulo;
        this.antiguedad = antiguedad;
    }
    
    public Profesores(int id, int id_empleados, String puesto, String titulo, int antiguedad) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.titulo = titulo;
        this.antiguedad = antiguedad;
    }
    
   

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_empleados() {
        return id_empleados;
    }
    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
        @Override
    public String toString() {
        return "Profesores{" + "id=" + id + ", id_empleados=" + id_empleados + ", puesto=" + puesto + ", titulo=" + titulo + ", antiguedad=" + antiguedad + '}';
    }
    
    

}
