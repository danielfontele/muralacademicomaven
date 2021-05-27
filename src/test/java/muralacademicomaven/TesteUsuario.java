package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.UsuarioController;
import model.Usuario;

public class TesteUsuario {
    UsuarioController usuarioController = new UsuarioController();
    List<Usuario> usuariosTeste = usuarioController.listar();

    @Test
    void listarUsuarios() {
        List<Usuario> usuarios = usuarioController.listar();
        assertFalse(usuarios.isEmpty());
        assertEquals(usuarios.size(), usuariosTeste.size());
        assertEquals(usuarios.get(0).getUsuario(), usuariosTeste.get(0).getUsuario());

        Usuario usuario = new Usuario();
        usuario.setUsuario("user");
        assertEquals(usuario.getUsuario(), usuarioController.listar().get(0).getUsuario());
    }

    @Test
    void salvarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario("Usuario Teste 001");
        usuario.setSenha("Usuario Teste 001");
        usuario.setIdPessoa(1);

        assertTrue(usuarioController.salvar(usuario));
    }

    @Test
    void editarUsuario() {
        int id = 3;

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setUsuario("Usuario Teste 001 - editado");
        usuario.setSenha("Usuario Teste 001 - editado");
        usuario.setIdPessoa(1);

        Usuario usuarioExists = usuarioController.findByID(id);
        assertTrue(usuarioExists.getId() != 0);
        assertTrue(usuarioController.editar(usuario));
    }

    @Test
    void findUsuarioByID() {
        int id = 3;

        Usuario usuario = usuarioController.findByID(id);
        assertTrue(usuario.getId() != 0);
    }

    @Test
    void deletarUsuario() {
        int id = 3;

        Usuario usuarioExists = usuarioController.findByID(id);
        assertTrue(usuarioExists.getId() != 0);
        assertTrue(usuarioController.deletar(id));
    }
}
