
package mypackage.entities;


public class SoporteTecnico {
    
    private int id;
    private int id_estudiantes;
    private String puesto;
    private String formacion;
    private String certificaciones;
    
    public SoporteTecnico() {
    }
    
    public SoporteTecnico(int id_estudiantes, String puesto, String formacion, String certificaciones) {
        this.id_estudiantes = id_estudiantes;
        this.puesto = puesto;
        this.formacion = formacion;
        this.certificaciones = certificaciones;
    }
    
    public SoporteTecnico(int id, int id_estudiantes, String puesto, String formacion, String certificaciones) {
        this.id = id;
        this.id_estudiantes = id_estudiantes;
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
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }


    @Override
    public String toString() {
        return "SoporteTecnico{" + "id=" + id + ", id_estudiantes=" + id_estudiantes + ", puesto=" + puesto + ", formacion=" + formacion + ", certificaciones=" + certificaciones + '}';
    }
    
    
    

}


