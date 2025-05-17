
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Matematicas;
import mypackage.repositories.interfaces.I_MatematicasRepository;
import mypackage.repositories.jdbc.MatematicasRepository;

public class TestDesarrollador {
    
    public static void main(String[] args) {
        
    
          I_MatematicasRepository desarrolladorRepository = new MatematicasRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos datos del Desarrollador con el id 7===============\n");
        Matematicas nuevoMatematicas
                = new Matematicas(7, "Front End Dev Jr", "Sistemas Distribuidos", "Desarrollo", 0);
        desarrolladorRepository.save(nuevoMatematicas);
        System.out.println(nuevoMatematicas);

        System.out.println("\n=================Lista de Desarrolladores===============\n");
        desarrolladorRepository.getAll().forEach(System.out::println);
        //FIN INSERT
        
          //REMOVE
        System.out.println("\n=================Eliminamos los  datos del ultimo desarrollador ingresado===============\n");
        desarrolladorRepository.remove(nuevoMatematicas);
        System.out.println(nuevoMatematicas);
        System.out.println("\n=================Lista de Desarrolladores actualizada===============\n");
        desarrolladorRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
         
        
        //UPDATE
         System.out.println("\n=================Actualizamos las certificaciones del desrrollador con el id2 ===============\n");
        nuevoMatematicas = desarrolladorRepository.getById(2);

        if (nuevoMatematicas != null && nuevoMatematicas.getId() != 0) {
            nuevoMatematicas.setPrograma("Ethical Hacker, ArquitectSoftware, Web Scrapping ");
            desarrolladorRepository.update(nuevoMatematicas);
        }

        System.out.println("\n=================Lista de desarrolladores actualizada===============\n");
        desarrolladorRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE
        
        //SELECT
                System.out.println("\n=================Desarrollador con el id 3 de Empleados===============\n");
        System.out.println(desarrolladorRepository.getByMatriculaEstudiante(3));
        
        System.out.println("\n=================Desarrollador/es con el puesto de Front End Dev===============\n");
        desarrolladorRepository.getLikeNivel("Front End Dev").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con la certificacion de  Design UX===============\n");
        desarrolladorRepository.getLikePrograma("Design UX").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con la habilidad de Autodidacta===============\n");
        desarrolladorRepository.getLikeEstatus("Autodidacta").forEach(System.out::println);

        
        System.out.println("\n=================Desarrollador/es con mas de 2 proyectos en Produccion===============\n");
        System.out.println(  desarrolladorRepository.getLikePromedioActualMayorQue(2));
        
        
        
        //FIN SELECT

}
}