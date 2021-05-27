package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.PessoaController;
import model.Pessoa;

public class TestePessoa {
    PessoaController pessoaController = new PessoaController();
    List<Pessoa> pessoasTeste = pessoaController.listar();

    @Test
    void listarPessoa() {
        List<Pessoa> pessoas = pessoaController.listar();
        assertFalse(pessoas.isEmpty());
        assertEquals(pessoas.size(), pessoasTeste.size());
        assertEquals(pessoas.get(0).getCpf(), pessoasTeste.get(0).getCpf());

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("95825029834");
        assertEquals(pessoa.getCpf(), pessoaController.listar().get(0).getCpf());

    }

    @Test
    void salvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa Teste 001");
        pessoa.setCpf("352.982.466-64");
        pessoa.setEmail("pessoa_teste@example.com");

        assertTrue(pessoaController.salvar(pessoa));
        pessoa.setCpf("999.999.999-99");
        assertFalse(pessoaController.salvar(pessoa));
    }

    @Test
    void editarPessoa() {
        int id = 3;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("Pessoa Teste 001 - editado");
        pessoa.setCpf("778.954.911-13");
        pessoa.setEmail("pessoaTesteEditado@example.com");
        pessoa.setIdEndereco(1);

        Pessoa pessoaExists = pessoaController.findByID(id);
        assertTrue(pessoaExists.getId() != 0);
        assertTrue(pessoaController.editar(pessoa));
    }

    @Test
    void findPessoaByID() {
        int id = 3;
        Pessoa pessoa = pessoaController.findByID(id);
        assertTrue(pessoa.getId() != 0);
    }

    @Test
    void deletarPessoa() {
        int id = 3;
        assertTrue(pessoaController.deletar(id));
    }
}
