
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Ingenieria;


public interface I_IngenieriaRepository {
    
    
        void save(Ingenieria ingenieria);

    void remove(Ingenieria ingenieria);

    void update(Ingenieria ingenieria);

    List<Ingenieria> getAll();

    default Stream<Ingenieria> getStream() {
        return getAll().stream();
    }

    default Ingenieria getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Ingenieria());
    }
    
    default Ingenieria getByMatriculaEstudiante(int matricula_estudiante) {
        return getStream()
                .filter(objeto -> objeto.getMatricula_estudiante() == matricula_estudiante)
                .findAny()
                .orElse(new Ingenieria());
    }
    
    default List<Ingenieria> getLikeNivel(String nivel) {
        if (nivel == null) {
            return new ArrayList<Ingenieria>();
        }
        return getStream()
                .filter(objeto -> objeto.getNivel().toLowerCase()
                .contains(nivel.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       default List<Ingenieria> getLikePrograma(String programa) {
        if (programa == null) {
            return new ArrayList<Ingenieria>();
        }
        return getStream()
                .filter(objeto -> objeto.getPrograma().toLowerCase()
                .contains(programa.toLowerCase()))
                .collect(Collectors.toList());
    }

}
