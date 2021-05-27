package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.PostagemController;
import model.Postagem;

public class TestePostagem {
    PostagemController postagemController = new PostagemController();
    List<Postagem> postagensTeste = postagemController.listar();

    @Test
    void listarPostagens() {
        List<Postagem> postagens = postagemController.listar();
        assertFalse(postagens.isEmpty());
        assertEquals(postagens.size(), postagensTeste.size());
        assertEquals(postagens.get(0).getTitulo(), postagensTeste.get(0).getTitulo());

        Postagem postagem = new Postagem();
        postagem.setTitulo("Bem-vindo");
        assertEquals(postagem.getTitulo(), postagemController.listar().get(0).getTitulo());
    }

    @Test
    void salvarPostagem() {
        Postagem postagem = new Postagem();
        postagem.setTitulo("Título Teste 001");
        postagem.setConteudo("Conteúdo Teste 001");
        postagem.setData(LocalDate.now());
        postagem.setIdPalestrante(1);

        assertTrue(postagemController.salvar(postagem));
    }

    @Test
    void editarPostagem() {
        int id = 3;

        Postagem postagem = new Postagem();
        postagem.setId(id);
        postagem.setTitulo("Título Teste 001 - editado");
        postagem.setConteudo("Conteúdo Teste 001 - editado");
        postagem.setData(LocalDate.now());
        postagem.setIdPalestrante(1);

        Postagem postagemExists = postagemController.findByID(id);
        assertTrue(postagemExists.getId() != 0);
        assertTrue(postagemController.editar(postagem));
    }

    @Test
    void findPostagemByID() {
        int id = 3;

        Postagem postagem = postagemController.findByID(id);
        assertTrue(postagem.getId() != 0);
    }

    @Test
    void deletarPostagem() {
        int id = 3;

        Postagem postagemExists = postagemController.findByID(id);
        assertTrue(postagemExists.getId() != 0);
        assertTrue(postagemController.deletar(id));
    }
}
