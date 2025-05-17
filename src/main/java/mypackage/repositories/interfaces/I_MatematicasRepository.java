
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Matematicas;


public interface I_MatematicasRepository {

    void save(Matematicas matematicas);

    void remove(Matematicas matematicas);

    void update(Matematicas matematicas);

    List<Matematicas> getAll();

    default Stream<Matematicas> getStream() {
        return getAll().stream();
    }

    default Matematicas getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Matematicas());
    }
    
    default Matematicas getByMatriculaEstudiante(int matricula_estudiante) {
        return getStream()
                .filter(objeto -> objeto.getMatricula_estudiante() == matricula_estudiante)
                .findAny()
                .orElse(new Matematicas());
    }
    
    
    default List<Matematicas> getLikeNivel(String nivel) {
        if (nivel == null) {
            return new ArrayList<Matematicas>();
        }
        return getStream()
                .filter(objeto -> objeto.getNivel().toLowerCase()
                .contains(nivel.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Matematicas> getLikePrograma(String programa) {
        if (programa == null) {
            return new ArrayList<Matematicas>();
        }
        return getStream()
                .filter(objeto -> objeto.getPrograma().toLowerCase()
                .contains(programa.toLowerCase()))
                .collect(Collectors.toList());
    }
        
    default List<Matematicas> getLikeEstatus(String estatus) {
        if (estatus == null) {
            return new ArrayList<Matematicas>();
        }
        return getStream()
                .filter(objeto -> objeto.getEstatus().toLowerCase()
                .contains(estatus.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Matematicas> getLikePromedioActualMayorQue(float promedio_actual){
        
        return getStream()
                .filter(objeto->objeto.getPromedio_actual() > promedio_actual)
                .collect(Collectors.toList());
    
    }

}
