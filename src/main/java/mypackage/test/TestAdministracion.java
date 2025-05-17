package mypackage.test;

import java.time.LocalDate;

import jdk.internal.jimage.ImageStream;
import mypackage.connector.LocalConnector;
import mypackage.entities.Administracion_CE;
import mypackage.entities.Alumnos;
import mypackage.repositories.interfaces.I_AdministracionRepository;
import mypackage.repositories.interfaces.I_AlumnosRepository;
import mypackage.repositories.jdbc.AdministracionRepository;
import mypackage.repositories.jdbc.AlumnosRepository;

public class TestAdministracion {

    public static void main(String[] args) {

        I_AlumnosRepository empleadoRepository = new AlumnosRepository(LocalConnector.getLocalConnection());
        I_AdministracionRepository administracionRepository = new AdministracionRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Alumno ===============\n");
        ImageStream resultSetAlumnos = null;
        Alumnos nuevoAlumnos = new Alumnos(0, "Oscar", "Mastruli", 25, "Masculino", "tercero", "01/05",
                        "Oscarmastruli@gmail.com", "1576859045", String.valueOf(LocalDate.now()), 48, 44000f);

        empleadoRepository.save(nuevoAlumnos);
        System.out.println(nuevoAlumnos);

        System.out.println("\n=================Agregamos datos del nuevo Alumno del Area de administracion ===============\n");
        Administracion_CE nuevoAdministrador = new Administracion_CE(3, "Ayudante de Administrador", "Organizcion, Conocimientos en PC");

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
        System.out.println("\n=================Eliminamos el ultimo alumno ingresado===============\n");
        empleadoRepository.remove(nuevoAlumnos);
        System.out.println(nuevoAlumnos);
        System.out.println("\n=================Eliminamos los  datos del ultimo alumno de administracion ingresado===============\n");
        administracionRepository.remove(nuevoAdministrador);
        System.out.println(nuevoAdministrador);
        System.out.println("\n=================Lista de Administradores actualizada===============\n");
        administracionRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Empleado de  Administracion con el id 1===============\n");
        System.out.println(administracionRepository.getById(1));

        System.out.println("\n=================Empleado de  Administracion  con el id de empleados 1 ===============\n");
        System.out.println(administracionRepository.getByIdAlumnos(1));

        System.out.println("\n=================Empleado/s de  Administracion  con el puesto de Administradora General ===============\n");
        administracionRepository.getLikePuesto("Administradora General").forEach(System.out::println);

        System.out.println("\n=================Empleado/s de  Administracion  con la habilidad de predisposicion===============\n");
        administracionRepository.getLikeHabilidades("predisposicion").forEach(System.out::println);

//FIN SELECT
    }

}
