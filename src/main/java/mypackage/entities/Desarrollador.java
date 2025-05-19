
package mypackage.entities;


public class Desarrollador {
    
    private int id;
    private int id_empleados;
    private String puesto;
    private String certificaciones;
    private String habilidades;
    private int proyectos_en_produccion;
   
    
    public Desarrollador() {
    }
    
    
    public Desarrollador(int id_empleados, String puesto, String certificaciones, String habilidades, int proyectos_en_produccion) {
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.certificaciones = certificaciones;
        this.habilidades = habilidades;
        this.proyectos_en_produccion = proyectos_en_produccion;
    }
    
    
    public Desarrollador(int id, int id_empleados, String puesto, String certificaciones, String habilidades, int proyectos_en_produccion) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.certificaciones = certificaciones;
        this.habilidades = habilidades;
        this.proyectos_en_produccion = proyectos_en_produccion;
    }
    public int getProyectos_en_produccion() {
        return proyectos_en_produccion;
    }
    public void setProyectos_en_produccion(int proyectos_en_produccion) {
        this.proyectos_en_produccion = proyectos_en_produccion;
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
    public String getCertificaciones() {
        return certificaciones;
    }
    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }
    public String getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    
    
    @Override
    public String toString() {
        return "Desarrollador{" + "id=" + id + ", id_empleados=" + id_empleados + ", puesto=" + puesto + ", certificaciones=" + certificaciones + ", habilidades=" + habilidades + ", proyectos_en_produccion=" + proyectos_en_produccion + '}';
    }
    
    
    

}
