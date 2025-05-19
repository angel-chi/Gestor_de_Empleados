package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Administracion;
import mypackage.entities.Empleado;
import mypackage.entities.Gerente;
import mypackage.repositories.interfaces.I_AdministracionRepository;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.interfaces.I_GerenteRepository;
import mypackage.repositories.jdbc.AdministracionRepository;
import mypackage.repositories.jdbc.EmpleadoRepository;
import mypackage.repositories.jdbc.GerenteRepository;

public class TestGerente {

    public static void main(String[] args) {

        I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(LocalConnector.getLocalConnection());
        I_GerenteRepository gerenteRepository = new GerenteRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos un nuevo Empleado ===============\n");
        Empleado nuevoEmpleado
                = new Empleado("Yamila", "Raskovik", 42, "Femenina", "DNI", "25678614",
                        "hjhasava@hotmail.com", "1556348791", String.valueOf(LocalDate.now()), 51, 54000f);

        empleadoRepository.save(nuevoEmpleado);
        System.out.println(nuevoEmpleado);

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
        empleadoRepository.remove(nuevoEmpleado);
        System.out.println(nuevoEmpleado);

        System.out.println("\n=================Lista de Gerentes actualizada===============\n");
        gerenteRepository.getAll().forEach(System.out::println);

//FIN DELETE
//SELECT
        System.out.println("\n=================Gerente con el id 1===============\n");
        System.out.println(gerenteRepository.getById(1));

        System.out.println("\n=================Gerente   con el id de empleados 1 ===============\n");
        System.out.println(gerenteRepository.getByIdEmpleados(1));

        System.out.println("\n=================Gerente/s  del sector de Soporte Tecnico ===============\n");
        gerenteRepository.getLikeSector("Soporte Tecnico").forEach(System.out::println);

        System.out.println("\n=================Gerente/s   con la habilidad de Licenciado en administracion===============\n");
        gerenteRepository.getLikeFormacion(" Licenciado en administracion").forEach(System.out::println);

        System.out.println("\n=================Gerente/s   con 2 años de antiguedad===============\n");
        gerenteRepository.getByAntiguedad(2).forEach(System.out::println);

//FIN SELECT
    }

}
