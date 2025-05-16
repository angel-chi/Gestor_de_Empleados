
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mypackage.entities.SoporteTecnico;


public interface I_SoporteTecnicoRepository {
    
        void save(SoporteTecnico soporteTecnico);

    void remove(SoporteTecnico soporteTecnico);

    void update(SoporteTecnico soporteTecnico);

    List<SoporteTecnico> getAll();

    default Stream<SoporteTecnico> getStream() {
        return getAll().stream();
    }

    default SoporteTecnico getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new SoporteTecnico());
    }

    default SoporteTecnico getByIdAlumnos(int id_alumnos) {
        return getStream()
                .filter(objeto -> objeto.getId_alumnos() == id_alumnos)
                .findAny()
                .orElse(new SoporteTecnico());
    }
    
     default List<SoporteTecnico> getLikePuesto(String puesto) {
        if (puesto == null) {
            return new ArrayList<SoporteTecnico>();
        }
        return getStream()
                .filter(objeto -> objeto.getPuesto().toLowerCase()
                .contains(puesto.toLowerCase()))
                .collect(Collectors.toList());
    }

          default List<SoporteTecnico> getLikeFormacion(String formacion) {
        if (formacion == null) {
            return new ArrayList<SoporteTecnico>();
        }
        return getStream()
                .filter(objeto -> objeto.getFormacion().toLowerCase()
                .contains(formacion.toLowerCase()))
                .collect(Collectors.toList());
    }
          
        default List<SoporteTecnico> getLikeCertificaciones(String certificaciones) {
        if (certificaciones == null) {
            return new ArrayList<SoporteTecnico>();
        }
        return getStream()
                .filter(objeto -> objeto.getCertificaciones().toLowerCase()
                .contains(certificaciones.toLowerCase()))
                .collect(Collectors.toList());
    }

    
}
