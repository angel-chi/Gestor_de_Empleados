
package mypackage.entities;


public class Quimica {
    
    private int id;
    private int matricula_estudiante;
    private String nivel;
    private String programa;
    private String estatus;
    
    public Quimica() {
    }
    
    public Quimica(int matricula_estudiante, String nivel, String programa, String estatus) {
        this.matricula_estudiante = matricula_estudiante;
        this.nivel = nivel;
        this.programa = programa;
        this.estatus = estatus;
    }
    
    public Quimica(int id, int matricula_estudiante, String nivel, String programa, String estatus) {
        this.id = id;
        this.matricula_estudiante = matricula_estudiante;
        this.nivel = nivel;
        this.programa = programa;
        this.estatus = estatus;
    }
    
    
    
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
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


    @Override
    public String toString() {
        return "SoporteTecnico{" + "id=" + id + ", matricula_estudiante=" + matricula_estudiante + ", nivel=" + nivel + ", programa=" + programa + ", estatus=" + estatus + '}';
    }
    
    
    

}


