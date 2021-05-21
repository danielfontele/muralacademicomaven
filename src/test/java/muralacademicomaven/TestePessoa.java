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
    void listar() {
        List<Pessoa> pessoas = pessoaController.listar();
        assertEquals(pessoas.get(0).getCpf(), pessoasTeste.get(0).getCpf());
    }

    @Test
    void listar2() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        List<Pessoa> pessoas = pessoaController.listar();
        assertTrue(!pessoas.isEmpty());

        pessoa.setCpf("11111111111");
        assertFalse(pessoa.getCpf().equals(pessoaController.listar().get(0).getCpf()));
    }

    @Test
    void salvarCpfErrado() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa Teste 1");
        pessoa.setCpf("666.666.666-66");
        pessoa.setEmail("pessoaTeste@pessoaTeste.com");
        pessoa.setIdEndereco(1);

        assertTrue(pessoaController.salvar());
    }
}
