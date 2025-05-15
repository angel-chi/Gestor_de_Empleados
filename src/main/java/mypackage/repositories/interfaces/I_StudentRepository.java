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

        default List<Student> getLikeFacultad(String facultad) {
        if (facultad == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getFacultad().toLowerCase()
                .contains(facultad.toLowerCase()))
                .collect(Collectors.toList());
    }

        
    default List<Student> getLikecarrera(String carrera) {
        if (carrera == null) {
            return new ArrayList<Student>();
        }
         return getStream()
                .filter(objeto -> objeto.getCarrera().toLowerCase()
                .contains(carrera.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Student> getLikeCorreoInstituconal(String correo_institucional) {
        if (correo_institucional == null) {
            return new ArrayList<Student>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_istitucional().toLowerCase()
                .startsWith(correo_institucional.toLowerCase()))
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
    

    default List<Student> getLikeSemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getSemestre())
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Student> getByPromedio(int primedio) {

        return getStream()
                .filter(objeto -> objeto.getPromedio() == primedio)
                .collect(Collectors.toList());
    }

     default List<Student> getLikePromedio(String promedio) {
        if (promedio == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio())
                .contains(promedio))
                .collect(Collectors.toList());
    }

}
