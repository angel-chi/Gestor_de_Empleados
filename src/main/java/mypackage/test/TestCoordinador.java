
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Coordinadores;
import mypackage.repositories.interfaces.I_CoordinadorRepository;
import mypackage.repositories.jdbc.CoordinadorRepository;

public class TestCoordinador {
    
    public static void main(String[] args) {
        
    
          I_CoordinadorRepository coordinadorRepository = new CoordinadorRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos datos del Coordinador con el id 7===============\n");
        Coordinadores nuevoCoordinadores
                = new Coordinadores(7, "Front End Dev Jr", "Sistemas Distribuidos", "Desarrollo", 0);
        coordinadorRepository.save(nuevoCoordinadores);
        System.out.println(nuevoCoordinadores);

        System.out.println("\n=================Lista de Coordinadores===============\n");
        coordinadorRepository.getAll().forEach(System.out::println);
        //FIN INSERT
        
          //REMOVE
        System.out.println("\n=================Eliminamos los  datos del ultimo coordinador ingresado===============\n");
        coordinadorRepository.remove(nuevoCoordinadores);
        System.out.println(nuevoCoordinadores);
        System.out.println("\n=================Lista de Coordinadores actualizada===============\n");
        coordinadorRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
         
        
        //UPDATE
         System.out.println("\n=================Actualizamos las certificaciones del coordinador con el id2 ===============\n");
        nuevoCoordinadores = coordinadorRepository.getById(2);

        if (nuevoCoordinadores != null && nuevoCoordinadores.getId() != 0) {
            nuevoCoordinadores.setTitulo("Ethical Hacker, ArquitectSoftware, Web Scrapping ");
            coordinadorRepository.update(nuevoCoordinadores);
        }

        System.out.println("\n=================Lista de coordinadores actualizada===============\n");
        coordinadorRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE
        
        //SELECT
                System.out.println("\n================= Coordinador con el id 3 de Empleados===============\n");
        System.out.println(coordinadorRepository.getByIdAlumnos(3));
        
        System.out.println("\n=================Coordinador/es con el puesto de Front End Dev===============\n");
        coordinadorRepository.getLikePuesto("Front End Dev").forEach(System.out::println);

        
        System.out.println("\n=================Coordinador/es con la certificacion de  Design UX===============\n");
        coordinadorRepository.getLikeCertificaciones("Design UX").forEach(System.out::println);

        
        System.out.println("\n=================Coordinador/es con la habilidad de Autodidacta===============\n");
        coordinadorRepository.getLikeHabilidades("Autodidacta").forEach(System.out::println);

        
        System.out.println("\n=================Coordinador/es con mas de 2 proyectos en Produccion===============\n");
        System.out.println(  coordinadorRepository.getLikeProyectosEnProduccionMayorQue(2));
        
        
        
        //FIN SELECT

}
}