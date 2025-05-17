
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Coordinadores;


public interface I_CoordinadorRepository {

    void save(Coordinadores coordinadores);

    void remove(Coordinadores coordinadores);

    void update(Coordinadores coordinadores);

    List<Coordinadores> getAll();

    default Stream<Coordinadores> getStream() {
        return getAll().stream();
    }

    default Coordinadores getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Coordinadores());
    }
    
    default Coordinadores getByIdAlumnos(int id_alumnos) {
        return getStream()
                .filter(objeto -> objeto.getId_alumnos() == id_alumnos)
                .findAny()
                .orElse(new Coordinadores());
    }
    
    
    default List<Coordinadores> getLikePuesto(String puesto) {
        if (puesto == null) {
            return new ArrayList<Coordinadores>();
        }
        return getStream()
                .filter(objeto -> objeto.getPuesto().toLowerCase()
                .contains(puesto.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Coordinadores> getLikeCertificaciones(String certificaciones) {
        if (certificaciones == null) {
            return new ArrayList<Coordinadores>();
        }
        return getStream()
                .filter(objeto -> objeto.getTitulo().toLowerCase()
                .contains(certificaciones.toLowerCase()))
                .collect(Collectors.toList());
    }
        
    default List<Coordinadores> getLikeHabilidades(String habilidades) {
        if (habilidades == null) {
            return new ArrayList<Coordinadores>();
        }
        return getStream()
                .filter(objeto -> objeto.getHabilidades().toLowerCase()
                .contains(habilidades.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Coordinadores> getLikeProyectosEnProduccionMayorQue(int proyectos_en_produccion){
        
        return getStream()
                .filter(objeto->objeto.getSupervisa_a() > proyectos_en_produccion)
                .collect(Collectors.toList());
    
    }

}
