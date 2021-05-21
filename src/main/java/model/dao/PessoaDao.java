package model.dao;

import model.Pessoa;
import model.utilDao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class PessoaDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public PessoaDao() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public ArrayList<Pessoa> listar() {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet set;

        try {
            statement = con.createStatement();
            set = statement.executeQuery("select * from pessoa;");

            while (set.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(set.getInt("id"));
                pessoa.setNome(set.getString("nome"));
                pessoa.setCpf(set.getString("cpf"));
                pessoa.setEmail(set.getString("email"));

                pessoas.add(pessoa);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar pessoas: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return pessoas;
    }

    public boolean editar(Pessoa pessoa) {
        Boolean isSalvo = false;
        String query = "UPDATE pessoa SET " + "nome = ?," + "cpf = ?," + "email = ?, " + "idEndereco = ? "
                + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setInt(4, pessoa.getIdEndereco());
            preparedStatement.setInt(5, pessoa.getId());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao editar pessoa: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvar(Pessoa pessoa) {
        Boolean isSalvo = false;
        String query = "insert into pessoa (nome,cpf,email,idEndereco) values (?,?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setInt(4, pessoa.getIdEndereco());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar pessoa: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public boolean salvarSemEndereco(Pessoa pessoa) {
        Boolean isSalvo = false;
        String query = "insert into pessoa (nome,cpf,email) values (?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getEmail());

            preparedStatement.execute();
            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar pessoa: " + e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }

    public boolean deletar(int id) {
        Boolean isSalvo = false;
        String query = "delete from pessoa " + "WHERE id = ?;";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            con.commit();
            isSalvo = true;
        } catch (Exception e) {
            System.err.println("Erro ao deletar pessoa: " + e.getMessage());
            isSalvo = false;
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

    public Pessoa findByID(int id) {
        Pessoa pessoa = new Pessoa();
        String query = "select * from pessoa " + "WHERE id = " + id + ";";
        ResultSet set;
        try {
            preparedStatement = con.prepareStatement(query);

            set = preparedStatement.executeQuery();

            while (set.next()) {
                pessoa.setId(set.getInt("id"));
                pessoa.setNome(set.getString("nome"));
                pessoa.setCpf(set.getString("cpf"));
                pessoa.setEmail(set.getString("email"));
                pessoa.setIdEndereco(set.getInt("idEndereco"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao deletar pessoa: " + e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return pessoa;
    }

    public boolean salvarComTelefones(Pessoa pessoa) {
        boolean isSalvo = false;
        String queryPessoa = "insert into pessoa (nome,cpf,email,idEndereco) values (?,?,?,?);";
        String queryTelefone = "INSERT INTO telefone(codigoArea, DDD, numero, tipo, idPessoa) " + "VALUES (?,?,?,?,?);";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(queryPessoa);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setInt(4, pessoa.getIdEndereco());

            preparedStatement.execute();

            int idTemp = 0;
            try {
                ResultSet rset = preparedStatement.executeQuery("select last_insert_id() as id;");
                while (rset.next()) {
                    idTemp = rset.getInt("id");
                }
            } catch (Exception e) {
                e.printStackTrace();
                con.rollback();
            }

            final int idPessoa = idTemp;

            pessoa.getTelefones().forEach(telefone -> {
                try {
                    preparedStatement = con.prepareStatement(queryTelefone);
                    preparedStatement.setString(1, telefone.getCodigoArea());
                    preparedStatement.setString(2, telefone.getDDD());
                    preparedStatement.setString(3, telefone.getNumero());
                    preparedStatement.setString(4, String.valueOf(telefone.getTipo()));
                    preparedStatement.setInt(5, idPessoa);

                    preparedStatement.execute();

                } catch (SQLException e) {
                    try {
                        con.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }

            });

            con.commit();
            isSalvo = true;

        } catch (Exception e) {
            System.err.println("Erro ao salvar pessoa: " + e.getMessage());
            isSalvo = false;
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Erro ao fecha a conexão: " + e.getMessage());
        }
        return isSalvo;
    }

}