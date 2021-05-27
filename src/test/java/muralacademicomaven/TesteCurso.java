package muralacademicomaven;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.CursoController;
import model.Curso;

public class TesteCurso {
    CursoController cursoController = new CursoController();
    List<Curso> cursosTeste = cursoController.listar();

    @Test
    void listarCursos() {
        List<Curso> cursos = cursoController.listar();
        assertFalse(cursos.isEmpty());
        assertEquals(cursos.size(), cursosTeste.size());
        assertEquals(cursos.get(0).getNome(), cursosTeste.get(0).getNome());

        Curso curso = new Curso();
        curso.setNome("Administração");
        assertEquals(curso.getNome(), cursoController.listar().get(0).getNome());
    }

    @Test
    void salvarCurso() {
        Curso curso = new Curso();
        curso.setNome("Curso Teste 001");
        curso.setIdPostagem(1);

        assertTrue(cursoController.salvar(curso));
    }

    @Test
    void editarCurso() {
        int id = 3;

        Curso curso = new Curso();
        curso.setId(id);
        curso.setNome("Curso Teste 001 - editado");
        curso.setIdPostagem(1);

        Curso cursoExists = cursoController.findByID(id);
        assertTrue(cursoExists.getId() != 0);
        assertTrue(cursoController.editar(curso));
    }

    @Test
    void findCursoByID() {
        int id = 3;

        Curso curso = cursoController.findByID(id);
        assertTrue(curso.getId() != 0);
    }

    @Test
    void deletarCurso() {
        int id = 3;
        
        Curso cursoExists = cursoController.findByID(id);
        assertTrue(cursoExists.getId() != 0);
        assertTrue(cursoController.deletar(id));
    }
}
