package model.dao;

import model.Palestrante;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;


public class PalestranteDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public PalestranteDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Palestrante> listar() {
        ArrayList<Palestrante> palestrantes = new ArrayList<Palestrante>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from palestrante;");

            while (set.next()) {
                Palestrante palestrante = new Palestrante();
                palestrante.setId(set.getInt("id"));
                palestrante.setUsuario(set.getString("usuario"));
                palestrante.setSenha(set.getString("senha"));
                palestrante.setIdPessoa(set.getInt("idPessoa"));

                palestrantes.add(palestrante);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar palestrantes: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return palestrantes;
    }

    public boolean editar(Palestrante palestrante) {
        Boolean isSalvo = false;
        String query = "UPDATE palestrante SET " + "usuario = ?," + "senha = ?," + "idPessoa = ? " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, palestrante.getUsuario());
            preparedStatement.setString(2, palestrante.getSenha());
            preparedStatement.setInt(3, palestrante.getIdPessoa());
            preparedStatement.setInt(4, palestrante.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar palestrante: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Palestrante palestrante) {
        Boolean isSalvo = false;
        String query = "insert into palestrante (usuario,senha,idPessoa) values (?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, palestrante.getUsuario());
            preparedStatement.setString(2, palestrante.getSenha());
            preparedStatement.setInt(3, palestrante.getIdPessoa());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar palestrante: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemPessoa(Palestrante palestrante) {
        Boolean isSalvo = false;
        String query = "insert into palestrante (usuario,senha) values (?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, palestrante.getUsuario());
            preparedStatement.setString(2, palestrante.getSenha());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar palestrante: " + e.getMessage());
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
        String query = "delete from palestrante " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar palestrante: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Palestrante findByID(int id) {
        Palestrante palestrante = new Palestrante();
        String query = "select * from palestrante " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                palestrante.setId(set.getInt("id"));
                palestrante.setUsuario(set.getString("usuario"));
                palestrante.setSenha(set.getString("senha"));
                palestrante.setIdPessoa(set.getInt("idPessoa"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao deletar palestrante: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return palestrante;
    }
}