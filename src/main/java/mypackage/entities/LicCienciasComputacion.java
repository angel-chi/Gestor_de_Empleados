
package mypackage.entities;


public class LicCienciasComputacion {
    
    private int id;
    private int id_Estudiantes;
    private String semestre;
    private String optativas;
    private String materias_libres_cursadas;
    
    public LicCienciasComputacion() {
    }
    
    public LicCienciasComputacion(int id_Estudiantes, String semestre, String optativas, String materias_libres_cursadas) {
        this.id_Estudiantes = id_Estudiantes;
        this.semestre = semestre;
        this.optativas = optativas;
        this.materias_libres_cursadas = materias_libres_cursadas;
    }
    
    public LicCienciasComputacion(int id, int id_Estudiantes, String semestre, String optativas, String materias_libres_cursadas) {
        this.id = id;
        this.id_Estudiantes = id_Estudiantes;
        this.semestre = semestre;
        this.optativas = optativas;
        this.materias_libres_cursadas = materias_libres_cursadas;
    }
    
    
    
    public String getMaterias_libres_cursadas() {
        return materias_libres_cursadas;
    }
    public void setMaterias_libres_cursadas(String materias_libres_cursadas) {
        this.materias_libres_cursadas = materias_libres_cursadas;
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
    public String getoptativas() {
        return optativas;
    }
    public void setoptativas(String optativas) {
        this.optativas = optativas;
    }


    @Override
    public String toString() {
        return "Licenciatura en Ciencias de la computación{" + "id=" + id + ", id_Estudiantes=" + id_Estudiantes + ", semestre=" + semestre + ", optativas=" + optativas + ", materias_libres_cursadas=" + materias_libres_cursadas + '}';
    }
    
    
    

}


