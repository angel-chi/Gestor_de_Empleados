package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.entities.LicCienciasComputacion;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.interfaces.I_LicCienciasComputacionRepository;
import mypackage.repositories.jdbc.EstudianteRepository;
import mypackage.repositories.jdbc.LicCienciasComputacionRepository;

public class TestLicCienciasComputacion {

    public static void main(String[] args) {

        I_EstudianteRepository EstudianteRepository = new EstudianteRepository(LocalConnector.getLocalConnection());
        I_LicCienciasComputacionRepository LicCienciasComputacionRepository = new LicCienciasComputacionRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Estudiante ===============\n");
        Estudiante nuevoEstudiante
                = new Estudiante("Rafaela", "Cisneros", 36, "Femenina", "DNI", "20123989",
                        "RafaelaSoppurt@gmail.com", "1537994575", String.valueOf(LocalDate.now()), 49, 43000f);

        EstudianteRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
        

        System.out.println("\n=================Agregamos datos del  Estudiante de LicCienciasComputacion con el id_Estudiantes 8 ===============\n");
        LicCienciasComputacion nuevoLicCienciasComputacion = new LicCienciasComputacion(8, "Ayudante Networking Admin", "", "Cisco Academy");

        LicCienciasComputacionRepository.save(nuevoLicCienciasComputacion);
        System.out.println(nuevoLicCienciasComputacion);

        System.out.println("\n=================Lista de Estudiantes de Soporte Tecnico===============\n");
        LicCienciasComputacionRepository.getAll().forEach(System.out::println);

//FIN INSERT
//DELETE
   System.out.println("\n=================Eliminamos el ultimo Estudiante ingresado===============\n");
        EstudianteRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
    System.out.println("\n=================Eliminamos los  datos del ultimo soporte tecnico ingresado===============\n");
        LicCienciasComputacionRepository.remove(nuevoLicCienciasComputacion);
        System.out.println(nuevoLicCienciasComputacion);
        System.out.println("\n=================Lista de actuarios actualizada===============\n");
        LicCienciasComputacionRepository.getAll().forEach(System.out::println);

//FIN DELETE
 //UPDATE
         System.out.println("\n=================Actualizamos las materias_libres_cursadas del soporte tecnico  con el id 1 ===============\n");
        nuevoLicCienciasComputacion = LicCienciasComputacionRepository.getById(1);

        if (nuevoLicCienciasComputacion != null && nuevoLicCienciasComputacion.getId() != 0) {
            nuevoLicCienciasComputacion.setMaterias_libres_cursadas("NetworkingAdvanced, Protocolos Locales, Protocolos Remotos");
            LicCienciasComputacionRepository.update(nuevoLicCienciasComputacion);
        }

        System.out.println("\n=================Lista de Soporte Tecnico actualizada===============\n");
        LicCienciasComputacionRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE

//SELECT
  System.out.println("\n=================Estudiante de  Soporte Tecnico con el id 2===============\n");
        System.out.println(LicCienciasComputacionRepository.getById(2));

        
  System.out.println("\n=================Estudiante de  Soporte Tecnico con el id de Estudiantes 5 ===============\n");
        System.out.println(LicCienciasComputacionRepository.getByIdEstudiantes(5));

          System.out.println("\n=================Estudiante/s de  Soporte Tecnico con el semestre de NetworkingAdmin ===============\n");
        LicCienciasComputacionRepository.getLikesemestre("NetworkingAdmin").forEach(System.out::println);

        
          System.out.println("\n=================Estudiante/s de  Soporte Tecnico con la optativas de Tecnico en Redes===============\n");
        LicCienciasComputacionRepository.getLikeoptativas("Tecnico en Redes").forEach(System.out::println);

        
          System.out.println("\n=================Estudiante/s de  Soporte Tecnico con la certifcacion de Cisco Academy===============\n");
        LicCienciasComputacionRepository.getLikematerias_libres_cursadas("Cisco Academy").forEach(System.out::println);

        

//FIN SELECT
    }

}
