
package mypackage.test;

import java.time.LocalDate;
import mypackage.connector.LocalConnector;
import mypackage.entities.Desarrollador;
import mypackage.repositories.interfaces.I_DesarrolladorRepository;
import mypackage.repositories.jdbc.DesarrolladorRepository;

public class TestDesarrollador {
    
    public static void main(String[] args) {
        
    
          I_DesarrolladorRepository desarrolladorRepository = new DesarrolladorRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos datos del Desarrollador con el id 7===============\n");
        Desarrollador nuevoDesarrollador
                = new Desarrollador(7, "Front End Dev Jr", "Sistemas Distribuidos", "Desarrollo", 0);
        desarrolladorRepository.save(nuevoDesarrollador);
        System.out.println(nuevoDesarrollador);

        System.out.println("\n=================Lista de Desarrolladores===============\n");
        desarrolladorRepository.getAll().forEach(System.out::println);
        //FIN INSERT
        
          //REMOVE
        System.out.println("\n=================Eliminamos los  datos del ultimo desarrollador ingresado===============\n");
        desarrolladorRepository.remove(nuevoDesarrollador);
        System.out.println(nuevoDesarrollador);
        System.out.println("\n=================Lista de Desarrolladores actualizada===============\n");
        desarrolladorRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
         
        
        //UPDATE
         System.out.println("\n=================Actualizamos las certificaciones del desrrollador con el id2 ===============\n");
        nuevoDesarrollador = desarrolladorRepository.getById(2);

        if (nuevoDesarrollador != null && nuevoDesarrollador.getId() != 0) {
            nuevoDesarrollador.setCertificaciones("Ethical Hacker, ArquitectSoftware, Web Scrapping ");
            desarrolladorRepository.update(nuevoDesarrollador);
        }

        System.out.println("\n=================Lista de desarrolladores actualizada===============\n");
        desarrolladorRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE
        
        //SELECT
                System.out.println("\n=================Desarrollador con el id 3 de Empleados===============\n");
        System.out.println(desarrolladorRepository.getByIdEmpleados(3));
        
        System.out.println("\n=================Desarrollador/es con el puesto de Front End Dev===============\n");
        desarrolladorRepository.getLikePuesto("Front End Dev").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con la certificacion de  Design UX===============\n");
        desarrolladorRepository.getLikeCertificaciones("Design UX").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con la habilidad de Autodidacta===============\n");
        desarrolladorRepository.getLikeHabilidades("Autodidacta").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con mas de 2 proyectos en Produccion===============\n");
        System.out.println(  desarrolladorRepository.getLikeProyectosEnProduccionMayorQue(2));
        
        
        
        //FIN SELECT

}
}