package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Student;

public interface I_StudentRepository {

    void save(Student student);

    void remove(Student student);

    void update(Student student);

    List<Student> getAll();

    default Stream<Student> getStream() {
        return getAll().stream();
    }

    default Student getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Student());
    }
    
        default List<Student> getLikeId(String id) {
        if (id == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getId())
                .contains(id))
                .collect(Collectors.toList());
    }
    

    default List<Student> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .startsWith(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Student> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .startsWith(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Student> getByEdad(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }
    
         default List<Student> getLikeEdad(String edad) {
        if (edad == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getEdad())
                .contains(edad))
                .collect(Collectors.toList());
    }

    default List<Student> getLikeEdadMayorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() >= edad)
                .collect(Collectors.toList());
    }

    default List<Student> getLikeEdadMenorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() <= edad)
                .collect(Collectors.toList());
    }

    default List<Student> getLikeGenero(String genero) {
        if (genero == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .startsWith(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Student> getLikeTipoDocumento(String grado) {
        if (grado == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getGrado().toLowerCase()
                .contains(grado.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Student> getLikeNumeroDocumento(String matricula) {
        if (matricula == null) {
            return new ArrayList<Student>();
        }
         return getStream()
                .filter(objeto -> objeto.getMatricula().toLowerCase()
                .contains(matricula.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Student> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<Student>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
                .startsWith(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Student> getLikeNumeroTelefono(String numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<Student>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumero_telefono().toLowerCase()
                .contains(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    default List<Student> getLikeFechaInicio(String semestre) {
        if (semestre == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Student> getByCantidadHsSemanales(int cantidad_hs_escolares) {

        return getStream()
                .filter(objeto -> objeto.getCantidad_hs_escolares() == cantidad_hs_escolares)
                .collect(Collectors.toList());
    }
    
     default List<Student> getLikeCantidadHsSemanales(String cantidad_hs_escolares) {
        if (cantidad_hs_escolares == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getCantidad_hs_escolares())
                .contains(cantidad_hs_escolares))
                .collect(Collectors.toList());
    }
 
    default List<Student> getByMesada(float mesada) {

        return getStream()
                .filter(objeto -> objeto.getMesada() == mesada)
                .collect(Collectors.toList());
    }
    
            default List<Student> getLikeMesada(String mesada) {
        if (mesada == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMesada())
                .contains(mesada))
                .collect(Collectors.toList());
    }
    
    
    
}
