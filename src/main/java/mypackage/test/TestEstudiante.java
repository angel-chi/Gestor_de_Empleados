package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.jdbc.EstudianteRepository;

public class TestEstudiante {

    public static void main(String[] args) {

        
        I_EstudianteRepository EstudianteRepository = new EstudianteRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Estudiante ===============\n");
        Estudiante nuevoEstudiante
                = new Estudiante("Antonio", "Ibramovich", 34, "Masculino", "DNI", "21762989",
                        "liuoyuko@gmail.com", "1567896578", String.valueOf(LocalDate.now()), 48, 45000f);

        EstudianteRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Lista de Estudiantes===============\n");
        EstudianteRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo Estudiante ingresado===============\n");
        EstudianteRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
        System.out.println("\n=================Lista de Estudiantes actualizada===============\n");
        EstudianteRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Estudiante con el id 2 ===============\n");
        nuevoEstudiante = EstudianteRepository.getById(2);

        if (nuevoEstudiante != null && nuevoEstudiante.getId() != 0) {
            nuevoEstudiante.setApellido("Fernandez");
            EstudianteRepository.update(nuevoEstudiante);
        }

        System.out.println("\n=================Lista de Estudiantes actualizada===============\n");
        EstudianteRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================Estudiante/s  cuyo nombre sea jose===============\n");
        EstudianteRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuya edad sea mayor o igual a 25 años===============\n");
        EstudianteRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuya edad sea menor o igual a 25 años===============\n");
        EstudianteRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo genero sean masculinos===============\n");
        EstudianteRepository.getLikeGenero("Masculino").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo tipo  de documento sea DNI===============\n");
        EstudianteRepository.getLikeTipoDocumento("DNI").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo numero de documento sea 37087123===============\n");
        EstudianteRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        EstudianteRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuyo telefono sea 1123467895===============\n");
        EstudianteRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        EstudianteRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuya cantidad de horas semanales sean 48h ===============\n");
        EstudianteRepository.getByHsDeClase(48).forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuyo calificacion sea de $33000 ===============\n");
        EstudianteRepository.getBycalificacion(33000f).forEach(System.out::println);

        //FIN FILTER
    }

}
