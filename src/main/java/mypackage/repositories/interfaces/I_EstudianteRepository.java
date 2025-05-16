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

        default List<Estudiante> getLikeTipoDocumento(String tipo_documento) {
        if (tipo_documento == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getTipo_documento().toLowerCase()
                .contains(tipo_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Estudiante> getLikeNumeroDocumento(String numero_documento) {
        if (numero_documento == null) {
            return new ArrayList<Estudiante>();
        }
         return getStream()
                .filter(objeto -> objeto.getNumero_documento().toLowerCase()
                .contains(numero_documento.toLowerCase()))
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
    
     
    
    default List<Estudiante> getByCantidadHsSemanales(int cantidad_hs_semanales) {

        return getStream()
                .filter(objeto -> objeto.getCantidad_hs_semanales() == cantidad_hs_semanales)
                .collect(Collectors.toList());
    }
    
     default List<Estudiante> getLikeCantidadHsSemanales(String cantidad_hs_semanales) {
        if (cantidad_hs_semanales == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getCantidad_hs_semanales())
                .contains(cantidad_hs_semanales))
                .collect(Collectors.toList());
    }
 
    default List<Estudiante> getBymatricula(float matricula) {

        return getStream()
                .filter(objeto -> objeto.getMatricula() == matricula)
                .collect(Collectors.toList());
    }
    
            default List<Estudiante> getLikematricula(String matricula) {
        if (matricula == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                .contains(matricula))
                .collect(Collectors.toList());
    }
    default List<Estudiante> getBycalificacion(float calificacion) {

        return getStream()
                .filter(objeto -> objeto.getMatricula() == calificacion)
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikecalificacion(String calificacion) {
        if (calificacion == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                        .contains(calificacion))
                .collect(Collectors.toList());
    }
    default List<Estudiante> getBysemestre(float semestre) {

        return getStream()
                .filter(objeto -> objeto.getSemestre() == semestre)
                .collect(Collectors.toList());
    }

    default List<Estudiante> getLikesemestre(String semestre) {
        if (semestre == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getMatricula())
                        .contains(semestre))
                .collect(Collectors.toList());
    }

}
