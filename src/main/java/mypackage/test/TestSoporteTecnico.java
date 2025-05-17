package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.entities.Quimica;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.interfaces.I_QuimicaRepository;
import mypackage.repositories.jdbc.EstudianteRepository;
import mypackage.repositories.jdbc.QuimicaRepository;

public class TestSoporteTecnico {

    public static void main(String[] args) {

        I_EstudianteRepository empleadoRepository = new EstudianteRepository(LocalConnector.getLocalConnection());
        I_QuimicaRepository soporteTecnicoRepository = new QuimicaRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Estudiante nuevoEstudiante
                = new Estudiante("Rafaela", "Cisneros", 36, "Femenina", "DNI", "20123989",
                        "RafaelaSoppurt@gmail.com", "1537994575", String.valueOf(LocalDate.now()), 49, 43000f);

        empleadoRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
        

        System.out.println("\n=================Agregamos datos del  Empleado de soporteTecnico con el id_empleados 8 ===============\n");
        Quimica nuevoQuimica = new Quimica(8, "Ayudante Networking Admin", "", "Cisco Academy");

        soporteTecnicoRepository.save(nuevoQuimica);
        System.out.println(nuevoQuimica);

        System.out.println("\n=================Lista de Empleados de Soporte Tecnico===============\n");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

//FIN INSERT
//DELETE
   System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);
    System.out.println("\n=================Eliminamos los  datos del ultimo soporte tecnico ingresado===============\n");
        soporteTecnicoRepository.remove(nuevoQuimica);
        System.out.println(nuevoQuimica);
        System.out.println("\n=================Lista de Desarrolladores actualizada===============\n");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

//FIN DELETE
 //UPDATE
         System.out.println("\n=================Actualizamos las certificaciones del soporte tecnico  con el id 1 ===============\n");
        nuevoQuimica = soporteTecnicoRepository.getById(1);

        if (nuevoQuimica != null && nuevoQuimica.getId() != 0) {
            nuevoQuimica.setEstatus("NetworkingAdvanced, Protocolos Locales, Protocolos Remotos");
            soporteTecnicoRepository.update(nuevoQuimica);
        }

        System.out.println("\n=================Lista de Soporte Tecnico actualizada===============\n");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE

//SELECT
  System.out.println("\n=================Empleado de  Soporte Tecnico con el id 2===============\n");
        System.out.println(soporteTecnicoRepository.getById(2));

        
  System.out.println("\n=================Empleado de  Soporte Tecnico con el id de empleados 5 ===============\n");
        System.out.println(soporteTecnicoRepository.getByMatriculaEstudiantes(5));

          System.out.println("\n=================Empleado/s de  Soporte Tecnico con el puesto de NetworkingAdmin ===============\n");
        soporteTecnicoRepository.getLikeNivel("NetworkingAdmin").forEach(System.out::println);

        
          System.out.println("\n=================Empleado/s de  Soporte Tecnico con la formacion de Tecnico en Redes===============\n");
        soporteTecnicoRepository.getLikePrograma("Tecnico en Redes").forEach(System.out::println);

        
          System.out.println("\n=================Empleado/s de  Soporte Tecnico con la certifcacion de Cisco Academy===============\n");
        soporteTecnicoRepository.getLikeEstatus("Cisco Academy").forEach(System.out::println);

        

//FIN SELECT
    }

}
