package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.PresidenteEstudiantil;

public interface I_PresidenteEstudiantilRepository {

    void save(PresidenteEstudiantil presidente);

    void remove(PresidenteEstudiantil presidente);

    void update(PresidenteEstudiantil presidente);

    List<PresidenteEstudiantil> getAll();

    default Stream<PresidenteEstudiantil> getStream() {
        return getAll().stream();
    }

    default PresidenteEstudiantil getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new PresidenteEstudiantil());
    }

    default PresidenteEstudiantil getByMatriculaEstudiante(int matricula_estudiante) {
        return getStream()
                .filter(objeto -> objeto.getMatricula_estudiante() == matricula_estudiante)
                .findAny()
                .orElse(new PresidenteEstudiantil());
    }
    
        default List<PresidenteEstudiantil> getLikeFacultad(String facultad) {
        if (facultad == null) {
            return new ArrayList<PresidenteEstudiantil>();
        }
        return getStream()
                .filter(objeto -> objeto.getFacultad().toLowerCase()
                .contains(facultad.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<PresidenteEstudiantil> getLikePeriodo(String periodo) {
        if (periodo == null) {
            return new ArrayList<PresidenteEstudiantil>();
        }
        return getStream()
                .filter(objeto -> objeto.getPeriodo().toLowerCase()
                .contains(periodo.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<PresidenteEstudiantil> getByCantidadProyectos(int cantidad_proyectos) {
        return getStream()
                .filter(objeto -> objeto.getCantidad_proyectos()== cantidad_proyectos)
                .collect(Collectors.toList());
    }

}
