package mypackage.repositories.interfaces;

import mypackage.entities.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    default List<Alumno> getLikeTipoCurso(String curso) {
        if (curso == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getCurso().toLowerCase()
                .contains(curso.toLowerCase()))
                .collect(Collectors.toList());
    }

//        default List<Alumno> getLikeTipoDocumento(String tipo_documento) {
//        if (tipo_documento == null) {
//            return new ArrayList<Alumno>();
//        }
//        return getStream()
//                .filter(objeto -> objeto.getTipo_documento().toLowerCase()
//                .contains(tipo_documento.toLowerCase()))
//                .collect(Collectors.toList());
//    }


//    default List<Empleado> getLikeNumeroDocumento(String numero_documento) {
//        if (numero_documento == null) {
//            return new ArrayList<Empleado>();
//        }
//         return getStream()
//                .filter(objeto -> objeto.getNumero_documento().toLowerCase()
//                .contains(numero_documento.toLowerCase()))
//                .collect(Collectors.toList());
//    }


//    default List<Alumno> getLikeCorreoElectronico(String correo_electronico) {
//        if (correo_electronico == null) {
//            return new ArrayList<Alumno>();
//        }
//         return getStream()
//                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
//                .startsWith(correo_electronico.toLowerCase()))
//                .collect(Collectors.toList());
//    }


    default List<Alumno> getLikeMatricula(String matricula) {
        if (matricula == null) {
            return new ArrayList<Alumno>();
        }
           return getStream()
                .filter(objeto -> objeto.getMatricula().toLowerCase()
                .contains(matricula.toLowerCase()))
                .collect(Collectors.toList());
    }

//    default List<Empleado> getLikeNumeroTelefono(String numero_telefono) {
//        if (numero_telefono == null) {
//            return new ArrayList<Empleado>();
//        }
//           return getStream()
//                .filter(objeto -> objeto.getNumero_telefono().toLowerCase()
//                .contains(numero_telefono.toLowerCase()))
//                .collect(Collectors.toList());
//    }

    default List<Alumno> getLikePromedio(String promedio) {
        if (promedio == null) {
            return new ArrayList<Alumno>();
        }
           return getStream()
                .filter(objeto -> String.valueOf(objeto.getPromedio())
                .contains(promedio))
                .collect(Collectors.toList());
    }
    

    default List<Alumno> getLikeFechaInicio(String fecha_inicio) {
        if (fecha_inicio == null) {
            return new ArrayList<Alumno>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_ingreso().toLowerCase()
                .contains(fecha_inicio.toLowerCase()))
                .collect(Collectors.toList());
    }


    default List<Alumno> getLikeEmail(String email) {
        if (email == null) {
            return new ArrayList<Alumno>();
        }
         return getStream()
                .filter(objeto -> objeto.getEmail().toLowerCase()
                .startsWith(email.toLowerCase()))
                .collect(Collectors.toList());
    }

//    default List<Empleado> getByCantidadHsSemanales(int cantidad_hs_semanales) {
//
//        return getStream()
//                .filter(objeto -> objeto.getCantidad_hs_semanales() == cantidad_hs_semanales)
//                .collect(Collectors.toList());
//    }

//     default List<Empleado> getLikeCantidadHsSemanales(String cantidad_hs_semanales) {
//        if (cantidad_hs_semanales == null) {
//            return new ArrayList<Empleado>();
//        }
//        return getStream()
//                .filter(objeto -> String.valueOf(objeto.getCantidad_hs_semanales())
//                .contains(cantidad_hs_semanales))
//                .collect(Collectors.toList());
//    }

//    default List<Empleado> getBySueldo(float sueldo) {

//        return getStream()
//                .filter(objeto -> objeto.getSueldo() == sueldo)
//                .collect(Collectors.toList());
//    }

//            default List<Empleado> getLikeSueldo(String sueldo) {
//        if (sueldo == null) {
//            return new ArrayList<Empleado>();
//        }
//        return getStream()
//                .filter(objeto -> String.valueOf(objeto.getSueldo())
//                .contains(sueldo))
//                .collect(Collectors.toList());
//    }
    
    
    
}
