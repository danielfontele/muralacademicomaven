package model.dao;

import model.Categoria;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class CategoriaDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public CategoriaDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Categoria> listar() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from categoria;");

            while (set.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(set.getInt("id"));
                categoria.setNome(set.getString("nome"));
                categoria.setIdPostagem(set.getInt("idPostagem"));

                categorias.add(categoria);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return categorias;
    }

    public boolean editar(Categoria categoria) {
        Boolean isSalvo = false;
        String query = "UPDATE categoria SET " + "nome = ?," + "idPostagem = ? " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, categoria.getNome());
            preparedStatement.setInt(2, categoria.getIdPostagem());
            preparedStatement.setInt(3, categoria.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar categoria: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemPostagem(Categoria categoria) {
        Boolean isSalvo = false;
        String query = "insert into categoria (nome) values (?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, categoria.getNome());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar categoria: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Categoria categoria) {
        Boolean isSalvo = false;
        String query = "insert into categoria (nome,idPostagem) values (?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, categoria.getNome());
            preparedStatement.setInt(1, categoria.getIdPostagem());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar categoria: " + e.getMessage());
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
        String query = "delete from categoria " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar categoria: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Categoria findByID(int id) {
        Categoria categoria = new Categoria();
        String query = "select * from categoria " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                categoria.setId(set.getInt("id"));
                categoria.setNome(set.getString("nome"));
                categoria.setIdPostagem(set.getInt("idPostagem"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar categoria: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return categoria;
    }

}
