package model.dao;

import model.Postagem;
import model.utilDao.ConnectionFactory;
import java.time.LocalDate;

import java.sql.*;
import java.util.ArrayList;

public class PostagemDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public PostagemDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Postagem> listar() {
        ArrayList<Postagem> postagens = new ArrayList<Postagem>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from postagem;");

            while (set.next()) {
                Postagem postagem = new Postagem();
                postagem.setId(set.getInt("id"));
                postagem.setConteudo(set.getString("conteudo"));
                postagem.setData(convertToLocalDateViaSqlDate(set.getDate("data")));
                postagem.setIdPalestrante(set.getInt("idPalestrante"));
                postagem.setTitulo(set.getString("titulo"));

                postagens.add(postagem);
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

    public boolean editar(Postagem postagem) {
        Boolean isSalvo = false;
        String query = "UPDATE postagem SET " + "titulo = ?," + "conteudo = ?," + "data = ?," + "idPalestrante = ? "
                + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, postagem.getTitulo());
            preparedStatement.setString(2, postagem.getConteudo());
            preparedStatement.setDate(3, java.sql.Date.valueOf(postagem.getData()));
            preparedStatement.setInt(4, (int) postagem.getIdPalestrante());
            preparedStatement.setInt(5, (int) postagem.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar postagem: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Postagem postagem) {
        Boolean isSalvo = false;
        String query = "insert into postagem (titulo,conteudo,data,idPalestrante) values (?,?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, postagem.getTitulo());
            preparedStatement.setString(2, postagem.getConteudo());
            preparedStatement.setDate(3, java.sql.Date.valueOf(postagem.getData()));
            preparedStatement.setInt(4, postagem.getIdPalestrante());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar postagem: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemPalestrante(Postagem postagem) {
        Boolean isSalvo = false;
        String query = "insert into postagem (titulo,conteudo,data) values (?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, postagem.getTitulo());
            preparedStatement.setString(2, postagem.getConteudo());
            preparedStatement.setDate(3, java.sql.Date.valueOf(postagem.getData()));

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar postagem: " + e.getMessage());
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
        String query = "delete from postagem " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar postagem: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Postagem findByID(int id) {
        Postagem postagem = new Postagem();
        String query = "select * from postagem " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                postagem.setId(set.getInt("id"));
                postagem.setConteudo(set.getString("conteudo"));
                postagem.setData(convertToLocalDateViaSqlDate(set.getDate("data")));
                postagem.setIdPalestrante(set.getInt("idPalestrante"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao deletar postagem: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return postagem;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
}