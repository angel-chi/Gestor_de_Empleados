
package mypackage.entities;


public class PresidenteEstudiantil {
    
    private int id;
    private int matricula_estudiante;
    private String facultad;
    private String periodo;
    private int cantidad_proyectos;
    
    public PresidenteEstudiantil() {
    }
    
    public PresidenteEstudiantil(int matricula_estudiante, String facultad, String periodo, int cantidad_proyectos) {
        this.matricula_estudiante = matricula_estudiante;
        this.facultad = facultad;
        this.periodo = periodo;
        this.cantidad_proyectos = cantidad_proyectos;
    }
    
    public PresidenteEstudiantil(int id, int matricula_estudiante, String facultad, String periodo, int cantidad_proyectos) {
        this.id = id;
        this.matricula_estudiante = matricula_estudiante;
        this.facultad = facultad;
        this.periodo = periodo;
        this.cantidad_proyectos = cantidad_proyectos;
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
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public int getCantidad_proyectos() {
        return cantidad_proyectos;
    }
    public void setCantidad_proyectos(int cantidad_proyectos) {
        this.cantidad_proyectos = cantidad_proyectos;
    }
    
        @Override
    public String toString() {
        return "Gerente{" + "id=" + id + ", matricula_estudiante=" + matricula_estudiante + ", facultad=" + facultad + ", periodo=" + periodo + ", cantidad_proyectos=" + cantidad_proyectos + '}';
    }
    
    

}
