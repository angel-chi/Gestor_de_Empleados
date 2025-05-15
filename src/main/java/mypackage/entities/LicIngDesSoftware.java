
package mypackage.entities;
//LicIngDesSoftware

public class LicIngDesSoftware {
    
    private int id;
    private int id_Estudiantes;
    private String semestre;
    private String materias_debidas;
   
    
    public LicIngDesSoftware() {
    }
    
    
    public LicIngDesSoftware(int id_Estudiantes, String semestre, String materias_debidas) {
        this.id_Estudiantes = id_Estudiantes;
        this.semestre = semestre;
        this.materias_debidas = materias_debidas;
    }
    
    public LicIngDesSoftware(int id, int id_Estudiantes, String semestre, String materias_debidas) {
        this.id = id;
        this.id_Estudiantes = id_Estudiantes;
        this.semestre = semestre;
        this.materias_debidas = materias_debidas;
    }
    
    
    
    
    public String getMaterias_debidas() {
        return materias_debidas;
    }
    public void setMaterias_debidas(String materias_debidas) {
        this.materias_debidas = materias_debidas;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_Estudiantes() {
        return id_Estudiantes;
    }
    public void setId_Estudiantes(int id_Estudiantes) {
        this.id_Estudiantes = id_Estudiantes;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    
    @Override
    public String toString() {
        return "licIngDesSoftware{" + "id=" + id + ", id_Estudiantes=" + id_Estudiantes + ", semestre=" + semestre + ", materias_debidas=" + materias_debidas + '}';
    }
    
    
    

}
