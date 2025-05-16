package mypackage.test;

import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.cj.jdbc.CallableStatement;
import mypackage.connector.LocalConnector;
import mypackage.entities.Alumno;
import mypackage.repositories.interfaces.I_AlumnoRepository;
import mypackage.repositories.jdbc.AlumnoRepository;

public class TestEmpleado {

    public static void main(String[] args){

        
        I_AlumnoRepository empleadoRepository = new AlumnoRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Alumno nuevoAlumno
                = new Alumno(2, "Antonio", "Perech", 23, "Masculino", "2",
                        "liuoyuko@gmail.com", "1567896578", 48, 45000f);

        empleadoRepository.save(nuevoAlumno);
        System.out.println(nuevoAlumno);

        System.out.println("\n=================Lista de Empleados===============\n");
        empleadoRepository.getAll().forEach(System.out::println);
        //FIN INSERT

        //REMOVE
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoAlumno);
        System.out.println(nuevoAlumno);
        System.out.println("\n=================Lista de Empleados actualizada===============\n");
        empleadoRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
        //UPDATE
        System.out.println("\n=================Actualizamos el apellido del Empleado con el id 2 ===============\n");
        nuevoAlumno = empleadoRepository.getById(2);

        if (nuevoAlumno != null && nuevoAlumno.getId() != 0) {
            nuevoAlumno.setApellido("Fernandez");
            empleadoRepository.update(nuevoAlumno);
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
        empleadoRepository.getLikeSemestre("DNI").forEach(System.out::println);

        //System.out.println("\n=================Empleado/s  cuyo numero de documento sea 37087123===============\n");
        //empleadoRepository.getLikeNumeroDocumento("37087123").forEach(System.out::println);

        System.out.println("\n=================Empleado/s  cuyo correo electronico sea romi2@gmail.com===============\n");
        empleadoRepository.getLikeCorreoElectronico("romi2@gmail.com").forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuyo telefono sea 1123467895===============\n");
        empleadoRepository.getLikeNumeroTelefono("1123467895").forEach(System.out::println);

        
        //System.out.println("\n=================Empleado/s  cuya fecha de inicio sea el 2020-09-12 ===============\n");
        //empleadoRepository.getLikeFechaInicio("2020-09-12").forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuya cantidad de horas semanales sean 48h ===============\n");
        empleadoRepository.getByMatricula(48).forEach(System.out::println);

        
        System.out.println("\n=================Empleado/s  cuyo sueldo sea de $33000 ===============\n");
        empleadoRepository.getByPromedio(33000f).forEach(System.out::println);

        //FIN FILTER
    }

}
