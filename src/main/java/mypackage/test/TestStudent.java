package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_StudentRepository;
import mypackage.repositories.jdbc.StudentRepository;

public class TestStudent {

    public static void main(String[] args) {

        
        I_StudentRepository studentRepository = new StudentRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Estudiante ===============\n");
        Student nuevoStudent
                = new Student("Antonio", "Ibramovich", 34, "Masculino", "DNI", "21762989",
                        "liuoyuko@gmail.com", "1567896578", String.valueOf(LocalDate.now()), 48, 45000f);

        studentRepository.save(nuevoStudent);
        System.out.println(nuevoStudent);

        System.out.println("\n=================Lista de Estudiantes===============\n");
        studentRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo estudiante ingresado===============\n");
        studentRepository.remove(nuevoStudent);
        System.out.println(nuevoStudent);
        System.out.println("\n=================Lista de Estudiantes actualizada===============\n");
        studentRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Estudiante con el id 2 ===============\n");
        nuevoStudent = studentRepository.getById(2);

        if (nuevoStudent != null && nuevoStudent.getId() != 0) {
            nuevoStudent.setApellido("Fernandez");
            studentRepository.update(nuevoStudent);
        }

        System.out.println("\n=================Lista de Estudiantes actualizada===============\n");
        studentRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
        //FILTER
        System.out.println("\n=================Estudiante/s  cuyo nombre sea jose===============\n");
        studentRepository.getLikeNombre("jose").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuya edad sea mayor o igual a 25 años===============\n");
        studentRepository.getLikeEdadMayorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuya edad sea menor o igual a 25 años===============\n");
        studentRepository.getLikeEdadMenorIgualQue(25).forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo genero sean masculinos===============\n");
        studentRepository.getLikeGenero("Masculino").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo tipo  de documento sea DNI===============\n");
        studentRepository.getLikeTipoDocumento("DNI").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo numero de documento sea 37087123===============\n");
        studentRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        studentRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuyo telefono sea 1123467895===============\n");
        studentRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        studentRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuya cantidad de horas semanales sean 48h ===============\n");
        studentRepository.getByCantidadHsSemanales(48).forEach(System.out::println);

        
        System.out.println("\n=================Estudiante/s  cuyo sueldo sea de $33000 ===============\n");
        studentRepository.getBySueldo(33000f).forEach(System.out::println);

        //FIN FILTER
    }

}
