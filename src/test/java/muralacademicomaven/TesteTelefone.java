package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.TelefoneController;
import model.Telefone;
import model.TelefoneTipo;

public class TesteTelefone {
    TelefoneController telefoneController = new TelefoneController();
    List<Telefone> telefonesTeste = telefoneController.listar();

    @Test
    void listarTelefones() {
        List<Telefone> telefones = telefoneController.listar();
        assertFalse(telefones.isEmpty());
        assertEquals(telefones.size(), telefonesTeste.size());
        assertEquals(telefones.get(0).getNumero(), telefonesTeste.get(0).getNumero());

        Telefone telefone = new Telefone();
        telefone.setNumero("99999-9999");
        assertEquals(telefone.getNumero(), telefoneController.listar().get(0).getNumero());
    }

    @Test
    void salvarTelefone() {
        Telefone telefone = new Telefone();
        telefone.setNumero("1234-4321");
        telefone.setCodigoArea("+55");
        telefone.setDDD("62");
        telefone.setIdPessoa(1);
        telefone.setTipo(TelefoneTipo.Celular);

        assertTrue(telefoneController.salvar(telefone));
    }

    @Test
    void editarTelefone() {
        int id = 3;

        Telefone telefone = new Telefone();
        telefone.setNumero("99234-4321");
        telefone.setCodigoArea("+55");
        telefone.setDDD("62");
        telefone.setIdPessoa(1);
        telefone.setTipo(TelefoneTipo.Celular);
        
        Telefone telefoneExists = telefoneController.findByID(id);
        assertTrue(telefoneExists.getId() != 0);
        assertTrue(telefoneController.editar(telefone));
    }

    @Test
    void findTelefoneByID() {
        int id = 3;

        Telefone telefone = telefoneController.findByID(id);
        assertTrue(telefone.getId() != 0);
    }

    @Test
    void deletarTelefone() {
        int id = 3;

        Telefone telefoneExists = telefoneController.findByID(id);
        assertTrue(telefoneExists.getId() != 0);
        assertTrue(telefoneController.deletar(id));
    }
}
