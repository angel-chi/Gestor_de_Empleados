
package mypackage.entities;


public class Administracion {
    
    private int id;
    private int id_students;
    private String puesto;
    private String habilidades;
   
    
    public Administracion() {
    }
    
    
    public Administracion(int id_students, String puesto, String habilidades) {
        this.id_students = id_students;
        this.puesto = puesto;
        this.habilidades = habilidades;
    }
    
    public Administracion(int id, int id_students, String puesto, String habilidades) {
        this.id = id;
        this.id_students = id_students;
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
    public int getId_students() {return id_students;}
    public void setId_students(int id_students) {this.id_students = id_students;}
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    @Override
    public String toString() {
        return "Administracion{" + "id=" + id + ", id_students=" + id_students + ", puesto=" + puesto + ", habilidades=" + habilidades + '}';
    }
    
    
    

}
