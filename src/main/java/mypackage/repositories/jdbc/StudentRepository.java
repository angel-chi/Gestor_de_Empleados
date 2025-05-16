package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mypackage.entities.Student;
import mypackage.repositories.interfaces.I_StudentRepository;

public class StudentRepository implements I_StudentRepository {

    private Connection conexionDB;

    public StudentRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Student student) {
        if (student == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO student(id,nombre, apellido, edad, genero, " +
                                "numero_telefono, correo_electronico, cantidad_materias, matricula, semestre)"
                        + "values(?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, student.getId());
                    consultaPreparada.setString(2, student.getNombre());
                    consultaPreparada.setString(3, student.getApellido());
                    consultaPreparada.setInt(4, student.getEdad());
                    consultaPreparada.setString(5, student.getGenero());
                    consultaPreparada.setLong(6, student.getNumero_telefono());
                    consultaPreparada.setString(7, student.getCorreo_electronico());
                    consultaPreparada.setInt(8, student.getCantidad_materias());
                    consultaPreparada.setLong(9, student.getMatricula());
                    consultaPreparada.setInt(10, student.getSemestre());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        student.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }

    public void aumentaId(Student student) {
        if (student == null) {
            return;
        }
        int id = student.getId();
        int nuevaId = id - 1;
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE student SET id=? WHERE id=?")) {

            consultaPreparada.setInt(1, nuevaId );
            consultaPreparada.setInt(2, id );
            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Student student) {
        if (student == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM student WHERE id=? and nombre=?")) {

            consultaPreparada.setInt(1, student.getId());
            consultaPreparada.setString(2, student.getNombre());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Student student,String nombre, String apellido, String edad, String genero, String correo_electronico, String numero_telefono,String cantidad_materias, String matricula,  String semestre) {
        if (student == null) {
            return;
        }
        if (nombre.isEmpty()) {
            nombre = student.getNombre();
        }
        if (apellido.isEmpty()) {
            apellido = student.getApellido();
        }
        if (edad.isEmpty()) {
            edad = String.valueOf(student.getEdad());
        }
        if (semestre.isEmpty()) {
            semestre = String.valueOf(student.getSemestre());
        }
        if (genero.isEmpty()) {
            genero = student.getGenero();
        }
        if(cantidad_materias.isEmpty()) {
            cantidad_materias = String.valueOf(student.getCantidad_materias());
        }
        if(correo_electronico.isEmpty()) {
            correo_electronico = student.getCorreo_electronico();
        }
        if(numero_telefono.isEmpty()) {
            numero_telefono = String.valueOf(student.getNumero_telefono());
        }
        if(matricula.isEmpty()) {
            matricula = String.valueOf(student.getMatricula());
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE student SET nombre=?,apellido=?,edad=?,genero=?,cantidad_materias=?,"
                        + "correo_electronico=?,numero_telefono=?,matricula=?,semestre=? "
                       + "WHERE id=?")) {

            consultaPreparada.setString(1, nombre);
            consultaPreparada.setString(2, apellido);
            consultaPreparada.setInt(3, Integer.parseInt(edad));
            consultaPreparada.setString(4, genero);
            consultaPreparada.setInt(5, Integer.parseInt(cantidad_materias));
            consultaPreparada.setString(6, correo_electronico);
            consultaPreparada.setLong(7, Integer.parseInt(numero_telefono));
            consultaPreparada.setLong(8, Integer.parseInt(matricula));
            consultaPreparada.setInt(9, Integer.parseInt(semestre));
            consultaPreparada.setInt(10, student.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {

        List<Student> listaStudents = new ArrayList();

        try ( ResultSet resultSetstudent
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM student")) {
                    while (resultSetstudent.next()) {

                        listaStudents.add(new Student(
                                resultSetstudent.getInt("id"),
                                resultSetstudent.getString("nombre"),
                                resultSetstudent.getString("apellido"),
                                resultSetstudent.getInt("edad"),
                                resultSetstudent.getString("genero"),
                                resultSetstudent.getString("correo_electronico"),
                                resultSetstudent.getLong("numero_telefono"),
                                resultSetstudent.getInt("cantidad_materias"),
                                resultSetstudent.getLong("matricula"),
                                resultSetstudent.getInt("semestre")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaStudents;
    }

    public List<Student> getOrdenadoId(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY id "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoNombre(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY nombre "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoApellido(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY apellido "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoEdad(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY edad "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoGenero(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY genero "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoCorreoElectronico(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY correo_electronico "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoNumeroTelefono(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY numero_telefono "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoCantidadMaterias(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY cantidad_materias "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoMatricula(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY matricula "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }

    public List<Student> getOrdenadoSemestre(String orden) {

        List<Student> listaStudents = new ArrayList();
        try ( ResultSet resultSetstudent
                      = conexionDB
                .createStatement()
                .executeQuery("SELECT * FROM student ORDER BY semestre "+orden)) {
            while (resultSetstudent.next()) {

                listaStudents.add(new Student(
                        resultSetstudent.getInt("id"),
                        resultSetstudent.getString("nombre"),
                        resultSetstudent.getString("apellido"),
                        resultSetstudent.getInt("edad"),
                        resultSetstudent.getString("genero"),
                        resultSetstudent.getString("correo_electronico"),
                        resultSetstudent.getInt("numero_telefono"),
                        resultSetstudent.getInt("cantidad_materias"),
                        resultSetstudent.getInt("matricula"),
                        resultSetstudent.getInt("semestre")
                ));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaStudents;
    }
}



