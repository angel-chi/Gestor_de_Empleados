package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Empleado;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jdbc.EmpleadoRepository;

public class TestEmpleado {

    public static void main(String[] args) {

        
        I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Empleado nuevoEmpleado
                = new Empleado("Antonio", "Ibramovich", 34, "Masculino", "DNI", "21762989",
                        "liuoyuko@gmail.com", "1567896578", String.valueOf(LocalDate.now()), 48, 45000f);

        empleadoRepository.save(nuevoEmpleado);
        System.out.println(nuevoEmpleado);

        System.out.println("\n=================Lista de Empleados===============\n");
        empleadoRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoEmpleado);
        System.out.println(nuevoEmpleado);
        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Empleado con el id 2 ===============\n");
        nuevoEmpleado = empleadoRepository.getById(2);

        if (nuevoEmpleado != null && nuevoEmpleado.getId() != 0) {
            nuevoEmpleado.setApellido("Fernandez");
            empleadoRepository.update(nuevoEmpleado);
        }

        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================Empleado/s  cuyo nombre sea jose===============\n");
        empleadoRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuya edad sea mayor o igual a 25 años===============\n");
        empleadoRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuya edad sea menor o igual a 25 años===============\n");
        empleadoRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo genero sean masculinos===============\n");
        empleadoRepository.getLikeGenero("Masculino").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo tipo  de documento sea DNI===============\n");
        empleadoRepository.getLikeTipoDocumento("DNI").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo numero de documento sea 37087123===============\n");
        empleadoRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        empleadoRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuyo telefono sea 1123467895===============\n");
        empleadoRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        empleadoRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuya cantidad de horas semanales sean 48h ===============\n");
        empleadoRepository.getByCantidadHsSemanales(48).forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuyo sueldo sea de $33000 ===============\n");
        empleadoRepository.getBySueldo(33000f).forEach(System.out::println);

        //FIN FILTER
    }

}
