package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Empleado;

public interface I_EmpleadoRepository {

    void save(Empleado empleado);

    void remove(Empleado empleado);

    void update(Empleado empleado);

    List<Empleado> getAll();

    default Stream<Empleado> getStream() {
        return getAll().stream();
    }

    default Empleado getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Empleado());
    }
    
        default List<Empleado> getLikeId(String id) {
        if (id == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getId())
                .contains(id))
                .collect(Collectors.toList());
    }
    

    default List<Empleado> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Empleado> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Empleado> getByEdad(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }
    
         default List<Empleado> getLikeEdad(String edad) {
        if (edad == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getEdad())
                .contains(edad))
                .collect(Collectors.toList());
    }

    default List<Empleado> getLikeEdadMayorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() >= edad)
                .collect(Collectors.toList());
    }

    default List<Empleado> getLikeEdadMenorIgualQue(int edad) {

        return getStream()
                .filter(objeto -> objeto.getEdad() <= edad)
                .collect(Collectors.toList());
    }

    default List<Empleado> getLikeGenero(String genero) {
        if (genero == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getGenero().toLowerCase()
                .contains(genero.toLowerCase()))
                .collect(Collectors.toList());
    }

        default List<Empleado> getLikeTipoDocumento(String tipo_documento) {
        if (tipo_documento == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getTipo_documento().toLowerCase()
                .contains(tipo_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
        
        
    default List<Empleado> getLikeNumeroDocumento(String numero_documento) {
        if (numero_documento == null) {
            return new ArrayList<Empleado>();
        }
         return getStream()
                .filter(objeto -> objeto.getNumero_documento().toLowerCase()
                .contains(numero_documento.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        
    default List<Empleado> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<Empleado>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
                .contains(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Empleado> getLikeNumeroTelefono(String numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<Empleado>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumero_telefono().toLowerCase()
                .contains(numero_telefono.toLowerCase()))
                .collect(Collectors.toList());
    }
    

    default List<Empleado> getLikeFechaInicio(String fecha_inicio) {
        if (fecha_inicio == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_inicio().toLowerCase()
                .contains(fecha_inicio.toLowerCase()))
                .collect(Collectors.toList());
    }
    
     
    
    default List<Empleado> getByCantidadHsSemanales(int cantidad_hs_semanales) {

        return getStream()
                .filter(objeto -> objeto.getCantidad_hs_semanales() == cantidad_hs_semanales)
                .collect(Collectors.toList());
    }
    
     default List<Empleado> getLikeCantidadHsSemanales(String cantidad_hs_semanales) {
        if (cantidad_hs_semanales == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getCantidad_hs_semanales())
                .contains(cantidad_hs_semanales))
                .collect(Collectors.toList());
    }
 
    default List<Empleado> getBySueldo(float sueldo) {

        return getStream()
                .filter(objeto -> objeto.getSueldo() == sueldo)
                .collect(Collectors.toList());
    }
    
            default List<Empleado> getLikeSueldo(String sueldo) {
        if (sueldo == null) {
            return new ArrayList<Empleado>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getSueldo())
                .contains(sueldo))
                .collect(Collectors.toList());
    }
    
    
    
}
