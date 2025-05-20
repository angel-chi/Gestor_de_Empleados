package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.jdbc.EstudianteRepository;

public class TestEstudiante {

    public static void main(String[] args) {

        
        I_EstudianteRepository estudianteRepository = new EstudianteRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo estudiante ===============\n");
        Estudiante nuevoestudiante
                = new Estudiante("Antonio", "Ibramovich", 34, "Masculino", "DNI", "21762989",
                        "liuoyuko@gmail.com", "1567896578", String.valueOf(LocalDate.now()), 48, 45000f);

        estudianteRepository.save(nuevoestudiante);
        System.out.println(nuevoestudiante);

        System.out.println("\n=================Lista de estudiantes===============\n");
        estudianteRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo estudiante ingresado===============\n");
        estudianteRepository.remove(nuevoestudiante);
        System.out.println(nuevoestudiante);
        System.out.println("\n=================Lista de estudiantes actualizada===============\n");
        estudianteRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del estudiante con el id 2 ===============\n");
        nuevoestudiante = estudianteRepository.getById(2);

        if (nuevoestudiante != null && nuevoestudiante.getId() != 0) {
            nuevoestudiante.setApellido("Fernandez");
            estudianteRepository.update(nuevoestudiante);
        }

        System.out.println("\n=================Lista de estudiantes actualizada===============\n");
        estudianteRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================estudiante/s  cuyo nombre sea jose===============\n");
        estudianteRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================estudiante/s  cuya edad sea mayor o igual a 25 años===============\n");
        estudianteRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================estudiante/s  cuya edad sea menor o igual a 25 años===============\n");
        estudianteRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================estudiante/s  cuyo genero sean masculinos===============\n");
        estudianteRepository.getLikeGenero("Masculino").forEach(System.out::println);

        System.out.println("\n=================estudiante/s  cuyo tipo  de documento sea DNI===============\n");
        estudianteRepository.getLikeTipoDocumento("DNI").forEach(System.out::println);

        System.out.println("\n=================estudiante/s  cuyo numero de documento sea 37087123===============\n");
        estudianteRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================estudiante/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        estudianteRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================estudiante/s  cuyo telefono sea 1123467895===============\n");
        estudianteRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        
        System.out.println("\n=================estudiante/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        estudianteRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================estudiante/s  cuya cantidad de horas semanales sean 48h ===============\n");
        estudianteRepository.getByCantidadHsSemanales(48).forEach(System.out::println);

        
        System.out.println("\n=================estudiante/s  cuyo matricula sea de $33000 ===============\n");
        estudianteRepository.getBymatricula(33000f).forEach(System.out::println);

        //FIN FILTER
    }

}
