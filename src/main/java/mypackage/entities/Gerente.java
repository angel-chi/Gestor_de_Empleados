
package mypackage.entities;


public class Gerente {
    
    private int id;
    private int id_students;
    private String sector;
    private String formacion;
    private int antiguedad;
    
    public Gerente() {
    }
    
    public Gerente(int id_students, String sector, String formacion, int antiguedad) {
        this.id_students = id_students;
        this.sector = sector;
        this.formacion = formacion;
        this.antiguedad = antiguedad;
    }
    
    public Gerente(int id, int id_students, String sector, String formacion, int antiguedad) {
        this.id = id;
        this.id_students = id_students;
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
    public int getId_students() {
        return id_students;
    }
    public void setId_students(int id_students) {
        this.id_students = id_students;
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
        return "Gerente{" + "id=" + id + ", id_students=" + id_students + ", sector=" + sector + ", formacion=" + formacion + ", antiguedad=" + antiguedad + '}';
    }
    
    

}
