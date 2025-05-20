
package mypackage.entities;


public class Administracion {
    
    private int id;
    private int id_estudiantes;
    private String puesto;
    private String habilidades;
   
    
    public Administracion() {
    }
    
    
    public Administracion(int id_estudiantes, String puesto, String habilidades) {
        this.id_estudiantes = id_estudiantes;
        this.puesto = puesto;
        this.habilidades = habilidades;
    }
    
    public Administracion(int id, int id_estudiantes, String puesto, String habilidades) {
        this.id = id;
        this.id_estudiantes = id_estudiantes;
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
    public int getId_estudiantes() {
        return id_estudiantes;
    }
    public void setId_estudiantes(int id_estudiantes) {
        this.id_estudiantes = id_estudiantes;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    @Override
    public String toString() {
        return "Administracion{" + "id=" + id + ", id_estudiantes=" + id_estudiantes + ", puesto=" + puesto + ", habilidades=" + habilidades + '}';
    }
    
    
    

}
