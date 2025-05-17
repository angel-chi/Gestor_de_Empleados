package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Alumnos;
import mypackage.repositories.interfaces.I_AlumnosRepository;
import mypackage.repositories.jdbc.AlumnosRepository;

public class TestAlumno {

    public static void main(String[] args) {

        
        I_AlumnosRepository alumnoRepository = new AlumnosRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Alumno ===============\n");
        Alumnos nuevoAlumnos = new Alumnos( 0/*resultSetAlumnos.getInt("id")*/, "Antonio", "Ibramovich", 34, "Masculino", "segundo", "01/04",
                        "liuoyuko@gmail.com", "1567896578", String.valueOf(LocalDate.now()), 48, 45000f);

        alumnoRepository.save(nuevoAlumnos);
        System.out.println(nuevoAlumnos);

        System.out.println("\n=================Lista de Alumnos===============\n");
        alumnoRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo Alumno ingresado===============\n");
        alumnoRepository.remove(nuevoAlumnos);
        System.out.println(nuevoAlumnos);
        System.out.println("\n=================Lista de Alumnos actualizada===============\n");
        alumnoRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Alumno con el id 2 ===============\n");
        nuevoAlumnos = alumnoRepository.getById(2);

        //el error que me llevo timepo es que is.Empty solo funciona con String, y mi matricula es int
        if (nuevoAlumnos != null && nuevoAlumnos.getMatricula()==0) {
            nuevoAlumnos.setApellido("Fernandez");
            alumnoRepository.update(nuevoAlumnos);
        }

        System.out.println("\n=================Lista de Alumnos actualizada===============\n");
        alumnoRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================Alumnos/s  cuyo nombre sea jose===============\n");
        alumnoRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Alumnos/s  cuya edad sea mayor o igual a 25 años===============\n");
        alumnoRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Alumnos/s  cuya edad sea menor o igual a 25 años===============\n");
        alumnoRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Alumnos/s cuyo genero sean masculinos===============\n");
        alumnoRepository.getLikeGenero("Masculino").forEach(System.out::println);

        System.out.println("\n=================Alumnos/s  cuyo semestre sea del 1ero al 9eno===============\n");
        alumnoRepository.getLikeSemestre("tercero").forEach(System.out::println);

        System.out.println("\n=================Alumnos/s  cuyo numero de matricula sea 37087123===============\n");
        alumnoRepository.getLikefin_semestre("37087123").forEach(System.out::println);

        System.out.println("\n=================Alumnos/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        alumnoRepository.getLikeCorreo("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Alumnos/s  cuyo telefono sea 1123467895===============\n");
        alumnoRepository.getLikeTelefono("1123467895").forEach(System.out::println);

        
        System.out.println("\n=================Alumnos/s cuya fecha de inicio sea el 2020-09-12 ===============\n");
        alumnoRepository.getLikeInicio_semestre("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================Alumnos/s  cuya fecha final sea el 2020-05-1 ===============\n");
        alumnoRepository.getBypromedio(48).forEach(System.out::println);

        
        System.out.println("\n=================Alumnos/s  cuya calicacion sea de 100 ===============\n");
        alumnoRepository.getBypromedio(80).forEach(System.out::println);

        //FIN FILTER
    }

}
