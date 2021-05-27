package model.dao;

import model.Telefone;
import model.TelefoneTipo;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class TelefoneDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public TelefoneDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Telefone> listar() {
        ArrayList<Telefone> postagens = new ArrayList<Telefone>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from telefone;");

            while (set.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(set.getInt("id"));
                telefone.setCodigoArea(set.getString("codigoArea"));
                telefone.setDDD(set.getString("DDD"));
                telefone.setNumero(set.getString("numero"));
                telefone.setTipo(TelefoneTipo.valueOf(set.getString("tipo")));
                telefone.setIdPessoa(set.getInt("idPessoa"));

                postagens.add(telefone);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar postagens: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return postagens;
    }

    public boolean editar(Telefone telefone) {
        Boolean isSalvo = false;
        String query = "UPDATE telefone SET " + "codigoArea = ?," + "DDD = ?," + "numero = ?," + "tipo = ?,"
                + "idPessoa = ? " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setString(4, telefone.getTipo().name());
            preparedStatement.setInt(5, (int) telefone.getIdPessoa());
            preparedStatement.setInt(6, (int) telefone.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar telefone: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Telefone telefone) {
        Boolean isSalvo = false;
        String query = "insert into telefone (codigoArea,DDD,numero,tipo,idPessoa) values (?,?,?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setString(4, telefone.getTipo().name());
            preparedStatement.setInt(5, (int) telefone.getIdPessoa());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar telefone: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemPessoa(Telefone telefone) {
        Boolean isSalvo = false;
        String query = "insert into telefone (codigoArea,DDD,numero,tipo) values (?,?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, telefone.getCodigoArea());
            preparedStatement.setString(2, telefone.getDDD());
            preparedStatement.setString(3, telefone.getNumero());
            preparedStatement.setString(4, telefone.getTipo().name());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar telefone: " + e.getMessage());
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
        String query = "delete from telefone " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar telefone: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Telefone findByID(int id) {
        Telefone telefone = new Telefone();
        String query = "select * from telefone " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                telefone.setId(set.getInt("id"));
                telefone.setCodigoArea(set.getString("codigoArea"));
                telefone.setDDD(set.getString("DDD"));
                telefone.setNumero(set.getString("numero"));
                telefone.setTipo(TelefoneTipo.valueOf(set.getString("tipo")));
                telefone.setIdPessoa(set.getInt("idPessoa"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao deletar telefone: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return telefone;
    }
}