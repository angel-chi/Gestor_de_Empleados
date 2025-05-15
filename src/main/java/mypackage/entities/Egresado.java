
package mypackage.entities;


public class Egresado {
    
    private int id;
    private int id_Estudiantes;
    private String carrera_estudiada;
    private String optativas;
    private int año_egreso;
    
    public Egresado() {
    }
    
    public Egresado(int id_Estudiantes, String carrera_estudiada, String optativas, int año_egreso) {
        this.id_Estudiantes = id_Estudiantes;
        this.carrera_estudiada = carrera_estudiada;
        this.optativas = optativas;
        this.año_egreso = año_egreso;
    }
    
    public Egresado(int id, int id_Estudiantes, String carrera_estudiada, String optativas, int año_egreso) {
        this.id = id;
        this.id_Estudiantes = id_Estudiantes;
        this.carrera_estudiada = carrera_estudiada;
        this.optativas = optativas;
        this.año_egreso = año_egreso;
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
    public String getCarrera_estudiada() {
        return carrera_estudiada;
    }
    public void setCarrera_estudiada(String carrera_estudiada) {
        this.carrera_estudiada = carrera_estudiada;
    }
    public String getoptativas() {
        return optativas;
    }
    public void setoptativas(String optativas) {
        this.optativas = optativas;
    }
    public int getAño_egreso() {
        return año_egreso;
    }
    public void setAño_egreso(int año_egreso) {
        this.año_egreso = año_egreso;
    }
    
        @Override
    public String toString() {
        return "Egresado{" + "id=" + id + ", id_Estudiantes=" + id_Estudiantes + ", carrera_estudiada=" + carrera_estudiada + ", optativas=" + optativas + ", año_egreso=" + año_egreso + '}';
    }
    
    

}
