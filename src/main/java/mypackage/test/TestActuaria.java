
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Actuaria;
import mypackage.repositories.interfaces.I_ActuariaRepository;
import mypackage.repositories.jdbc.ActuariaRepository;

public class TestActuaria {
    
    public static void main(String[] args) {
        
    
          I_ActuariaRepository ActuariaRepository = new ActuariaRepository(LocalConnector.getLocalConnection());

        //INSERT
        System.out.println("\n=================Agregamos datos del Actuaria con el id 7===============\n");
        Actuaria nuevoActuaria
                = new Actuaria(7, "Front End Dev Jr", "Sistemas Distribuidos", "Desarrollo", 0);
        ActuariaRepository.save(nuevoActuaria);
        System.out.println(nuevoActuaria);

        System.out.println("\n=================Lista de actuarios===============\n");
        ActuariaRepository.getAll().forEach(System.out::println);
        //FIN INSERT
        
          //REMOVE
        System.out.println("\n=================Eliminamos los  datos del ultimo Actuaria ingresado===============\n");
        ActuariaRepository.remove(nuevoActuaria);
        System.out.println(nuevoActuaria);
        System.out.println("\n=================Lista de actuarios actualizada===============\n");
        ActuariaRepository.getAll().forEach(System.out::println);

        //FIN REMOVE
         
        
        //UPDATE
         System.out.println("\n=================Actualizamos las materias_libres_cursadas del desrrollador con el id2 ===============\n");
        nuevoActuaria = ActuariaRepository.getById(2);

        if (nuevoActuaria != null && nuevoActuaria.getId() != 0) {
            nuevoActuaria.setMaterias_libres_cursadas("Ethical Hacker, ArquitectSoftware, Web Scrapping ");
            ActuariaRepository.update(nuevoActuaria);
        }

        System.out.println("\n=================Lista de actuarios actualizada===============\n");
        ActuariaRepository.getAll().forEach(System.out::println);

        
        //FIN UPDATE
        
        //SELECT
                System.out.println("\n=================Actuaria con el id 3 de Estudiantes===============\n");
        System.out.println(ActuariaRepository.getByIdEstudiantes(3));
        
        System.out.println("\n=================Actuaria/es con el semestre de Front End Dev===============\n");
        ActuariaRepository.getLikesemestre("Front End Dev").forEach(System.out::println);

        
        System.out.println("\n=================Actuaria/es con la certificacion de  Design UX===============\n");
        ActuariaRepository.getLikematerias_libres_cursadas("Design UX").forEach(System.out::println);

        
        System.out.println("\n=================Actuaria/es con la habilidad de Autodidacta===============\n");
        ActuariaRepository.getLikematerias_debidas("Autodidacta").forEach(System.out::println);

        
        System.out.println("\n=================Actuaria/es con mas de 2 proyectos en Produccion===============\n");
        System.out.println(  ActuariaRepository.getLikeProyectosEnProduccionMayorQue(2));
        
        
        
        //FIN SELECT

}
}