
package mypackage.entities;


public class SoporteTecnico {
    
    private int id;
    private int id_students;
    private String puesto;
    private String formacion;
    private String certificaciones;
    
    public SoporteTecnico() {
    }
    
    public SoporteTecnico(int id_students, String puesto, String formacion, String certificaciones) {
        this.id_students = id_students;
        this.puesto = puesto;
        this.formacion = formacion;
        this.certificaciones = certificaciones;
    }
    
    public SoporteTecnico(int id, int id_students, String puesto, String formacion, String certificaciones) {
        this.id = id;
        this.id_students = id_students;
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
    public int getId_students() {
        return id_students;
    }
    public void setId_students(int id_students) {
        this.id_students = id_students;
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
        return "SoporteTecnico{" + "id=" + id + ", id_students=" + id_students + ", puesto=" + puesto + ", formacion=" + formacion + ", certificaciones=" + certificaciones + '}';
    }
    
    
    

}


