package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Gerente;

public interface I_GerenteRepository {

    void save(Gerente administracion);

    void remove(Gerente administracion);

    void update(Gerente administracion);

    List<Gerente> getAll();

    default Stream<Gerente> getStream() {
        return getAll().stream();
    }

    default Gerente getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Gerente());
    }

    default Gerente getByIdStudents(int id_students) {
        return getStream()
                .filter(objeto -> objeto.getId_students() == id_students)
                .findAny()
                .orElse(new Gerente());
    }
    
        default List<Gerente> getLikeSector(String sector) {
        if (sector == null) {
            return new ArrayList<Gerente>();
        }
        return getStream()
                .filter(objeto -> objeto.getSector().toLowerCase()
                .contains(sector.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Gerente> getLikeFormacion(String formacion) {
        if (formacion == null) {
            return new ArrayList<Gerente>();
        }
        return getStream()
                .filter(objeto -> objeto.getFormacion().toLowerCase()
                .contains(formacion.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Gerente> getByAntiguedad(int antiguedad) {
        return getStream()
                .filter(objeto -> objeto.getAntiguedad()== antiguedad)
                .collect(Collectors.toList());
    }

}
