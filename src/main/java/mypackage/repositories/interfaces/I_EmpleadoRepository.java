package mypackage.repositories.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Estudiante;

public interface I_EmpleadoRepository {

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
                .orElse(new Estudiante("Oscar", "Mastruli", 25, "Masculino", "DNI", "45128789", "Oscarmastruli@gmail.com", "1576859045", String.valueOf(LocalDate.now()), 48, 44000f));
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


        

        
    default List<Estudiante> getLikeCorreoElectronico(String correo_electronico) {
        if (correo_electronico == null) {
            return new ArrayList<Estudiante>();
        }
         return getStream()
                .filter(objeto -> objeto.getCorreo_electronico().toLowerCase()
                .startsWith(correo_electronico.toLowerCase()))
                .collect(Collectors.toList());
    }
    
       
    default List<Estudiante> getLikeNumeroTelefono(Long numero_telefono) {
        if (numero_telefono == null) {
            return new ArrayList<Estudiante>();
        }
           return getStream()
                .filter(objeto -> objeto.getNumero_telefono() == numero_telefono)
                .collect(Collectors.toList());
    }
    

    default List<Estudiante> getLikeFechaInicio(int num_materias) {
        if (false) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getNum_materias() == num_materias)
                .collect(Collectors.toList());
    }
    
     
    
    default List<Estudiante> getByCantidadHsSemanales(Long matricula) {

        return getStream()
                .filter(objeto -> objeto.getMatricula() == matricula)
                .collect(Collectors.toList());
    }
    
     default List<Estudiante> getLikeCantidadHsSemanales(Long matricula) {
        if (matricula == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> objeto.getMatricula() == matricula)
                .collect(Collectors.toList());
    }
 
    default List<Estudiante> getBySueldo(float sueldo) {

        return getStream()
                .filter(objeto -> objeto.getSemestre() == sueldo)
                .collect(Collectors.toList());
    }
    
            default List<Estudiante> getLikeSueldo(String sueldo) {
        if (sueldo == null) {
            return new ArrayList<Estudiante>();
        }
        return getStream()
                .filter(objeto -> String.valueOf(objeto.getSemestre())
                .contains(sueldo))
                .collect(Collectors.toList());
    }
    
    
    
}
