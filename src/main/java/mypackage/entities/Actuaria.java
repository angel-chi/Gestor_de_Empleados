
package mypackage.entities;


public class Actuaria {
    
    private int id;
    private int id_Estudiantes;
    private String semestre;
    private String materias_libres_cursadas;
    private String materias_debidas;
    private int creditos_cursados;
   
    
    public Actuaria() {
    }
    
    
    public Actuaria(int id_Estudiantes, String semestre, String materias_libres_cursadas, String materias_debidas, int creditos_cursados) {
        this.id_Estudiantes = id_Estudiantes;
        this.semestre = semestre;
        this.materias_libres_cursadas = materias_libres_cursadas;
        this.materias_debidas = materias_debidas;
        this.creditos_cursados = creditos_cursados;
    }
    
    
    public Actuaria(int id, int id_Estudiantes, String semestre, String materias_libres_cursadas, String materias_debidas, int creditos_cursados) {
        this.id = id;
        this.id_Estudiantes = id_Estudiantes;
        this.semestre = semestre;
        this.materias_libres_cursadas = materias_libres_cursadas;
        this.materias_debidas = materias_debidas;
        this.creditos_cursados = creditos_cursados;
    }
    public int getCreditos_cursados() {
        return creditos_cursados;
    }
    public void setCreditos_cursados(int creditos_cursados) {
        this.creditos_cursados = creditos_cursados;
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
    public String getMaterias_libres_cursadas() {
        return materias_libres_cursadas;
    }
    public void setMaterias_libres_cursadas(String materias_libres_cursadas) {
        this.materias_libres_cursadas = materias_libres_cursadas;
    }
    public String getMaterias_debidas() {
        return materias_debidas;
    }
    public void setMaterias_debidas(String materias_debidas) {
        this.materias_debidas = materias_debidas;
    }
    
    
    @Override
    public String toString() {
        return "Actuaria{" + "id=" + id + ", id_Estudiantes=" + id_Estudiantes + ", semestre=" + semestre + ", materias_libres_cursadas=" + materias_libres_cursadas + ", materias_debidas=" + materias_debidas + ", creditos_cursados=" + creditos_cursados + '}';
    }
    
    
    

}
