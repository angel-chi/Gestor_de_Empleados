package mypackage.test;

//import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Alumno;
import mypackage.repositories.interfaces.I_AlumnoRepository;
import mypackage.repositories.jdbc.AlumnoRepository;

public class TestAlumno {

    public static void main(String[] args) {


        I_AlumnoRepository alumnoRepository = new AlumnoRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Alumno ===============\n");
        Alumno nuevoAlumno
                = new Alumno("Antonio", "Ibramovich", 34, "Masculino", "Programacion orientada a objetos", "21762989",
                        9.2, "23 de agosto", "A23216438@alumnos.uady.com");

        alumnoRepository.save(nuevoAlumno);
        System.out.println(nuevoAlumno);

        System.out.println("\n=================Lista de Alumnos===============\n");
        alumnoRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo alumno ingresado===============\n");
        alumnoRepository.remove(nuevoAlumno);
        System.out.println(nuevoAlumno);
        System.out.println("\n=================Lista de Alumnos actualizada===============\n");
        alumnoRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Alumno con el id 2 ===============\n");
        nuevoAlumno = alumnoRepository.getById(2);

        if (nuevoAlumno != null && nuevoAlumno.getId() != 0) {
            nuevoAlumno.setApellido("Fernandez");
            alumnoRepository.update(nuevoAlumno);
        }

        System.out.println("\n=================Lista de Alumnos actualizada===============\n");
        alumnoRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================Alumno/s  cuyo nombre sea jose===============\n");
        alumnoRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Alumno/s  cuya edad sea mayor o igual a 25 años===============\n");
        alumnoRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Alumno/s  cuya edad sea menor o igual a 25 años===============\n");
        alumnoRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Alumno/s  cuyo genero sean masculinos===============\n");
        alumnoRepository.getLikeGenero("Masculino").forEach(System.out::println);

//        System.out.println("\n=================Empleado/s  cuyo tipo  de documento sea DNI===============\n");
//        alumnoRepository.("DNI").forEach(System.out::println);

//        System.out.println("\n=================Empleado/s  cuyo numero de documento sea 37087123===============\n");
//        empleadoRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================Alumno/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        alumnoRepository.getLikeEmail("romi2@gmail.com").forEach(System.out::println);


//        System.out.println("\n=================Empleado/s  cuyo telefono sea 1123467895===============\n");
//        empleadoRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);


        System.out.println("\n=================Alumno/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        alumnoRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);



//        System.out.println("\n=================Empleado/s  cuya cantidad de horas semanales sean 48h ===============\n");
//        empleadoRepository.getByCantidadHsSemanales(48).forEach(System.out::println);


//        System.out.println("\n=================Empleado/s  cuyo sueldo sea de $33000 ===============\n");
//        empleadoRepository.getBySueldo(33000f).forEach(System.out::println);

        //FIN FILTER
    }

}
