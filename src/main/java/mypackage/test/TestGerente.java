package mypackage.test;

//import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Alumno;
import mypackage.entities.Gerente;
import mypackage.repositories.interfaces.I_AlumnoRepository;
import mypackage.repositories.interfaces.I_GerenteRepository;
import mypackage.repositories.jdbc.AlumnoRepository;
import mypackage.repositories.jdbc.GerenteRepository;

public class TestGerente {

    public static void main(String[] args) {

        I_AlumnoRepository alumnoRepository = new AlumnoRepository(LocalConnector.getLocalConnection());
        I_GerenteRepository gerenteRepository = new GerenteRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Alumno nuevoAlumo
                = new Alumno("Andres", "Colli", 20, "Masculino", "Progrmacion orientada a objetos", "A23216427",
                        8.7, "23 de agosto", "A23216427@alumnos.uady.com");

        alumnoRepository.save(nuevoAlumo);
        System.out.println(nuevoAlumo);

        System.out.println("\n=================Agregamos datos del nuevo gerente del Area de administracion ===============\n");
        Gerente nuevoGerente = new Gerente(20, "Administracion", "Dr en psicología", 1);

        gerenteRepository.save(nuevoGerente);
        System.out.println(nuevoGerente);

        System.out.println("\n=================Lista de  Gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

//FIN INSERT
//UPDATE
        System.out.println("\n=================Actualizamos el sector del gerente   con el id 1 ===============\n");
        nuevoGerente = gerenteRepository.getById(1);

        if (nuevoGerente != null && nuevoGerente.getId() != 0) {
            nuevoGerente.setSector("Soporte Tecnico");
            gerenteRepository.update(nuevoGerente);
        }

        System.out.println("\n=================Lista de gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
//DELETE
        System.out.println("\n=================Eliminamos los  datos del ultimo gerente ingresado===============\n");
        gerenteRepository.remove(nuevoGerente);
        System.out.println(nuevoGerente);
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        alumnoRepository.remove(nuevoAlumo);
        System.out.println(nuevoAlumo);

        System.out.println("\n=================Lista de Gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Gerente con el id 1===============\n");
        System.out.println(gerenteRepository.getById(1));

        System.out.println("\n=================Gerente   con el id de empleados 1 ===============\n");
        System.out.println(gerenteRepository.getByIdAlumnos(1));

        System.out.println("\n=================Gerente/s  del sector de Soporte Tecnico ===============\n");
        gerenteRepository.getLikeSector("Soporte Tecnico").forEach(System.out::println);

        System.out.println("\n=================Gerente/s   con la habilidad de Licenciado en administracion===============\n");
        gerenteRepository.getLikeFormacion(" Licenciado en administracion").forEach(System.out::println);

        System.out.println("\n=================Gerente/s   con 2 años de antiguedad===============\n");
        gerenteRepository.getByAntiguedad(2).forEach(System.out::println);

//FIN SELECT
    }

}
