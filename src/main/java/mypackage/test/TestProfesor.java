package mypackage.test;

import java.time.LocalDate;

//import jdk.internal.jimage.ImageStream;
import mypackage.connector.LocalConnector;
import mypackage.entities.Alumnos;
import mypackage.entities.Profesores;
import mypackage.repositories.interfaces.I_AlumnosRepository;
import mypackage.repositories.interfaces.I_GerenteRepository;
import mypackage.repositories.jdbc.AlumnosRepository;
import mypackage.repositories.jdbc.GerenteRepository;

public class TestProfesor {

    public static void main(String[] args) {

        I_AlumnosRepository empleadoRepository = new AlumnosRepository(LocalConnector.getLocalConnection());
        I_GerenteRepository profesorRepository = new GerenteRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Profesor ===============\n");
        //ImageStream resultSetAlumnos = null;
        Alumnos nuevoAlumnos = new Alumnos(0, "Yamila", "Raskovik", 42, "Femenina", "DNI", "25678614",
                        "hjhasava@hotmail.com", "1556348791", String.valueOf(LocalDate.now()), 51, 54000f);

        empleadoRepository.save(nuevoAlumnos);
        System.out.println(nuevoAlumnos);

        System.out.println("\n=================Agregamos datos del nuevo profesor del Area de administracion ===============\n");
        Profesores nuevoProfesores = new Profesores(20, "Administracion", "Dr en psicología", 1);

        profesorRepository.save(nuevoProfesores);
        System.out.println(nuevoProfesores);

        System.out.println("\n=================Lista de  profesores actualizada===============\n");
        profesorRepository.getAll().forEach(System.out::println);

//FIN INSERT
//UPDATE
        System.out.println("\n=================Actualizamos el sector del profesor   con el id 1 ===============\n");
        nuevoProfesores = profesorRepository.getById(1);

        if (nuevoProfesores != null && nuevoProfesores.getId() != 0) {
            nuevoProfesores.setPuesto("Soporte Tecnico");
            profesorRepository.update(nuevoProfesores);
        }

        System.out.println("\n=================Lista de profesores actualizada===============\n");
        profesorRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
//DELETE
        System.out.println("\n=================Eliminamos los  datos del ultimo profesor ingresado===============\n");
        profesorRepository.remove(nuevoProfesores);
        System.out.println(nuevoProfesores);
        System.out.println("\n=================Eliminamos el ultimo profesor ingresado===============\n");
        empleadoRepository.remove(nuevoAlumnos);
        System.out.println(nuevoAlumnos);

        System.out.println("\n=================Lista de profesores actualizada===============\n");
        profesorRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Profesor con el id 1===============\n");
        System.out.println(profesorRepository.getById(1));

        System.out.println("\n=================Profesor   con el id de empleados 1 ===============\n");
        System.out.println(profesorRepository.getByIdEmpleados(1));

        System.out.println("\n=================Profesor/s  del sector de Soporte Tecnico ===============\n");
        profesorRepository.getLikeSector("Soporte Tecnico").forEach(System.out::println);

        System.out.println("\n=================Profesor/s   con la habilidad de Licenciado en administracion===============\n");
        profesorRepository.getLikeFormacion(" Licenciado en administracion").forEach(System.out::println);

        System.out.println("\n=================Profesor/s   con 2 años de antiguedad===============\n");
        profesorRepository.getByAntiguedad(2).forEach(System.out::println);

//FIN SELECT
    }

}
