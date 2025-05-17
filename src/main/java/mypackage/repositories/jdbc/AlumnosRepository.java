package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Alumnos;
import mypackage.repositories.interfaces.I_AlumnosRepository;

public class AlumnosRepository implements I_AlumnosRepository {

    private Connection conexionDB;

    public AlumnosRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Alumnos alumnos) {
        if (alumnos == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB.prepareStatement(
                        "INSERT INTO alumnos(matricula,nombre,apellido,edad,genero,semestre,"
                        + "inicio_semestre,fin_semestre,correo,telefono,promedio)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS))
        {

                    consultaPreparada.setInt(1, alumnos.getMatricula());
                    consultaPreparada.setString(2, alumnos.getNombre());
                    consultaPreparada.setString(3, alumnos.getApellido());
                    consultaPreparada.setInt(4, alumnos.getEdad());
                    consultaPreparada.setString(5, alumnos.getGenero());
                    consultaPreparada.setString(6, alumnos.getSemestre());
                    consultaPreparada.setString(7, alumnos.getinicio_semestre());
                    consultaPreparada.setString(8, alumnos.getfin_semestre());
                    consultaPreparada.setString(9, alumnos.getcorreo());
                    consultaPreparada.setString(10, alumnos.gettelefono());
                   // consultaPreparada.setInt(11, alumnos.getMateria());
                    consultaPreparada.setFloat(11, alumnos.getpromedio());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        alumnos.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    @Override
    public void remove(Alumnos alumnos) {
        if (alumnos == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM alumnos WHERE id=?")) {

            consultaPreparada.setInt(1, alumnos.getMatricula());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Alumnos alumnos) {
        if (alumnos == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE alumnos SET nombre=?,apellido=?,edad=?,genero=?,semestre=?,"
                        + " matricula=?,correo=?,telefono=?,inicio_semestre=?,fin_semestre=?,promedio=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, alumnos.getNombre());
            consultaPreparada.setString(2, alumnos.getApellido());
            consultaPreparada.setInt(3, alumnos.getEdad());
            consultaPreparada.setString(4, alumnos.getGenero());
            consultaPreparada.setString(5, alumnos.getSemestre());
            consultaPreparada.setString(6, alumnos.getfin_semestre());
            consultaPreparada.setString(7, alumnos.getcorreo());
            consultaPreparada.setString(8, alumnos.gettelefono());
            consultaPreparada.setString(9, alumnos.getinicio_semestre());
           // consultaPreparada.setInt(10, alumnos.getMateria());
            consultaPreparada.setFloat(11, alumnos.getpromedio());
            consultaPreparada.setInt(12, alumnos.getMatricula());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Alumnos> getAll() {

        List<Alumnos> listaAlumnos = new ArrayList<>();

        try ( ResultSet resultSetAlumnos
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM alumnos")) {
                    while (resultSetAlumnos.next()) {

                        listaAlumnos.add(new Alumnos(
                                resultSetAlumnos.getInt("id"),
                                resultSetAlumnos.getString("nombre"),
                                resultSetAlumnos.getString("apellido"),
                                resultSetAlumnos.getInt("edad"),
                                resultSetAlumnos.getString("genero"),
                                resultSetAlumnos.getString("semestre"),
                                resultSetAlumnos.getString("matricula"),
                                resultSetAlumnos.getString("correo"),
                                resultSetAlumnos.getString("telefono"),
                                resultSetAlumnos.getString("inicio_semestre"),
                                resultSetAlumnos.getInt("fin_semestre"),
                                resultSetAlumnos.getFloat("promedio")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaAlumnos;
    }

}
