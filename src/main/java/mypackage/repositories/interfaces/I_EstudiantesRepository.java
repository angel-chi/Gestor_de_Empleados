package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Student;

public interface I_EstudiantesRepository {

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

        default List<Student> getLikeTipoDocumento(String tipo_documento) {
        if (tipo_documento == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getTipo_documento().toLowerCase()
                .contains(tipo_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Student> getLikeNumeroDocumento(String numero_documento) {
        if (numero_documento == null) {
            return new ArrayList<Student>();
        }
         return getStream()
                .filter(objeto -> objeto.getNumero_de_matricula().toLowerCase()
                .contains(numero_documento.toLowerCase()))
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
    

    default List<Student> getLikeFechaInicio(String fecha_inicio) {
        if (fecha_inicio == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_inicio().toLowerCase()
                .contains(fecha_inicio.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Student> getByCantidadHsSemanales(int cantidad_hs_semanales) {

        return getStream()
                .filter(objeto -> objeto.getSemestreEquivalente() == cantidad_hs_semanales)
                .collect(Collectors.toList());
    }
    
     default List<Student> getLikeCantidadHsSemanales(String cantidad_hs_semanales) {
        if (cantidad_hs_semanales == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getSemestreEquivalente())
                .contains(cantidad_hs_semanales))
                .collect(Collectors.toList());
    }
 
    default List<Student> getBySueldo(float sueldo) {

        return getStream()
                .filter(objeto -> objeto.getPromedio() == sueldo)
                .collect(Collectors.toList());
    }
    
            default List<Student> getLikeSueldo(String sueldo) {
        if (sueldo == null) {
            return new ArrayList<Student>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio())
                .contains(sueldo))
                .collect(Collectors.toList());
    }
    
    
    
}
