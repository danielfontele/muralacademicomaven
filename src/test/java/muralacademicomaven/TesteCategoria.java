package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.CategoriaController;
import model.Categoria;

public class TesteCategoria {
    CategoriaController categoriaController = new CategoriaController();
    List<Categoria> categoriasTeste = categoriaController.listar();

    @Test
    void listarCategoria() {
        List<Categoria> categorias = categoriaController.listar();
        assertFalse(categorias.isEmpty());
        assertEquals(categorias.size(), categoriasTeste.size());
        assertEquals(categorias.get(0).getNome(), categoriasTeste.get(0).getNome());

        Categoria categoria = new Categoria();
        categoria.setNome("Geral");
        assertEquals(categoria.getNome(), categoriaController.listar().get(0).getNome());
    }

    @Test
    void salvarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome("Categoria Teste 001");
        categoria.setIdPostagem(1);

        assertTrue(categoriaController.salvar(categoria));
    }

    @Test
    void editarCategoria() {
        int id = 3;

        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNome("Categoria Teste 001 - editado");
        categoria.setIdPostagem(1);

        Categoria categoriaExists = categoriaController.findByID(id);
        assertTrue(categoriaExists.getId() != 0);
        assertTrue(categoriaController.editar(categoria));
    }

    @Test
    void findCategoriaByID() {
        int id = 3;

        Categoria categoria = categoriaController.findByID(id);
        assertTrue(categoria.getId() != 0);
    }

    @Test
    void deletarCategoria() {
        int id = 3;

        Categoria categoriaExists = categoriaController.findByID(id);
        assertTrue(categoriaExists.getId() != 0);
        assertTrue(categoriaController.deletar(id));
    }
}
