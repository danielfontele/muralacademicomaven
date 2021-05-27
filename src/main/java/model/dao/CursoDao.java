package model.dao;

import model.Curso;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class CursoDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public CursoDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Curso> listar() {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from curso;");

            while (set.next()) {
                Curso curso = new Curso();
                curso.setId(set.getInt("id"));
                curso.setNome(set.getString("nome"));
                curso.setIdPostagem(set.getInt("idPostagem"));

                cursos.add(curso);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao listar cursos: " + e.getMessage());
        }

        return cursos;
    }

    public boolean editar(Curso curso) {
        Boolean isSalvo = false;
        String query = "UPDATE curso SET " + "nome = ?," + "idPostagem = ? " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setInt(2, curso.getIdPostagem());
            preparedStatement.setInt(3, curso.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar curso: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Curso curso) {
        Boolean isSalvo = false;
        String query = "insert into curso (nome,idPostagem) values (?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setInt(2, curso.getIdPostagem());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar curso: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemPostagem(Curso curso) {
        Boolean isSalvo = false;
        String query = "insert into curso (nome) values (?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, curso.getNome());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar curso: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean deletar(int id) {
        Boolean isSalvo = false;
        String query = "delete from curso " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar curso: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Curso findByID(int id) {
        Curso curso = new Curso();
        String query = "select * from curso " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                curso.setId(set.getInt("id"));
                curso.setNome(set.getString("nome"));
                curso.setIdPostagem(set.getInt("idPostagem"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao deletar curso: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return curso;
    }

}
