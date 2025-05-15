package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_StudentRepository;
import mypackage.repositories.jdbc.StudentRepository;

public class TestEmpleado {

    public static void main(String[] args) {

        
        I_StudentRepository empleadoRepository = new StudentRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Student ===============\n");
        Student nuevoStudent
                = new Student(1,"Antonio", "Ibramovich", 34, "Masculino", "DNI", "21762989",
                        "liuoyuko@gmail.com", "1567896578",2,48);

        empleadoRepository.save(nuevoStudent);
        System.out.println(nuevoStudent);

        System.out.println("\n=================Lista de Empleados===============\n");
        empleadoRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoStudent);
        System.out.println(nuevoStudent);
        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Student con el id 2 ===============\n");
        nuevoStudent = empleadoRepository.getById(2);

        if (nuevoStudent != null && nuevoStudent.getId() != 0) {
            nuevoStudent.setApellido("Fernandez");
            empleadoRepository.update(nuevoStudent);
        }

        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================Student/s  cuyo nombre sea jose===============\n");
        empleadoRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Student/s  cuya edad sea mayor o igual a 25 años===============\n");
        empleadoRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Student/s  cuya edad sea menor o igual a 25 años===============\n");
        empleadoRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Student/s  cuyo genero sean masculinos===============\n");
        empleadoRepository.getLikeGenero("Masculino").forEach(System.out::println);
/*
        System.out.println("\n=================Student/s  cuyo tipo  de documento sea DNI===============\n");
        empleadoRepository.getLikeTipoDocumento("DNI").forEach(System.out::println);

        System.out.println("\n=================Student/s  cuyo numero de documento sea 37087123===============\n");
        empleadoRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================Student/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        empleadoRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Student/s  cuyo telefono sea 1123467895===============\n");
        empleadoRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        
        System.out.println("\n=================Student/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        empleadoRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================Student/s  cuya cantidad de horas semanales sean 48h ===============\n");
        empleadoRepository.getByCantidadHsSemanales(48).forEach(System.out::println);

        
        System.out.println("\n=================Student/s  cuyo sueldo sea de $33000 ===============\n");
        empleadoRepository.getBySueldo(33000f).forEach(System.out::println);
*/
        //FIN FILTER
    }

}
