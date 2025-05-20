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
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getId())
                .contains(id))
                .collect(Collectors.toList());
    }
    

    default List<Estudiante> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .startsWith(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<>();
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
        if (edad == null || edad.isBlank()) {
            return new ArrayList<>();
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
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .startsWith(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Estudiante> getLikeTipoDocumento(String tipo_documento) {
        if (tipo_documento == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getTipo_documento().toLowerCase()
                .contains(tipo_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Estudiante> getLikeNumeroDocumento(String numero_documento) {
        if (numero_documento == null) {
            return new ArrayList<>();
        }
         return getStream()
                .filter(objeto -> objeto.getNumero_documento().toLowerCase()
                .contains(numero_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Estudiante> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
                .startsWith(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Estudiante> getLikeNumeroTelefono(String numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumero_telefono().toLowerCase()
                .contains(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    default List<Estudiante> getLikeFechaInscripcion(String fecha_inscripcion) {
        if (fecha_inscripcion == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_inscripcion().toLowerCase()
                .contains(fecha_inscripcion.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Estudiante> getByCantidadClasesSemanales(int cantidad_clases_semanales) {

        return getStream()
                .filter(objeto -> objeto.getCantidad_clases_semanales() == cantidad_clases_semanales)
                .collect(Collectors.toList());
    }
    
     default List<Estudiante> getLikeCantidadClasesSemanales(String cantidad_clases_semanales) {
        if (cantidad_clases_semanales == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getCantidad_clases_semanales())
                .contains(cantidad_clases_semanales))
                .collect(Collectors.toList());
    }
 
    default List<Estudiante> getByPromedio(float promedio) {

        return getStream()
                .filter(objeto -> objeto.getPromedio() == promedio)
                .collect(Collectors.toList());
    }
    
            default List<Estudiante> getLikePromedio(String promedio) {
        if (promedio == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio())
                .contains(promedio))
                .collect(Collectors.toList());
    }
    
    
    
}
