package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.entities.Egresado;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.interfaces.I_EgresadoRepository;
import mypackage.repositories.jdbc.EstudianteRepository;
import mypackage.repositories.jdbc.EgresadoRepository;

public class TestEgresado {

    public static void main(String[] args) {

        I_EstudianteRepository EstudianteRepository = new EstudianteRepository(LocalConnector.getLocalConnection());
        I_EgresadoRepository EgresadoRepository = new EgresadoRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Estudiante ===============\n");
        Estudiante nuevoEstudiante
                = new Estudiante("Yamila", "Raskovik", 42, "Femenina", "DNI", "25678614",
                        "hjhasava@hotmail.com", "1556348791", String.valueOf(LocalDate.now()), 51, 54000f);

        EstudianteRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Agregamos datos del nuevo Egresado del Area de licIngDesSoftware ===============\n");
        Egresado nuevoEgresado = new Egresado(20, "licIngDesSoftware", "Dr en psicología", 1);

        EgresadoRepository.save(nuevoEgresado);
        System.out.println(nuevoEgresado);

        System.out.println("\n=================Lista de  egresados actualizada===============\n");
        EgresadoRepository.getAll().forEach(System.out::println);

//FIN INSERT
//UPDATE
        System.out.println("\n=================Actualizamos el carrera_estudiada del Egresado   con el id 1 ===============\n");
        nuevoEgresado = EgresadoRepository.getById(1);

        if (nuevoEgresado != null && nuevoEgresado.getId() != 0) {
            nuevoEgresado.setCarrera_estudiada("Soporte Tecnico");
            EgresadoRepository.update(nuevoEgresado);
        }

        System.out.println("\n=================Lista de egresados actualizada===============\n");
        EgresadoRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
//DELETE
        System.out.println("\n=================Eliminamos los  datos del ultimo Egresado ingresado===============\n");
        EgresadoRepository.remove(nuevoEgresado);
        System.out.println(nuevoEgresado);
        System.out.println("\n=================Eliminamos el ultimo Estudiante ingresado===============\n");
        EstudianteRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Lista de egresados actualizada===============\n");
        EgresadoRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Egresado con el id 1===============\n");
        System.out.println(EgresadoRepository.getById(1));

        System.out.println("\n=================Egresado   con el id de Estudiantes 1 ===============\n");
        System.out.println(EgresadoRepository.getByIdEstudiantes(1));

        System.out.println("\n=================Egresado/s  del carrera_estudiada de Soporte Tecnico ===============\n");
        EgresadoRepository.getLikecarrera_estudiada("Soporte Tecnico").forEach(System.out::println);

        System.out.println("\n=================Egresado/s   con la habilidad de Licenciado en licIngDesSoftware===============\n");
        EgresadoRepository.getLikeoptativas(" Licenciado en licIngDesSoftware").forEach(System.out::println);

        System.out.println("\n=================Egresado/s   con 2 años de año_egreso===============\n");
        EgresadoRepository.getByaño_egreso(2).forEach(System.out::println);

//FIN SELECT
    }

}
