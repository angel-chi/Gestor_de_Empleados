
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Desarrollador;


public interface I_DesarrolladorRepository {

    void save(Desarrollador desarrollador);

    void remove(Desarrollador desarrollador);

    void update(Desarrollador desarrollador);

    List<Desarrollador> getAll();

    default Stream<Desarrollador> getStream() {
        return getAll().stream();
    }

    default Desarrollador getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Desarrollador());
    }
    
    default Desarrollador getByIdEmpleados(int id_empleados) {
        return getStream()
                .filter(objeto -> objeto.getId_empleados() == id_empleados)
                .findAny()
                .orElse(new Desarrollador());
    }
    
    
    default List<Desarrollador> getLikePuesto(String puesto) {
        if (puesto == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getPuesto().toLowerCase()
                .contains(puesto.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Desarrollador> getLikeCertificaciones(String certificaciones) {
        if (certificaciones == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getCertificaciones().toLowerCase()
                .contains(certificaciones.toLowerCase()))
                .collect(Collectors.toList());
    }
        
    default List<Desarrollador> getLikeHabilidades(String habilidades) {
        if (habilidades == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getHabilidades().toLowerCase()
                .contains(habilidades.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Desarrollador> getLikeProyectosEnProduccionMayorQue(int proyectos_en_produccion){
        
        return getStream()
                .filter(objeto->objeto.getProyectos_en_produccion() > proyectos_en_produccion)
                .collect(Collectors.toList());
    
    }

}
