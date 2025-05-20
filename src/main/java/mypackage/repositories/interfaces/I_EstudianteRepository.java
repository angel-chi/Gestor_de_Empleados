package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Estudiante;

public interface I_EstudianteRepository {

    void save(Estudiante estudiante);

    void remove(Estudiante estudiante);

    void update(Estudiante estudiante);

    List<Estudiante> getAll();

    default Stream<Estudiante> getStream() {
        return getAll().stream();
    }

    default Estudiante getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Estudiante());
    }
    
        default List<Estudiante> getLikeId(String id) {
        if (id == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getId())
                .contains(id))
                .collect(Collectors.toList());
    }
    

    default List<Estudiante> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .startsWith(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .startsWith(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Estudiante> getByEdad(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }
    
         default List<Estudiante> getLikeEdad(String edad) {
        if (edad == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getEdad())
                .contains(edad))
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikeEdadMayorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() >= edad)
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikeEdadMenorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() <= edad)
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikeGenero(String genero) {
        if (genero == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .startsWith(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Estudiante> getLikeTipoDocumento(String matricula) {
        if (matricula == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getMatricula().toLowerCase()
                .contains(matricula.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Estudiante> getLikeNumeroDocumento(String semestre) {
        if (semestre == null) {
            return new ArrayList<Estudiante>();
        }
         return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Estudiante> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<Estudiante>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
                .startsWith(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Estudiante> getLikeNumeroTelefono(String numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<Estudiante>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumero_telefono().toLowerCase()
                .contains(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    default List<Estudiante> getLikeFechaInicio(String fecha_inicio) {
        if (fecha_inicio == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_inicio().toLowerCase()
                .contains(fecha_inicio.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Estudiante> getByFacultad(String facultad) {

        return getStream()
                .filter(objeto -> objeto.getFacultad() == facultad)
                .collect(Collectors.toList());
    }
    
     default List<Estudiante> getLikeCantidadHsSemanales(String facultad) {
        if (facultad == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getFacultad())
                .contains(facultad))
                .collect(Collectors.toList());
    }
 
    default List<Estudiante> getByGastada(float gastada) {

        return getStream()
                .filter(objeto -> objeto.getGastada() == gastada)
                .collect(Collectors.toList());
    }
    
            default List<Estudiante> getLikeSueldo(String sueldo) {
        if (sueldo == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getGastada())
                .contains(sueldo))
                .collect(Collectors.toList());
    }
    
    
    
}
