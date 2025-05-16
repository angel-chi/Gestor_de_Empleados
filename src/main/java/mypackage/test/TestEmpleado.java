package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.jdbc.EstudianteRepository;

public class TestEmpleado {

    public static void main(String[] args) {

        I_EstudianteRepository empleadoRepository = new EstudianteRepository(LocalConnector.getLocalConnection());

        // INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Estudiante nuevoEstudiante = new Estudiante();

        empleadoRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Lista de Empleados===============\n");
        empleadoRepository.getAll().forEach(System.out::println);
        // FIN INSERT

        // REMOVE
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        // FIN REMOVE
        // UPDATE
        System.out.println("\n=================Actualizamos el apellido del Empleado con el id 2 ===============\n");
        nuevoEstudiante = empleadoRepository.getById(2);

        if (nuevoEstudiante != null && nuevoEstudiante.getId() != 0) {
            nuevoEstudiante.setApellido_primero("Fernandez");
            empleadoRepository.update(nuevoEstudiante);
        }

        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        // FIN UPDATE
        // FILTER
        System.out.println("\n=================Empleado/s  cuyo nombre sea jose===============\n");
        empleadoRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuya edad sea mayor o igual a 25 años===============\n");
        empleadoRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuya edad sea menor o igual a 25 años===============\n");
        empleadoRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo genero sean masculinos===============\n");
        empleadoRepository.getLikeGenero("Masculino").forEach(System.out::println);
        System.out
                .println("\n=================Empleado/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        empleadoRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo telefono sea 1123467895===============\n");
        empleadoRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        empleadoRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        System.out
                .println("\n=================Empleado/s  cuya cantidad de horas semanales sean 48h ===============\n");
        empleadoRepository.getByCantidadHsSemanales(48).forEach(System.out::println);
        // FIN FILTER
    }

}
