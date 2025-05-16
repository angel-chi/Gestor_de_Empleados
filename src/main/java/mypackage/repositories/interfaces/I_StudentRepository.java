package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.protobuf.StringValue;
import mypackage.entities.Student;

import javax.swing.*;

public interface I_StudentRepository {

    void save(Student student);

    void aumentaId(Student student);

    void remove(Student student);

    void update(Student student,String nombre, String apellido, String edad, String genero, String correo_electronico, String numero_telefono,String cantidad_materias, String matricula,  String semestre);

    List<Student> getAll();

    List<Student> getOrdenadoId(String orden);
    List<Student> getOrdenadoNombre(String orden);
    List<Student> getOrdenadoApellido(String orden);
    List<Student> getOrdenadoEdad(String orden);
    List<Student> getOrdenadoGenero(String orden);
    List<Student> getOrdenadoCorreoElectronico(String orden);
    List<Student> getOrdenadoNumeroTelefono(String orden);
    List<Student> getOrdenadoCantidadMaterias(String orden);
    List<Student> getOrdenadoMatricula(String orden);
    List<Student> getOrdenadoSemestre(String orden);

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

        default List<Student> getLikeCantidadMaterias(String cantidad_materias) {
        if (cantidad_materias == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getCantidad_materias())
                .contains(cantidad_materias))
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
                .filter(objeto -> String.valueOf(objeto.getNumero_telefono())
                .contains(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

     
    
    default List<Student> getByCantidadMatricula(int matricula) {

        return getStream()
                .filter(objeto -> objeto.getMatricula() == matricula)
                .collect(Collectors.toList());
    }
    
     default List<Student> getLikeCantidadSemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getSemestre())
                .contains(semestre))
                .collect(Collectors.toList());
    }

}
