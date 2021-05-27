package controller;

import model.Palestrante;
import model.dao.PalestranteDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalestranteController {

    // private static AtomicInteger id_generator = new AtomicInteger(0);
    // private Palestrante palestrante;
    // private ArrayList<Palestrante> palestrantes = new ArrayList<Palestrante>();
    PalestranteDao palestranteDao;

    /*
     * //CRUD Antigo public void cadastrarPalestrante() {
     * 
     * palestrante = new Palestrante(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o usuário: ");
     * palestrante.setUsuario(in.nextLine());
     * 
     * System.out.println("Digite a senha: "); palestrante.setSenha(in.nextLine());
     * 
     * palestrante.setId(id_generator.getAndIncrement());
     * System.out.println("O ID da palestrante registrado é: " +
     * palestrante.getId());
     * 
     * palestrantes.add(palestrante);
     * 
     * }
     * 
     * public Palestrante listarPalestrantes(int id) { for (Palestrante palestrante
     * : palestrantes) { if (palestrante.getId() == id) { return palestrante; } }
     * return null; }
     * 
     * public void editarPalestrante(int id) { int i = 0; for (Palestrante
     * palestrante : palestrantes) { if (palestrante.getId() == id) { Palestrante
     * palestranteEditado = new Palestrante(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o usuário: ");
     * palestranteEditado.setUsuario(in.nextLine());
     * 
     * System.out.println("Digite a senha: ");
     * palestranteEditado.setSenha(in.nextLine());
     * 
     * palestranteEditado.setId(id);
     * 
     * palestrantes.set(i, palestranteEditado); } i++; } }
     * 
     * public void deletarPalestrante(int id) { int i = 0; for (Palestrante
     * palestrante : palestrantes) { if (palestrante.getId() == id) {
     * palestrantes.remove(i); } i++; } }
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        palestranteDao = new PalestranteDao();
        Palestrante palestrante = preencher();
        Boolean isSalvo;
        if (palestrante.getIdPessoa() == 0) {
            isSalvo = palestranteDao.salvarSemPessoa(palestrante);
        } else {
            isSalvo = palestranteDao.salvar(palestrante);
        }
        return isSalvo;
    }

    public boolean salvar(Palestrante palestrante) {
        palestranteDao = new PalestranteDao();
        Boolean isSalvo;
        if (palestrante.getIdPessoa() == 0) {
            isSalvo = palestranteDao.salvarSemPessoa(palestrante);
        } else {
            isSalvo = palestranteDao.salvar(palestrante);
        }
        return isSalvo;
    }

    public ArrayList<Palestrante> listar() {
        palestranteDao = new PalestranteDao();
        ArrayList<Palestrante> palestrantes = palestranteDao.listar();
        return palestrantes;
    }

    public boolean editar() {
        palestranteDao = new PalestranteDao();
        int id = informarId();
        Palestrante palestrante = preencher();
        palestrante.setId(id);
        boolean isSalvo = palestranteDao.editar(palestrante);
        return isSalvo;
    }

    public boolean editar(Palestrante palestrante) {
        palestranteDao = new PalestranteDao();
        int id = palestrante.getId();
        palestrante.setId(id);
        boolean isSalvo = palestranteDao.editar(palestrante);
        return isSalvo;
    }

    public boolean deletar() {
        palestranteDao = new PalestranteDao();
        int id = informarId();
        boolean isSalvo = palestranteDao.deletar(id);
        return isSalvo;
    }

    public boolean deletar(int id) {
        palestranteDao = new PalestranteDao();
        boolean isSalvo = palestranteDao.deletar(id);
        return isSalvo;
    }

    public Palestrante findByID() {
        palestranteDao = new PalestranteDao();
        int id = informarId();
        Palestrante palestrante = palestranteDao.findByID(id);
        return palestrante;
    }

    public Palestrante findByID(int id) {
        palestranteDao = new PalestranteDao();
        Palestrante palestrante = palestranteDao.findByID(id);
        return palestrante;
    }

    // Metodos Extras ============================================================
    public Palestrante preencher() {
        Palestrante palestrante = new Palestrante();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        palestrante.setUsuario(in.nextLine());

        System.out.println("Digite a senha: ");
        palestrante.setSenha(in.nextLine());

        System.out.println("Digite o Id da pessosa vinculada (0 para nenhum)");
        int idPessoa = in.nextInt();
        if (idPessoa != 0) {
            palestrante.setIdPessoa(idPessoa);
        }

        return palestrante;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public Boolean logar(String user, String password) {
        Boolean usuarioValido = false;
        Boolean senhaValida = false;
        List<Palestrante> palestrantes = listar();
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getUsuario().equals(user)) {
                usuarioValido = true;
            }
            if (palestrante.getSenha().equals(password)) {
                senhaValida = true;
            }
            if (usuarioValido && senhaValida) {
                return true;
            }
        }
        return false;
    }

    public void print(Palestrante palestrante) {
        System.out.println("\n !! Método criado afins de teste !! " + "\nId: " + palestrante.getId() + "\nUsuário: "
                + palestrante.getUsuario() + "\nSenha: " + palestrante.getSenha());
    }

    public void printAll() {
        List<Palestrante> palestrantes = listar();
        for (Palestrante palestrante : palestrantes) {
            print(palestrante);
        }
    }

}