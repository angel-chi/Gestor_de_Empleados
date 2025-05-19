
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Actuaria;


public interface I_ActuariaRepository {

    void save(Actuaria Actuaria);

    void remove(Actuaria Actuaria);

    void update(Actuaria Actuaria);

    List<Actuaria> getAll();

    default Stream<Actuaria> getStream() {
        return getAll().stream();
    }

    default Actuaria getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Actuaria());
    }
    
    default Actuaria getByIdEstudiantes(int id_Estudiantes) {
        return getStream()
                .filter(objeto -> objeto.getId_Estudiantes() == id_Estudiantes)
                .findAny()
                .orElse(new Actuaria());
    }
    
    
    default List<Actuaria> getLikesemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<Actuaria>();
        }
        return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Actuaria> getLikematerias_libres_cursadas(String materias_libres_cursadas) {
        if (materias_libres_cursadas == null) {
            return new ArrayList<Actuaria>();
        }
        return getStream()
                .filter(objeto -> objeto.getMaterias_libres_cursadas().toLowerCase()
                .contains(materias_libres_cursadas.toLowerCase()))
                .collect(Collectors.toList());
    }
        
    default List<Actuaria> getLikematerias_debidas(String materias_debidas) {
        if (materias_debidas == null) {
            return new ArrayList<Actuaria>();
        }
        return getStream()
                .filter(objeto -> objeto.getMaterias_debidas().toLowerCase()
                .contains(materias_debidas.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Actuaria> getLikeProyectosEnProduccionMayorQue(int creditos_cursados){
        
        return getStream()
                .filter(objeto->objeto.getCreditos_cursados() > creditos_cursados)
                .collect(Collectors.toList());
    
    }

}
