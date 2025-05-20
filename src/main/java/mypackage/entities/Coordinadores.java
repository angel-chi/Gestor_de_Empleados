
package mypackage.entities;


public class Coordinadores {
    
    private int id;
    private int id_empleados;
    private String puesto;
    private String titulo;
    private String habilidades;//sigue sin convenserme mejor funcionalidades? no son maquinas.... mmmm.....
    private int supervisa_a;
   
    
    public Coordinadores() {
    }
    
    
    public Coordinadores(int id_empleados, String puesto, String titulo, String habilidades, int supervisa_a) {
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.titulo = titulo;
        this.habilidades = habilidades;
        this.supervisa_a = supervisa_a;
    }
    
    
    public Coordinadores(int id, int id_empleados, String puesto, String titulo, String habilidades, int supervisa_a) {
        this.id = id;
        this.id_empleados = id_empleados;
        this.puesto = puesto;
        this.titulo = titulo;
        this.habilidades = habilidades;
        this.supervisa_a = supervisa_a;
    }
    public int getSupervisa_a() {
        return supervisa_a;
    }
    public void setSupervisa_a(int supervisa_a) {
        this.supervisa_a = supervisa_a;
    }
    
    
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_alumnos() {
        return id_empleados;
    }
    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    
    
    @Override
    public String toString() {
        return "Desarrollador{" + "id=" + id + ", id_empleados=" + id_empleados + ", puesto=" + puesto + ", certificaciones=" + titulo + ", habilidades=" + habilidades + ", cantidad de personas que supervisa=" + supervisa_a + '}';
    }
    
    
    

}
