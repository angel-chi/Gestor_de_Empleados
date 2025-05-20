
package mypackage.entities;


public class Administracion {
    
    private int id;
    private int id_empleados;
    private String puesto;
    private String habilidades;
   
    
    public Administracion() {
    }
    
    
    public Administracion(int id_empleados, String puesto, String habilidades) {
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.habilidades = habilidades;
    }
    
    public Administracion(int id, int id_empleados, String puesto, String habilidades) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.habilidades = habilidades;
    }
    
    
    
    
    public String getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_alumnos() {
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
    
    
    @Override
    public String toString() {
        return "Administracion{" + "id=" + id + ", id_empleados=" + id_empleados + ", puesto=" + puesto + ", habilidades=" + habilidades + '}';
    }
    
    
    

}
