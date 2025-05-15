package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.LicIngDesSoftware;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_LicIngDesSoftwareRepository;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.jdbc.LicIngDesSoftwareRepository;
import mypackage.repositories.jdbc.EstudianteRepository;

public class TestLicIngDesSoftware{

    public static void main(String[] args) {

        I_EstudianteRepository EstudianteRepository = new EstudianteRepository(LocalConnector.getLocalConnection());
        I_LicIngDesSoftwareRepository licIngDesSoftwareRepository = new LicIngDesSoftwareRepository(LocalConnector.getLocalConnection()) {
        };

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Estudiante ===============\n");
        Estudiante nuevoEstudiante
                = new Estudiante("Oscar", "Mastruli", 25, "Masculino", "DNI", "45128789",
                        "Oscarmastruli@gmail.com", "1576859045", String.valueOf(LocalDate.now()), 48, 44000f);

        EstudianteRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Agregamos datos del nuevo Estudiante del Area de licIngDesSoftware ===============\n");
        LicIngDesSoftware nuevoAdministrador = new LicIngDesSoftware(3, "Ayudante de Administrador", "Organizcion, Conocimientos en PC");

        licIngDesSoftwareRepository.save(nuevoAdministrador);
        System.out.println(nuevoAdministrador);

        System.out.println("\n=================Lista de Estudiantes de Admistracion===============\n");
        licIngDesSoftwareRepository.getAll().forEach(System.out::println);

//FIN INSERT
//UPDATE
        System.out.println("\n=================Actualizamos el semestre del administrador  con el id 1 ===============\n");
        nuevoAdministrador = licIngDesSoftwareRepository.getById(1);

        if (nuevoAdministrador != null && nuevoAdministrador.getId() != 0) {
            nuevoAdministrador.setSemestre("Administradora General");
            licIngDesSoftwareRepository.update(nuevoAdministrador);
        }

        System.out.println("\n=================Lista de Administradores actualizada===============\n");
        licIngDesSoftwareRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
//DELETE
        System.out.println("\n=================Eliminamos el ultimo Estudiante ingresado===============\n");
        EstudianteRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
        System.out.println("\n=================Eliminamos los  datos del ultimo Estudiante de licIngDesSoftware ingresado===============\n");
        licIngDesSoftwareRepository.remove(nuevoAdministrador);
        System.out.println(nuevoAdministrador);
        System.out.println("\n=================Lista de Administradores actualizada===============\n");
        licIngDesSoftwareRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Estudiante de  licIngDesSoftware con el id 1===============\n");
        System.out.println(licIngDesSoftwareRepository.getById(1));

        System.out.println("\n=================Estudiante de  licIngDesSoftware  con el id de Estudiantes 1 ===============\n");
        System.out.println(licIngDesSoftwareRepository.getByIdEstudiantes(1));

        System.out.println("\n=================Estudiante/s de  licIngDesSoftware  con el semestre de Administradora General ===============\n");
        licIngDesSoftwareRepository.getLikesemestre("Administradora General").forEach(System.out::println);

        System.out.println("\n=================Estudiante/s de  licIngDesSoftware  con la habilidad de predisposicion===============\n");
        licIngDesSoftwareRepository.getLikematerias_debidas("predisposicion").forEach(System.out::println);

//FIN SELECT
    }

}
