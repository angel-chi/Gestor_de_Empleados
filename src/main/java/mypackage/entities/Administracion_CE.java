
package mypackage.entities;


public class Administracion_CE {//Administracion de la escuela, control escolar.
    
    private int id;
    private int id_empleados;
    private String area_puesto;
    private String conocimientos; //no me convence, pensad en cambiar
   
    
    public Administracion_CE() {
    }
    
    
    public Administracion_CE(int id_empleados, String puesto, String conocimientos) {
        this.id_empleados = id_empleados;
        this.area_puesto = puesto;
        this.conocimientos = conocimientos;
    }
    
    public Administracion_CE(int id, int id_empleados, String puesto, String conocimientos) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.area_puesto = puesto;
        this.conocimientos = conocimientos;
    }
    
    
    
    
    public String getConocimientos() {
        return conocimientos;
    }
    public void setConocimientos(String conocimientos) {
        this.conocimientos = conocimientos;
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
        return area_puesto;
    }
    public void setPuesto(String puesto) {
        this.area_puesto = puesto;
    }
    
    
    @Override
    public String toString() {
        return "Administracion_Control Escolar{" + "id=" + id + ", id_empleados=" + id_empleados + ", puesto=" + area_puesto + ", habilidades=" + conocimientos + '}';
    }
    
    
    

}
