
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mypackage.entities.LicCienciasComputacion;


public interface I_LicCienciasComputacionRepository {
    
        void save(LicCienciasComputacion LicCienciasComputacion);

    void remove(LicCienciasComputacion LicCienciasComputacion);

    void update(LicCienciasComputacion LicCienciasComputacion);

    List<LicCienciasComputacion> getAll();

    default Stream<LicCienciasComputacion> getStream() {
        return getAll().stream();
    }

    default LicCienciasComputacion getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new LicCienciasComputacion());
    }

    default LicCienciasComputacion getByIdEstudiantes(int id_Estudiantes) {
        return getStream()
                .filter(objeto -> objeto.getId_Estudiantes() == id_Estudiantes)
                .findAny()
                .orElse(new LicCienciasComputacion());
    }
    
     default List<LicCienciasComputacion> getLikesemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<LicCienciasComputacion>();
        }
        return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }

          default List<LicCienciasComputacion> getLikeoptativas(String optativas) {
        if (optativas == null) {
            return new ArrayList<LicCienciasComputacion>();
        }
        return getStream()
                .filter(objeto -> objeto.getoptativas().toLowerCase()
                .contains(optativas.toLowerCase()))
                .collect(Collectors.toList());
    }
          
        default List<LicCienciasComputacion> getLikematerias_libres_cursadas(String materias_libres_cursadas) {
        if (materias_libres_cursadas == null) {
            return new ArrayList<LicCienciasComputacion>();
        }
        return getStream()
                .filter(objeto -> objeto.getMaterias_libres_cursadas().toLowerCase()
                .contains(materias_libres_cursadas.toLowerCase()))
                .collect(Collectors.toList());
    }

    
}
