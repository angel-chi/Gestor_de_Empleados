
package mypackage.entities;


public class SoporteTecnico {
    
    private int id;
    private int id_empleados;
    private String puesto;
    private String formacion;
    private String certificaciones;
    
    public SoporteTecnico() {
    }
    
    public SoporteTecnico(int id_empleados, String puesto, String formacion, String certificaciones) {
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.formacion = formacion;
        this.certificaciones = certificaciones;
    }
    
    public SoporteTecnico(int id, int id_empleados, String puesto, String formacion, String certificaciones) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.formacion = formacion;
        this.certificaciones = certificaciones;
    }
    
    
    
    public String getCertificaciones() {
        return certificaciones;
    }
    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_estudiantes() {
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
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }


    @Override
    public String toString() {
        return "SoporteTecnico{" + "id=" + id + ", id_empleados=" + id_empleados + ", puesto=" + puesto + ", formacion=" + formacion + ", certificaciones=" + certificaciones + '}';
    }
    
    
    

}


