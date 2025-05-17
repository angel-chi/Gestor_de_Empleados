
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Administracion_CE;


public interface I_AdministracionRepository {
    
    
        void save(Administracion_CE administracionCE);

    void remove(Administracion_CE administracionCE);

    void update(Administracion_CE administracionCE);

    List<Administracion_CE> getAll();

    default Stream<Administracion_CE> getStream() {
        return getAll().stream();
    }

    default Administracion_CE getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Administracion_CE());
    }
    
    default Administracion_CE getByIdAlumnos(int id_alumnos) {
        return getStream()
                .filter(objeto -> objeto.getId_empleados() == id_alumnos)
                .findAny()
                .orElse(new Administracion_CE());
    }
    
    default List<Administracion_CE> getLikePuesto(String puesto) {
        if (puesto == null) {
            return new ArrayList<Administracion_CE>();
        }
        return getStream()
                .filter(objeto -> objeto.getPuesto().toLowerCase()
                .contains(puesto.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       default List<Administracion_CE> getLikeHabilidades(String habilidades) {
        if (habilidades == null) {
            return new ArrayList<Administracion_CE>();
        }
        return getStream()
                .filter(objeto -> objeto.getConocimientos().toLowerCase()
                .contains(habilidades.toLowerCase()))
                .collect(Collectors.toList());
    }

}
