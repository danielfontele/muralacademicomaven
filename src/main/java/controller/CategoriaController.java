package controller;

import model.Categoria;
import model.dao.CategoriaDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriaController {

    // private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    // private Categoria categoria;
    private CategoriaDao categoriaDao;

    /*
     * //CRUD antigo public void cadastrarCategoria() {
     * 
     * categoria = new Categoria(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o nome: "); categoria.setNome(in.nextLine());
     * 
     * categoria.setId(id_generator.getAndIncrement());
     * System.out.println("O ID da categoria registrado é: " + categoria.getId());
     * 
     * categorias.add(categoria);
     * 
     * }
     * 
     * public Categoria listarCategorias(int id) { for (Categoria categoria :
     * categorias) { if (categoria.getId() == id) { return categoria; } } return
     * null; }
     * 
     * public void editarCategoria(int id) { int i = 0; for (Categoria categoria :
     * categorias) { if (categoria.getId() == id) { Categoria categoriaEditado = new
     * Categoria(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o nome: ");
     * categoriaEditado.setNome(in.nextLine());
     * 
     * categoriaEditado.setId(id);
     * 
     * categorias.set(i, categoriaEditado);
     * 
     * break; } i++; } }
     * 
     * public void deletarCategoria(int id) { int i = 0; for (Categoria categoria :
     * categorias) { if (categoria.getId() == id) { categorias.remove(i); } i++; } }
     * 
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        categoriaDao = new CategoriaDao();
        Categoria categoria = preencher();
        Boolean isSalvo;
        if (categoria.getIdPostagem() == 0) {
            isSalvo = categoriaDao.salvarSemPostagem(categoria);
        } else {
            isSalvo = categoriaDao.salvar(categoria);
        }
        return isSalvo;
    }

    public boolean salvar(Categoria categoria) {
        categoriaDao = new CategoriaDao();
        Boolean isSalvo;
        if (categoria.getIdPostagem() == 0) {
            isSalvo = categoriaDao.salvarSemPostagem(categoria);
        } else {
            isSalvo = categoriaDao.salvar(categoria);
        }
        return isSalvo;
    }

    public ArrayList<Categoria> listar() {
        categoriaDao = new CategoriaDao();
        ArrayList<Categoria> categorias = categoriaDao.listar();
        return categorias;
    }

    public boolean editar() {
        categoriaDao = new CategoriaDao();
        int id = informarId();
        Categoria categoria = preencher();
        categoria.setId(id);
        boolean isSalvo = categoriaDao.editar(categoria);
        return isSalvo;
    }

    public boolean editar(Categoria categoria) {
        categoriaDao = new CategoriaDao();
        int id = categoria.getId();
        categoria.setId(id);
        boolean isSalvo = categoriaDao.editar(categoria);
        return isSalvo;
    }

    public boolean deletar() {
        categoriaDao = new CategoriaDao();
        int id = informarId();
        boolean isSalvo = categoriaDao.deletar(id);
        return isSalvo;
    }

    public boolean deletar(int id) {
        categoriaDao = new CategoriaDao();
        boolean isSalvo = categoriaDao.deletar(id);
        return isSalvo;
    }

    public Categoria findByID() {
        categoriaDao = new CategoriaDao();
        int id = informarId();
        Categoria categoria = categoriaDao.findByID(id);
        return categoria;
    }

    public Categoria findByID(int id) {
        categoriaDao = new CategoriaDao();
        Categoria categoria = categoriaDao.findByID(id);
        return categoria;
    }

    // Metodos Extras ============================================================
    public Categoria preencher() {
        Categoria categoria = new Categoria();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        categoria.setNome(in.nextLine());

        System.out.println("Digite o Id da postagem registrado (0 para nenhum)");
        int idPostagem = in.nextInt();
        if (idPostagem != 0) {
            categoria.setIdPostagem(idPostagem);
        }

        return categoria;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public void print(Categoria categoria) {
        System.out.println("\nId: " + categoria.getId() + "\nNome: " + categoria.getNome());
    }

    public void printAll() {
        List<Categoria> categorias = listar();
        for (Categoria categoria : categorias) {
            print(categoria);
        }
    }
}
