
package mypackage.entities;


public class Matematicas {
    
    private int id;
    private int matricula_estudiante;
    private String nivel;
    private String programa;
    private String estatus;
    private float promedio_actual;
   
    
    public Matematicas() {
    }
    
    
    public Matematicas(int matricula_estudiante, String nivel, String programa, String estatus, int promedio_actual) {
        this.matricula_estudiante = matricula_estudiante;
        this.nivel = nivel;
        this.programa = programa;
        this.estatus = estatus;
        this.promedio_actual = promedio_actual;
    }
    
    
    public Matematicas(int id, int matricula_estudiante, String nivel, String programa, String estatus, int promedio_actual) {
        this.id = id;
        this.matricula_estudiante = matricula_estudiante;
        this.nivel = nivel;
        this.programa = programa;
        this.estatus = estatus;
        this.promedio_actual = promedio_actual;
    }
    public float getPromedio_actual() {
        return promedio_actual;
    }
    public void setPromedio_actual(float promedio_actual) {
        this.promedio_actual = promedio_actual;
    }
    
    
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMatricula_estudiante() {
        return matricula_estudiante;
    }
    public void setMatricula_estudiante(int matricula_estudiante) {
        this.matricula_estudiante = matricula_estudiante;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
    @Override
    public String toString() {
        return "Matematicas{" + "id=" + id + ", matricula_estudiante=" + matricula_estudiante + ", nivel=" + nivel + ", programa=" + programa + ", estatus=" + estatus + ", promedio_actual=" + promedio_actual + '}';
    }
    
    
    

}
