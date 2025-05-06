
package mypackage.entities;


public class Gerente {
    
    private int id;
    private int id_empleados;
    private String sector;
    private String formacion;
    private int antiguedad;
    
    public Gerente() {
    }
    
    public Gerente(int id_empleados, String sector, String formacion, int antiguedad) {
        this.id_empleados = id_empleados;
        this.sector = sector;
        this.formacion = formacion;
        this.antiguedad = antiguedad;
    }
    
    public Gerente(int id, int id_empleados, String sector, String formacion, int antiguedad) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.sector = sector;
        this.formacion = formacion;
        this.antiguedad = antiguedad;
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
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
        @Override
    public String toString() {
        return "Gerente{" + "id=" + id + ", id_empleados=" + id_empleados + ", sector=" + sector + ", formacion=" + formacion + ", antiguedad=" + antiguedad + '}';
    }
    
    

}
