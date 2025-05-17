
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mypackage.entities.Quimica;


public interface I_QuimicaRepository {
    
        void save(Quimica quimica);

    void remove(Quimica quimica);

    void update(Quimica quimica);

    List<Quimica> getAll();

    default Stream<Quimica> getStream() {
        return getAll().stream();
    }

    default Quimica getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Quimica());
    }

    default Quimica getByMatriculaEstudiantes(int matricula_estudiante) {
        return getStream()
                .filter(objeto -> objeto.getMatricula_estudiante() == matricula_estudiante)
                .findAny()
                .orElse(new Quimica());
    }
    
     default List<Quimica> getLikeNivel(String nivel) {
        if (nivel == null) {
            return new ArrayList<Quimica>();
        }
        return getStream()
                .filter(objeto -> objeto.getNivel().toLowerCase()
                .contains(nivel.toLowerCase()))
                .collect(Collectors.toList());
    }

          default List<Quimica> getLikePrograma(String programa) {
        if (programa == null) {
            return new ArrayList<Quimica>();
        }
        return getStream()
                .filter(objeto -> objeto.getPrograma().toLowerCase()
                .contains(programa.toLowerCase()))
                .collect(Collectors.toList());
    }
          
        default List<Quimica> getLikeEstatus(String estatus) {
        if (estatus == null) {
            return new ArrayList<Quimica>();
        }
        return getStream()
                .filter(objeto -> objeto.getEstatus().toLowerCase()
                .contains(estatus.toLowerCase()))
                .collect(Collectors.toList());
    }

    
}
