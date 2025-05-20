package mypackage.repositories.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mysql.cj.jdbc.CallableStatement;
import mypackage.entities.Alumno;

import javax.swing.*;

public interface I_AlumnoRepository {

    void save(Alumno alumno);

    void remove(Alumno alumno);

    void update(Alumno alumno);

    List<Alumno> getAll();

    default Stream<Alumno> getStream() {
        return getAll().stream();
    }

    default Alumno getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Alumno());
    }
    
        default List<Alumno> getLikeId(String id) {
        if (id == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getId())
                .contains(id))
                .collect(Collectors.toList());
    }
    

    default List<Alumno> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .startsWith(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Alumno> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .startsWith(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Alumno> getByEdad(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }
    
         default List<Alumno> getLikeEdad(String edad) {
        if (edad == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getEdad())
                .contains(edad))
                .collect(Collectors.toList());
    }

    default List<Alumno> getLikeEdadMayorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() >= edad)
                .collect(Collectors.toList());
    }

    default List<Alumno> getLikeEdadMenorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() <= edad)
                .collect(Collectors.toList());
    }

    default List<Alumno> getLikeGenero(String genero) {
        if (genero == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .startsWith(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Alumno> getLikeSemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
        
    default List<Alumno> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<Alumno>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
                .startsWith(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Alumno> getLikeNumeroTelefono(String numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<Alumno>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumero_telefono().toLowerCase()
                .contains(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    /*default List<Alumno> getLikeFechaInicio(String fecha_inicio) {
        if (fecha_inicio == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_inicio().toLowerCase()
                .contains(fecha_inicio.toLowerCase()))
                .collect(Collectors.toList());
    }*/
    
     
    
    default List<Alumno> getByMatricula(int matricula) {

        return getStream()
                .filter(objeto -> objeto.getMatricula() == matricula)
                .collect(Collectors.toList());
    }
    
     default List<Alumno> getLikeMatricula(String matricula) {
        if (matricula == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                .contains(matricula))
                .collect(Collectors.toList());
    }
 
    default List<Alumno> getByPromedio(float promedio) {

        return getStream()
                .filter(objeto -> objeto.getPromedio() == promedio)
                .collect(Collectors.toList());
    }
    
            default List<Alumno> getLikePromedio(String promedio) {
        if (promedio == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio())
                .contains(promedio))
                .collect(Collectors.toList());
    }



}
