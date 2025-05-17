package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Estudiante;
import mypackage.repositories.interfaces.I_EstudianteRepository;
import mypackage.repositories.interfaces.I_PresidenteEstudiantilRepository;
import mypackage.repositories.jdbc.EstudianteRepository;
import mypackage.repositories.jdbc.PresidenteEstudiantilRepository;

public class TestGerente {

    public static void main(String[] args) {

        I_EstudianteRepository empleadoRepository = new EstudianteRepository(LocalConnector.getLocalConnection());
        I_PresidenteEstudiantilRepository gerenteRepository = new PresidenteEstudiantilRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Estudiante nuevoEstudiante
                = new Estudiante("Yamila", "Raskovik", 42, "Femenina", "DNI", "25678614",
                        "hjhasava@hotmail.com", "1556348791", String.valueOf(LocalDate.now()), 51, 54000f);

        empleadoRepository.save(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Agregamos datos del nuevo gerente del Area de administracion ===============\n");
        mypackage.entities.PresidenteEstudiantil nuevoPresidenteEstudiantil = new mypackage.entities.PresidenteEstudiantil(20, "Administracion", "Dr en psicología", 1);

        gerenteRepository.save(nuevoPresidenteEstudiantil);
        System.out.println(nuevoPresidenteEstudiantil);

        System.out.println("\n=================Lista de  Gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

//FIN INSERT
//UPDATE
        System.out.println("\n=================Actualizamos el sector del gerente   con el id 1 ===============\n");
        nuevoPresidenteEstudiantil = gerenteRepository.getById(1);

        if (nuevoPresidenteEstudiantil != null && nuevoPresidenteEstudiantil.getId() != 0) {
            nuevoPresidenteEstudiantil.setFacultad("Soporte Tecnico");
            gerenteRepository.update(nuevoPresidenteEstudiantil);
        }

        System.out.println("\n=================Lista de gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

        //FIN UPDATE
//DELETE
        System.out.println("\n=================Eliminamos los  datos del ultimo gerente ingresado===============\n");
        gerenteRepository.remove(nuevoPresidenteEstudiantil);
        System.out.println(nuevoPresidenteEstudiantil);
        System.out.println("\n=================Eliminamos el ultimo empleado ingresado===============\n");
        empleadoRepository.remove(nuevoEstudiante);
        System.out.println(nuevoEstudiante);

        System.out.println("\n=================Lista de Gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Gerente con el id 1===============\n");
        System.out.println(gerenteRepository.getById(1));

        System.out.println("\n=================Gerente   con el id de empleados 1 ===============\n");
        System.out.println(gerenteRepository.getByMatriculaEstudiante(1));

        System.out.println("\n=================Gerente/s  del sector de Soporte Tecnico ===============\n");
        gerenteRepository.getLikeFacultad("Soporte Tecnico").forEach(System.out::println);

        System.out.println("\n=================Gerente/s   con la habilidad de Licenciado en administracion===============\n");
        gerenteRepository.getLikePeriodo(" Licenciado en administracion").forEach(System.out::println);

        System.out.println("\n=================Gerente/s   con 2 años de antiguedad===============\n");
        gerenteRepository.getByCantidadProyectos(2).forEach(System.out::println);

//FIN SELECT
    }

}
