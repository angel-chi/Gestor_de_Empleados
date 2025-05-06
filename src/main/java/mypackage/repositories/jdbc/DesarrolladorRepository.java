
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Desarrollador;
import mypackage.repositories.interfaces.I_DesarrolladorRepository;


public class DesarrolladorRepository implements I_DesarrolladorRepository {

    
    private Connection conexionDB;

    public DesarrolladorRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Desarrollador desarrollador) {
        if (desarrollador == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO desarrolladores(id,id_estudiantes,puesto,certificaciones,habilidades,proyectos_en_produccion)"
                        + "values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, desarrollador.getId());
                    consultaPreparada.setInt(2, desarrollador.getId_estudiantes());
                    consultaPreparada.setString(3, desarrollador.getPuesto());
                    consultaPreparada.setString(4, desarrollador.getCertificaciones());
                    consultaPreparada.setString(5, desarrollador.getHabilidades());
                    consultaPreparada.setInt(6, desarrollador.getProyectos_en_produccion());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        desarrollador.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
   
      @Override
    public void remove(Desarrollador desarrollador) {
        if (desarrollador == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM desarrolladores WHERE id=?")) {

            consultaPreparada.setInt(1, desarrollador.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void update(Desarrollador desarrollador) {
        if (desarrollador == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE desarrolladores SET id_estudiantes=?,puesto=?,certificaciones=?,habilidades=?,proyectos_en_produccion=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, desarrollador.getId_estudiantes());
            consultaPreparada.setString(2, desarrollador.getPuesto());
            consultaPreparada.setString(3, desarrollador.getCertificaciones());
            consultaPreparada.setString(4, desarrollador.getHabilidades());
            consultaPreparada.setInt(5, desarrollador.getProyectos_en_produccion());
            consultaPreparada.setInt(6, desarrollador.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<Desarrollador> getAll() {

        List<Desarrollador> listaDesarrolladores = new ArrayList();

        try ( ResultSet resultSetDesarrolladores
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM desarrolladores")) {
                    while (resultSetDesarrolladores.next()) {

                        listaDesarrolladores.add(new Desarrollador(
                                resultSetDesarrolladores.getInt("id"),
                                resultSetDesarrolladores.getInt("id_estudiantes"),
                                resultSetDesarrolladores.getString("puesto"),
                                resultSetDesarrolladores.getString("certificaciones"),
                                resultSetDesarrolladores.getString("habilidades"),
                                resultSetDesarrolladores.getInt("proyectos_en_produccion")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaDesarrolladores;
    }

}
