package controller;

import model.Curso;
import model.dao.CursoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CursoController {

    // private ArrayList<Curso> cursos = new ArrayList<Curso>();
    // private static AtomicInteger id_generator = new AtomicInteger(0);
    // private Curso curso;
    CursoDao cursoDao;

    /*
     * //CRUD Antigo public void cadastrarCurso(){
     * 
     * curso = new Curso(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o nome: "); curso.setNome(in.nextLine());
     * 
     * curso.setId(id_generator.getAndIncrement());
     * System.out.println("O ID da curso registrado é: "+curso.getId());
     * 
     * cursos.add(curso);
     * 
     * }
     * 
     * public Curso listarCursos(int id){ for(Curso curso : cursos){
     * if(curso.getId() == id) { return curso; } } return null; }
     * 
     * public void editarCurso(int id){ int index = 0; for(Curso curso : cursos) {
     * if(curso.getId() == id){ Curso cursoEditado = new Curso(); Scanner in = new
     * Scanner(System.in);
     * 
     * System.out.println("Digite o nome: "); cursoEditado.setNome(in.nextLine());
     * 
     * cursoEditado.setId(id);
     * 
     * cursos.set(index, cursoEditado);
     * 
     * } index++; } }
     * 
     * public void deletarCurso(int id){ int index = 0; for(Curso curso : cursos) {
     * if(curso.getId() == id){ cursos.remove(index); } index++; } }
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        cursoDao = new CursoDao();
        Curso curso = preencher();
        Boolean isSalvo;
        if (curso.getIdPostagem() == 0) {
            isSalvo = cursoDao.salvarSemPostagem(curso);
        } else {
            isSalvo = cursoDao.salvar(curso);
        }
        return isSalvo;
    }

    public boolean salvar(Curso curso) {
        cursoDao = new CursoDao();
        Boolean isSalvo;
        if (curso.getIdPostagem() == 0) {
            isSalvo = cursoDao.salvarSemPostagem(curso);
        } else {
            isSalvo = cursoDao.salvar(curso);
        }
        return isSalvo;
    }

    public ArrayList<Curso> listar() {
        cursoDao = new CursoDao();
        ArrayList<Curso> cursos = cursoDao.listar();
        return cursos;
    }

    public boolean editar() {
        cursoDao = new CursoDao();
        int id = informarId();
        Curso curso = preencher();
        curso.setId(id);
        boolean isSalvo = cursoDao.editar(curso);
        return isSalvo;
    }

    public boolean editar(Curso curso) {
        cursoDao = new CursoDao();
        int id = curso.getId();
        curso.setId(id);
        boolean isSalvo = cursoDao.editar(curso);
        return isSalvo;
    }

    public boolean deletar() {
        cursoDao = new CursoDao();
        int id = informarId();
        boolean isSalvo = cursoDao.deletar(id);
        return isSalvo;
    }

    public boolean deletar(int id) {
        cursoDao = new CursoDao();
        boolean isSalvo = cursoDao.deletar(id);
        return isSalvo;
    }

    public Curso findByID() {
        cursoDao = new CursoDao();
        int id = informarId();
        Curso curso = cursoDao.findByID(id);
        return curso;
    }

    public Curso findByID(int id) {
        cursoDao = new CursoDao();
        Curso curso = cursoDao.findByID(id);
        return curso;
    }

    // Metodos Extras ============================================================
    public Curso preencher() {
        Curso curso = new Curso();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        curso.setNome(in.nextLine());

        System.out.println("Digite o Id da postagem registrado (0 para nenhum)");
        int idPostagem = in.nextInt();
        if (idPostagem != 0) {
            curso.setIdPostagem(idPostagem);
        }
        return curso;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public void print(Curso curso) {
        System.out.println("\nId: " + curso.getId() + "\nNome: " + curso.getNome());
    }

    public void printAll() {
        List<Curso> cursos = listar();
        for (Curso curso : cursos) {
            print(curso);
        }
    }
}
