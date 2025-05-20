package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Administracion;
import mypackage.entities.Alumno;
import mypackage.repositories.interfaces.I_AdministracionRepository;
import mypackage.repositories.interfaces.I_AlumnoRepository;
import mypackage.repositories.jdbc.AdministracionRepository;
import mypackage.repositories.jdbc.AlumnoRepository;

public class TestAdministracion {

    public static void main(String[] args) {

        I_AlumnoRepository empleadoRepository = new AlumnoRepository(LocalConnector.getLocalConnection());
        I_AdministracionRepository administracionRepository = new AdministracionRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Alumno nuevoAlumno
                = new Alumno(1, "Oscar", "Maestruli", 25, "Masculino", "5",
                        "Oscarmastruli@gmail.com", "1576859045", 48, 44000f);

        empleadoRepository.save(nuevoAlumno);
        System.out.println(nuevoAlumno);

        System.out.println("\n=================Agregamos datos del nuevo Empleado del Area de administracion ===============\n");
        Administracion nuevoAdministrador = new Administracion(3, "Ayudante de Administrador", "Organizcion, Conocimientos en PC");

        administracionRepository.save(nuevoAdministrador);
        System.out.println(nuevoAdministrador);

        System.out.println("\n=================Lista de Empleados de Admistracion===============\n");
        administracionRepository.getAll().forEach(System.out::println);

//FIN INSERT
//UPDATE
        System.out.println("\n=================Actualizamos el puesto del administrador  con el id 1 ===============\n");
        nuevoAdministrador = administracionRepository.getById(1);

        if (nuevoAdministrador != null && nuevoAdministrador.getId() != 0) {
            nuevoAdministrador.setPuesto("Administradora General");
            administracionRepository.update(nuevoAdministrador);
        }

        System.out.println("\n=================Lista de Administradores actualizada===============\n");
        administracionRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
//DELETE
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoAlumno);
        System.out.println(nuevoAlumno);
        System.out.println("\n=================Eliminamos los  datos del ultimo empleado de administracion ingresado===============\n");
        administracionRepository.remove(nuevoAdministrador);
        System.out.println(nuevoAdministrador);
        System.out.println("\n=================Lista de Administradores actualizada===============\n");
        administracionRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Empleado de  Administracion con el id 1===============\n");
        System.out.println(administracionRepository.getById(1));

        System.out.println("\n=================Empleado de  Administracion  con el id de empleados 1 ===============\n");
        System.out.println(administracionRepository.getByIdEmpleados(1));

        System.out.println("\n=================Empleado/s de  Administracion  con el puesto de Administradora General ===============\n");
        administracionRepository.getLikePuesto("Administradora General").forEach(System.out::println);

        System.out.println("\n=================Empleado/s de  Administracion  con la habilidad de predisposicion===============\n");
        administracionRepository.getLikeHabilidades("predisposicion").forEach(System.out::println);

//FIN SELECT
    }

}
