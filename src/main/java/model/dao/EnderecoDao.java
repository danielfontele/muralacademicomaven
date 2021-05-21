package model.dao;

import model.Endereco;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class EnderecoDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public EnderecoDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Endereco> listar() {
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from endereco;");

            while (set.next()) {
                Endereco endereco = new Endereco();
                endereco.setRua(set.getString("rua"));
                endereco.setNumero(set.getString("numero"));
                endereco.setComplemento(set.getString("complemento"));
                endereco.setBairro(set.getString("bairro"));
                endereco.setCidade(set.getString("cidade"));
                endereco.setEstado(set.getString("estado"));

                enderecos.add(endereco);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar enderecos: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return enderecos;
    }

    public boolean editar(Endereco endereco) {
        Boolean isSalvo = false;
        String query = "UPDATE endereco SET " + "rua = ?," + "numero = ?," + "complemento = ?," + "bairro = ?,"
                + "cidade = ?," + "estado = ? " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getComplemento());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.setString(5, endereco.getCidade());
            preparedStatement.setString(6, endereco.getEstado());
            preparedStatement.setInt(7, endereco.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar endereco: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Endereco endereco) {
        Boolean isSalvo = false;
        String query = "insert into endereco (rua,numero,complemento,bairro,cidade,estado) values (?,?,?,?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getComplemento());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.setString(5, endereco.getCidade());
            preparedStatement.setString(6, endereco.getEstado());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar endereco: " + e.getMessage());
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
        String query = "delete from endereco " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar endereco: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Endereco findByID(int id) {
        Endereco endereco = new Endereco();
        String query = "select * from endereco " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                endereco.setId(set.getInt("id"));
                endereco.setRua(set.getString("rua"));
                endereco.setNumero(set.getString("numero"));
                endereco.setComplemento(set.getString("complemento"));
                endereco.setBairro(set.getString("bairro"));
                endereco.setCidade(set.getString("cidade"));
                endereco.setEstado(set.getString("estado"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar endereco: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return endereco;
    }
}
