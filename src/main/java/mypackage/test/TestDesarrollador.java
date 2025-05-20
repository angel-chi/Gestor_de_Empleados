
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Desarrollador;
import mypackage.repositories.jdbc.DesarrolladorRepository;

public class TestDesarrollador {
    
    public static void main(String[] args) {
        
    
          DesarrolladorRepository DesarrolladorRepository = new DesarrolladorRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos datos del Desarrollador con el id 7===============\n");
        Desarrollador nuevoDesarrollador
                = new Desarrollador(7, "Front End Dev Jr", "Sistemas Distribuidos", "Desarrollador", 0);
        DesarrolladorRepository.save(nuevoDesarrollador);
        System.out.println(nuevoDesarrollador);

        System.out.println("\n=================Lista de Desarrollador===============\n");
        DesarrolladorRepository.getAll().forEach(System.out::println);
        //FIN INSERT
        
          //REMOVE
        System.out.println("\n=================Eliminamos los  datos del ultimo Desarrollador ingresado===============\n");
        DesarrolladorRepository.remove(nuevoDesarrollador);
        System.out.println(nuevoDesarrollador);
        System.out.println("\n=================Lista de Desarrolladornionio actualizada===============\n");
        DesarrolladorRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
         
        
        //UPDATE
         System.out.println("\n=================Actualizamos las certificaciones del desrrollador con el id2 ===============\n");
        nuevoDesarrollador = DesarrolladorRepository.getById(2);

        if (nuevoDesarrollador != null && nuevoDesarrollador.getId() != 0) {
            nuevoDesarrollador.setCertificaciones("Ethical Hacker, ArquitectSoftware, Web Scrapping ");
            DesarrolladorRepository.update(nuevoDesarrollador);
        }

        System.out.println("\n=================Lista de Desarrollador actualizada===============\n");
        DesarrolladorRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE
        
        //SELECT
                System.out.println("\n=================Desarrollador con el id 3 de estudiantes===============\n");
        System.out.println(DesarrolladorRepository.getByIdestudiantes(3));
        
        System.out.println("\n=================Desarrollador/es con el puesto de Front End Dev===============\n");
        DesarrolladorRepository.getLikePuesto("Front End Dev").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con la certificacion de  Design UX===============\n");
        DesarrolladorRepository.getLikeCertificaciones("Design UX").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con la habilidad de Autodidacta===============\n");
        DesarrolladorRepository.getLikeHabilidades("Autodidacta").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con mas de 2 proyectos en Produccion===============\n");
        System.out.println(  DesarrolladorRepository.getLikeProyectosEnProduccionMayorQue(2));
        
        
        
        //FIN SELECT

}
}