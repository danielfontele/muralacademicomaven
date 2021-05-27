package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.PalestranteController;
import model.Palestrante;

public class TestePalestrante {
    PalestranteController palestranteController = new PalestranteController();
    List<Palestrante> palestrantesTeste = palestranteController.listar();

    @Test
    void listarPalestrantes() {
        List<Palestrante> palestrantes = palestranteController.listar();
        assertFalse(palestrantes.isEmpty());
        assertEquals(palestrantes.size(), palestrantesTeste.size());
        assertEquals(palestrantes.get(0).getUsuario(), palestrantesTeste.get(0).getUsuario());

        Palestrante palestrante = new Palestrante();
        palestrante.setUsuario("admin");
        assertEquals(palestrante.getUsuario(), palestranteController.listar().get(0).getUsuario());
    }

    @Test
    void salvarPalestrante() {
        Palestrante palestrante = new Palestrante();
        palestrante.setUsuario("Palestrante Teste 001");
        palestrante.setSenha("Palestrante Teste 001");
        palestrante.setIdPessoa(1);

        assertTrue(palestranteController.salvar(palestrante));
    }

    @Test
    void editarPalestrante() {
        int id = 3;

        Palestrante palestrante = new Palestrante();
        palestrante.setId(id);
        palestrante.setUsuario("Palestrante Teste 001 - editado");
        palestrante.setSenha("Palestrante Teste 001 - editado");
        palestrante.setIdPessoa(1);

        Palestrante palestranteExists = palestranteController.findByID(id);
        assertTrue(palestranteExists.getId() != 0);
        assertTrue(palestranteController.editar(palestrante));
    }

    @Test
    void findPalestranteByID() {
        int id = 3;

        Palestrante palestrante = palestranteController.findByID(id);
        assertTrue(palestrante.getId() != 0);
    }

    @Test
    void deletarPalestrante() {
        int id = 3;
        
        Palestrante palestranteExists = palestranteController.findByID(id);
        assertTrue(palestranteExists.getId() != 0);
        assertTrue(palestranteController.deletar(id));
    }
}
