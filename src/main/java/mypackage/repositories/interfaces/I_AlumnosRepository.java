package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Alumnos;

public interface I_AlumnosRepository {

    void save(Alumnos alumnos);

    void remove(Alumnos alumnos);

    void update(Alumnos alumnos);

    List<Alumnos> getAll();

    default Stream<Alumnos> getStream() {
        return getAll().stream();
    }

    default Alumnos getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getMatricula() == id)
                .findAny()
                .orElse(new Alumnos());
    }
    
        default List<Alumnos> getLikeId(String id) {
        if (id == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                .contains(id))
                .collect(Collectors.toList());
    }
    

    default List<Alumnos> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .startsWith(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Alumnos> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .startsWith(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Alumnos> getByEdad(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }
    
         default List<Alumnos> getLikeEdad(String edad) {
        if (edad == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getEdad())
                .contains(edad))
                .collect(Collectors.toList());
    }

    default List<Alumnos> getLikeEdadMayorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() >= edad)
                .collect(Collectors.toList());
    }

    default List<Alumnos> getLikeEdadMenorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() <= edad)
                .collect(Collectors.toList());
    }

    default List<Alumnos> getLikeGenero(String genero) {
        if (genero == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .startsWith(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Alumnos> getLikeSemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> objeto.getSemestre().toLowerCase()
                .contains(semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Alumnos> getLikefin_semestre(String fin_semestre ) {
        if (fin_semestre  == null) {
            return new ArrayList<Alumnos>();
        }
         return getStream()
                .filter(objeto -> objeto.getFin_semestre().toLowerCase()
                .contains(fin_semestre .toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Alumnos> getLikeCorreo(String correo) {
        if (correo == null) {
            return new ArrayList<Alumnos>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo().toLowerCase()
                .startsWith(correo.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Alumnos> getLikeTelefono(String telefono) {
        if (telefono == null) {
            return new ArrayList<Alumnos>();
        }
           return getStream()
                .filter(objeto -> objeto.getTelefono().toLowerCase()
                .contains(telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    default List<Alumnos> getLikeInicio_semestre(String inicio_semestre) {
        if (inicio_semestre == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> objeto.getInicio_semestre().toLowerCase()
                .contains(inicio_semestre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
   /* default List<Alumnos> getByPromedio(int promedio) {

        return getStream()
                .filter(objeto -> objeto.getMatricula() == promedio)
                .collect(Collectors.toList());
    }*/
    
     default List<Alumnos> getLikeMatricula(int matricula) {
        if (matricula == 0) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                .contains(String.valueOf(matricula)))
                .collect(Collectors.toList());
    }
 
    default List<Alumnos> getBypromedio(float promedio) {

        return getStream()
                .filter(objeto -> objeto.getPromedio() ==promedio)
                .collect(Collectors.toList());
    }
    
            default List<Alumnos> getLikePromedio(String promedio) {
        if (promedio == null) {
            return new ArrayList<Alumnos>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio())
                .contains(promedio))
                .collect(Collectors.toList());
    }

    
    

}
