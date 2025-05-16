package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Student;
import mypackage.entities.SoporteTecnico;
import mypackage.repositories.interfaces.I_StudentRepository;
import mypackage.repositories.interfaces.I_SoporteTecnicoRepository;
import mypackage.repositories.jdbc.StudentRepository;
import mypackage.repositories.jdbc.SoporteTecnicoRepository;

public class TestSoporteTecnico {

    public static void main(String[] args) {

        I_StudentRepository studentRepository = new StudentRepository(LocalConnector.getLocalConnection());
        I_SoporteTecnicoRepository soporteTecnicoRepository = new SoporteTecnicoRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Estudiante ===============\n");
        Student nuevoStudent
                = new Student("Rafaela", "Cisneros", 36, "Femenina", "DNI", "20123989",
                        "RafaelaSoppurt@gmail.com", "1537994575", String.valueOf(LocalDate.now()), 49, 43000f);

        studentRepository.save(nuevoStudent);
        System.out.println(nuevoStudent);
        

        System.out.println("\n=================Agregamos datos del  Estudiante de soporteTecnico con el id_estudiantes 8 ===============\n");
        SoporteTecnico nuevoSoporteTecnico = new SoporteTecnico(8, "Ayudante Networking Admin", "", "Cisco Academy");

        soporteTecnicoRepository.save(nuevoSoporteTecnico);
        System.out.println(nuevoSoporteTecnico);

        System.out.println("\n=================Lista de Estudiantes de Soporte Tecnico===============\n");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

//FIN INSERT
//DELETE
   System.out.println("\n=================Eliminamos el ultimo estudiante ingresado===============\n");
        studentRepository.remove(nuevoStudent);
        System.out.println(nuevoStudent);
    System.out.println("\n=================Eliminamos los  datos del ultimo soporte tecnico ingresado===============\n");
        soporteTecnicoRepository.remove(nuevoSoporteTecnico);
        System.out.println(nuevoSoporteTecnico);
        System.out.println("\n=================Lista de Desarrolladores actualizada===============\n");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

//FIN DELETE
 //UPDATE
         System.out.println("\n=================Actualizamos las certificaciones del soporte tecnico  con el id 1 ===============\n");
        nuevoSoporteTecnico = soporteTecnicoRepository.getById(1);

        if (nuevoSoporteTecnico != null && nuevoSoporteTecnico.getId() != 0) {
            nuevoSoporteTecnico.setCertificaciones("NetworkingAdvanced, Protocolos Locales, Protocolos Remotos");
            soporteTecnicoRepository.update(nuevoSoporteTecnico);
        }

        System.out.println("\n=================Lista de Soporte Tecnico actualizada===============\n");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE

//SELECT
  System.out.println("\n=================Estudiante de  Soporte Tecnico con el id 2===============\n");
        System.out.println(soporteTecnicoRepository.getById(2));

        
  System.out.println("\n=================Estudiante de  Soporte Tecnico con el id de estudiantes 5 ===============\n");
        System.out.println(soporteTecnicoRepository.getByIdStudents(5));

          System.out.println("\n=================Estudiante/s de  Soporte Tecnico con el puesto de NetworkingAdmin ===============\n");
        soporteTecnicoRepository.getLikePuesto("NetworkingAdmin").forEach(System.out::println);

        
          System.out.println("\n=================Estudiante/s de  Soporte Tecnico con la formacion de Tecnico en Redes===============\n");
        soporteTecnicoRepository.getLikeFormacion("Tecnico en Redes").forEach(System.out::println);

        
          System.out.println("\n=================Estudiante/s de  Soporte Tecnico con la certifcacion de Cisco Academy===============\n");
        soporteTecnicoRepository.getLikeCertificaciones("Cisco Academy").forEach(System.out::println);

        

//FIN SELECT
    }

}
