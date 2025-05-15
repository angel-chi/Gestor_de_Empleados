
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.LicIngDesSoftware;


public interface I_LicIngDesSoftwareRepository {
    
    
        void save(LicIngDesSoftware LicIngDesSoftware);

    void remove(LicIngDesSoftware LicIngDesSoftware);

    void update(LicIngDesSoftware LicIngDesSoftware);

    List<LicIngDesSoftware> getAll();

    default Stream<LicIngDesSoftware> getStream() {
        return getAll().stream();
    }

    default LicIngDesSoftware getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new LicIngDesSoftware());
    }
    
    default LicIngDesSoftware getByIdEstudiantes(int id_Estudiantes) {
        return getStream()
                .filter(objeto -> objeto.getId_Estudiantes() == id_Estudiantes)
                .findAny()
                .orElse(new LicIngDesSoftware());
    }
    
    default List<LicIngDesSoftware> getLikesemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<LicIngDesSoftware>();
        }
        return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       default List<LicIngDesSoftware> getLikematerias_debidas(String materias_debidas) {
        if (materias_debidas == null) {
            return new ArrayList<LicIngDesSoftware>();
        }
        return getStream()
                .filter(objeto -> objeto.getMaterias_debidas().toLowerCase()
                .contains(materias_debidas.toLowerCase()))
                .collect(Collectors.toList());
    }

}
