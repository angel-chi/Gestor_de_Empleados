package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Egresado;

public interface I_EgresadoRepository {

    void save(Egresado LicIngDesSoftware);

    void remove(Egresado LicIngDesSoftware);

    void update(Egresado LicIngDesSoftware);

    List<Egresado> getAll();

    default Stream<Egresado> getStream() {
        return getAll().stream();
    }

    default Egresado getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Egresado());
    }

    default Egresado getByIdEstudiantes(int id_Estudiantes) {
        return getStream()
                .filter(objeto -> objeto.getId_Estudiantes() == id_Estudiantes)
                .findAny()
                .orElse(new Egresado());
    }
    
        default List<Egresado> getLikecarrera_estudiada(String carrera_estudiada) {
        if (carrera_estudiada == null) {
            return new ArrayList<Egresado>();
        }
        return getStream()
                .filter(objeto -> objeto.getCarrera_estudiada().toLowerCase()
                .contains(carrera_estudiada.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Egresado> getLikeoptativas(String optativas) {
        if (optativas == null) {
            return new ArrayList<Egresado>();
        }
        return getStream()
                .filter(objeto -> objeto.getoptativas().toLowerCase()
                .contains(optativas.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Egresado> getByaño_egreso(int año_egreso) {
        return getStream()
                .filter(objeto -> objeto.getAño_egreso()== año_egreso)
                .collect(Collectors.toList());
    }

}
