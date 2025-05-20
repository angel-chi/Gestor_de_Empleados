package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_StudentRepository;
import mypackage.repositories.jdbc.StudentRepository;

import java.util.Arrays;

public class TestStudent {

    public static void main(String[] args) {

        
        I_StudentRepository empleadoRepository = new StudentRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Student nuevoStudent
                = new Student(8,"Antonio", "Ibramovich", 34, "Masculino",
                        "liuoyuko@gmail.com", 1567896578, 6,19203235, 5);

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
        System.out.println("\n=================Actualizamos el apellido del Empleado con el id 2 ===============\n");
        nuevoStudent = empleadoRepository.getById(2);

        if (nuevoStudent != null && nuevoStudent.getId() != 0) {
            nuevoStudent.setApellido("Fernandez");
            empleadoRepository.update(nuevoStudent,"","","","","","","","","");
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
        empleadoRepository.getLikeCantidadMaterias("6").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo numero de documento sea 19203235===============\n");
        empleadoRepository.getByCantidadMatricula(Integer.parseInt("19203235")).forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        empleadoRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuyo telefono sea 1123467895===============\n");
        empleadoRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);


        
        System.out.println("\n=================Empleado/s  cuya cantidad de horas semanales sean 48h ===============\n");
        empleadoRepository.getLikeCantidadSemestre(String.valueOf(5)).forEach(System.out::println);


        //FIN FILTER
    }

}
