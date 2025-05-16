
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Administracion;


public interface I_AdministracionRepository {
    
    
        void save(Administracion administracion);

    void remove(Administracion administracion);

    void update(Administracion administracion);

    List<Administracion> getAll();

    default Stream<Administracion> getStream() {
        return getAll().stream();
    }

    default Administracion getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Administracion());
    }
    
    default Administracion getByIdEmpleados(int id_empleados) {
        return getStream()
                .filter(objeto -> objeto.getId_empleados() == id_empleados)
                .findAny()
                .orElse(new Administracion());
    }
    
    default List<Administracion> getLikePuesto(String puesto) {
        if (puesto == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getPuesto().toLowerCase()
                .contains(puesto.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       default List<Administracion> getLikeHabilidades(String habilidades) {
        if (habilidades == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getHabilidades().toLowerCase()
                .contains(habilidades.toLowerCase()))
                .collect(Collectors.toList());
    }

}
