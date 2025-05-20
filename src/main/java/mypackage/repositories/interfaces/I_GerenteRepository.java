package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Profesores;

public interface I_GerenteRepository {

    void save(Profesores administracion);

    void remove(Profesores administracion);

    void update(Profesores administracion);

    List<Profesores> getAll();

    default Stream<Profesores> getStream() {
        return getAll().stream();
    }

    default Profesores getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Profesores());
    }

    default Profesores getByIdEmpleados(int id_empleados) {
        return getStream()
                .filter(objeto -> objeto.getId_empleados() == id_empleados)
                .findAny()
                .orElse(new Profesores());
    }
    
        default List<Profesores> getLikeSector(String sector) {
        if (sector == null) {
            return new ArrayList<Profesores>();
        }
        return getStream()
                .filter(objeto -> objeto.getPuesto().toLowerCase()
                .contains(sector.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Profesores> getLikeFormacion(String formacion) {
        if (formacion == null) {
            return new ArrayList<Profesores>();
        }
        return getStream()
                .filter(objeto -> objeto.getTitulo().toLowerCase()
                .contains(formacion.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Profesores> getByAntiguedad(int antiguedad) {
        return getStream()
                .filter(objeto -> objeto.getAntiguedad()== antiguedad)
                .collect(Collectors.toList());
    }

}
