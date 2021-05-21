package model.dao;

import model.Usuario;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public UsuarioDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from usuario;");

            while (set.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(set.getInt("id"));
                usuario.setUsuario(set.getString("usuario"));
                usuario.setSenha(set.getString("senha"));
                usuario.setIdPessoa(set.getInt("idPessoa"));

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar usuarios: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return usuarios;
    }

    public boolean editar(Usuario usuario) {
        Boolean isSalvo = false;
        String query = "UPDATE usuario SET " + "usuario = ?," + "senha = ?," + "idPessoa = ? " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setInt(3, usuario.getIdPessoa());
            preparedStatement.setInt(4, usuario.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar usuario: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Usuario usuario) {
        Boolean isSalvo = false;
        String query = "insert into usuario (usuario,senha,idPessoa) values (?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setInt(3, usuario.getIdPessoa());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar usuario: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemPessoa(Usuario usuario) {
        Boolean isSalvo = false;
        String query = "insert into usuario (usuario,senha) values (?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao salvar usuario: " + e.getMessage());
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
        String query = "delete from usuario " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar usuario: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Usuario findByID(int id) {
        Usuario usuario = new Usuario();
        String query = "select * from usuario " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                usuario.setId(set.getInt("id"));
                usuario.setUsuario(set.getString("usuario"));
                usuario.setSenha(set.getString("senha"));
                usuario.setIdPessoa(set.getInt("idPessoa"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar usuario: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return usuario;
    }
}