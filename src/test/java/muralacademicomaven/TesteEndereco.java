package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.EnderecoController;
import model.Endereco;

public class TesteEndereco {
    EnderecoController enderecoController = new EnderecoController();
    List<Endereco> enderecosTeste = enderecoController.listar();

    @Test
    void listarEnderecos() {
        List<Endereco> enderecos = enderecoController.listar();
        assertFalse(enderecos.isEmpty());
        assertEquals(enderecos.size(), enderecosTeste.size());
        assertEquals(enderecos.get(0).getRua(), enderecosTeste.get(0).getRua());

        Endereco endereco = new Endereco();
        endereco.setRua("Rua Primeiro de Maio");
        assertEquals(endereco.getRua(), enderecoController.listar().get(0).getRua());
    }

    @Test
    void salvarEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua("Endereco Teste 001");
        endereco.setBairro("Bairro Teste 001");
        endereco.setCidade("Cidade Teste 001");
        endereco.setComplemento("Complemento Teste 001");
        endereco.setEstado("Estado Teste 001");
        endereco.setNumero("001");

        assertTrue(enderecoController.salvar(endereco));
    }

    @Test
    void editarEndereco() {
        int id = 3;

        Endereco endereco = new Endereco();
        endereco.setId(id);
        endereco.setRua("Endereco Teste Editado 001");
        endereco.setBairro("Bairro Teste Editado 001");
        endereco.setCidade("Cidade Teste Editado 001");
        endereco.setComplemento("Complemento Teste Editado 001");
        endereco.setEstado("Estado Teste Editado 001");
        endereco.setNumero("001");

        Endereco enderecoExists = enderecoController.findByID(id);
        assertTrue(enderecoExists.getId() != 0);
        assertTrue(enderecoController.editar(endereco));
    }

    @Test
    void findEnderecoByID() {
        int id = 3;

        Endereco endereco = enderecoController.findByID(id);
        assertTrue(endereco.getId() != 0);
    }

    @Test
    void deletarEndereco() {
        int id = 3;
        
        Endereco enderecoExists = enderecoController.findByID(id);
        assertTrue(enderecoExists.getId() != 0);
        assertTrue(enderecoController.deletar(id));
    }
}
