
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Coordinadores;
import mypackage.repositories.interfaces.I_CoordinadorRepository;


public class CoordinadorRepository implements I_CoordinadorRepository {

    
    private Connection conexionDB;

    public CoordinadorRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
     @Override
    public void save(Coordinadores coordinadores) {
        if (coordinadores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO desarrolladores(id,id_empleados,puesto,certificaciones,habilidades,proyectos_en_produccion)"
                        + "values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, coordinadores.getId());
                    consultaPreparada.setInt(2, coordinadores.getId_alumnos());
                    consultaPreparada.setString(3, coordinadores.getPuesto());
                    consultaPreparada.setString(4, coordinadores.getTitulo());
                    consultaPreparada.setString(5, coordinadores.getHabilidades());
                    consultaPreparada.setInt(6, coordinadores.getSupervisa_a());
                    
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        coordinadores.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
   
      @Override
    public void remove(Coordinadores coordinadores) {
        if (coordinadores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM desarrolladores WHERE id=?")) {

            consultaPreparada.setInt(1, coordinadores.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void update(Coordinadores coordinadores) {
        if (coordinadores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE desarrolladores SET id_empleados=?,puesto=?,certificaciones=?,habilidades=?,proyectos_en_produccion=? "
                       + "WHERE id=?")) {

            consultaPreparada.setInt(1, coordinadores.getId_alumnos());
            consultaPreparada.setString(2, coordinadores.getPuesto());
            consultaPreparada.setString(3, coordinadores.getTitulo());
            consultaPreparada.setString(4, coordinadores.getHabilidades());
            consultaPreparada.setInt(5, coordinadores.getSupervisa_a());
            consultaPreparada.setInt(6, coordinadores.getId());
            
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<Coordinadores> getAll() {

        List<Coordinadores> listaDesarrolladores = new ArrayList();

        try ( ResultSet resultSetDesarrolladores
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM desarrolladores")) {
                    while (resultSetDesarrolladores.next()) {

                        listaDesarrolladores.add(new Coordinadores(
                                resultSetDesarrolladores.getInt("id"),
                                resultSetDesarrolladores.getInt("id_empleados"),
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
