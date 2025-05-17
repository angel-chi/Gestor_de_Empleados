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

    default Estudiante getByMatricula(int matricula) {
        return getStream()
                .filter(objeto -> objeto.getMatricula() == matricula)
                .findAny()
                .orElse(new Estudiante());
    }
    
        default List<Estudiante> getLikeMatricula(String matricula) {
        if (matricula == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                .contains(matricula))
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

        default List<Estudiante> getLikeModalidad(String modalidad) {
        if (modalidad == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getModalidad().toLowerCase()
                .contains(modalidad.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Estudiante> getLikeTipoEstudiante(String tipo_estudiante) {
        if (tipo_estudiante == null) {
            return new ArrayList<Estudiante>();
        }
         return getStream()
                .filter(objeto -> objeto.getTipo_estudiante().toLowerCase()
                .contains(tipo_estudiante.toLowerCase()))
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
    

    default List<Estudiante> getLikeDomicilio(String domicilio) {
        if (domicilio == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getDomicilio().toLowerCase()
                .contains(domicilio.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Estudiante> getByAnioIngreso(int anio_ingreso) {

        return getStream()
                .filter(objeto -> objeto.getAnio_ingreso() == anio_ingreso)
                .collect(Collectors.toList());
    }
    
     default List<Estudiante> getLikeAnioIngreso(String anio_ingreso) {
        if (anio_ingreso == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getAnio_ingreso())
                .contains(anio_ingreso))
                .collect(Collectors.toList());
    }
 
    default List<Estudiante> getByPromedioIngreso(float promedio_ingreso) {

        return getStream()
                .filter(objeto -> objeto.getPromedio_ingreso() == promedio_ingreso)
                .collect(Collectors.toList());
    }
    
            default List<Estudiante> getLikePromedioIngreso(String promedio_ingreso) {
        if (promedio_ingreso == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio_ingreso())
                .contains(promedio_ingreso))
                .collect(Collectors.toList());
    }
    
    
    
}
