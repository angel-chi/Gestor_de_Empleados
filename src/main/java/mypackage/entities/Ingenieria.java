
package mypackage.entities;


public class Ingenieria {
    
    private int id;
    private int matricula_estudiante;
    private String nivel;
    private String programa;
   
    
    public Ingenieria() {
    }
    
    
    public Ingenieria(int matricula_estudiante, String nivel, String programa) {
        this.matricula_estudiante = matricula_estudiante;
        this.nivel = nivel;
        this.programa = programa;
    }
    
    public Ingenieria(int id, int matricula_estudiante, String nivel, String programa) {
        this.id = id;
        this.matricula_estudiante = matricula_estudiante;
        this.nivel = nivel;
        this.programa = programa;
    }
    
    
    
    
    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
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
    
    
    @Override
    public String toString() {
        return "Administracion{" + "id=" + id + ", matricula_estudiante=" + matricula_estudiante + ", nivel=" + nivel + ", programa=" + programa + '}';
    }

    
    

}
