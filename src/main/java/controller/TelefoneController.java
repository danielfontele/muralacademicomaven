package controller;

import model.Telefone;
import model.TelefoneTipo;
import model.dao.TelefoneDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelefoneController {

    // private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
    // private static AtomicInteger id_generator = new AtomicInteger(0);
    // private Telefone telefone;
    TelefoneDao telefoneDao;

    /*
     * //CRUD Antigo public void cadastrarTelefone() {
     * 
     * telefone = new Telefone(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o código de área: ");
     * telefone.setCodigoArea(in.nextLine());
     * 
     * System.out.println("Digite o DDD: "); telefone.setDDD(in.nextLine());
     * 
     * System.out.println("Digite o número do telefone: ");
     * telefone.setNumero(in.nextLine());
     * 
     * int tipoSelecionado = -1; while ((tipoSelecionado != 1) || (tipoSelecionado
     * != 2)) { System.out.println("Selecione:" + "\n1 - Fixo" + "\n2 - Celular");
     * tipoSelecionado = in.nextInt();
     * 
     * if (tipoSelecionado == 1) { telefone.setTipo(TelefoneTipo.Fixo); } else if
     * (tipoSelecionado == 2) { telefone.setTipo(TelefoneTipo.Celular); } else {
     * System.err.println("Tipo inválido! Tente novamente..."); } }
     * 
     * telefone.setId(id_generator.getAndIncrement());
     * System.out.println("O ID do telefone registrado é: "+telefone.getId());
     * 
     * telefones.add(telefone);
     * 
     * }
     * 
     * public Telefone listarTelefones(int id){ for(Telefone telefone : telefones) {
     * if(telefone.getId() == id) { return telefone; } } return null; }
     * 
     * public void editarTelefones(int id){ int index = 0; for(Telefone telefone :
     * telefones) { if(telefone.getId() == id) { Telefone telefoneEditado = new
     * Telefone(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o código de área: ");
     * telefoneEditado.setCodigoArea(in.nextLine());
     * 
     * System.out.println("Digite o DDD: "); telefoneEditado.setDDD(in.nextLine());
     * 
     * System.out.println("Digite o número do telefone: ");
     * telefoneEditado.setNumero(in.nextLine());
     * 
     * int tipoSelecionado = -1; while ((tipoSelecionado != 1) || (tipoSelecionado
     * != 2)) { System.out.println("Selecione:" + "\n1 - Fixo" + "\n2 - Celular");
     * tipoSelecionado = in.nextInt();
     * 
     * if (tipoSelecionado == 1) { telefoneEditado.setTipo(TelefoneTipo.Fixo); }
     * else if (tipoSelecionado == 2) {
     * telefoneEditado.setTipo(TelefoneTipo.Celular); } else {
     * System.err.println("Tipo inválido! Tente novamente..."); } }
     * 
     * telefoneEditado.setId(id);
     * 
     * telefones.set(index, telefone);
     * 
     * break; } index++; } }
     * 
     * public void deletarTelefones(int id){ int index = 0; for(Telefone telefone :
     * telefones) { if(telefone.getId() == id) { telefones.remove(index); break; }
     * index++; } }
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        telefoneDao = new TelefoneDao();
        Telefone telefone = preencher();
        boolean isSalvo;
        if (telefone.getIdPessoa() == 0) {
            isSalvo = telefoneDao.salvarSemPessoa(telefone);
        } else {
            isSalvo = telefoneDao.salvar(telefone);
        }
        return isSalvo;
    }

    public boolean salvar(Telefone telefone) {
        telefoneDao = new TelefoneDao();
        boolean isSalvo;
        if (telefone.getIdPessoa() == 0) {
            isSalvo = telefoneDao.salvarSemPessoa(telefone);
        } else {
            isSalvo = telefoneDao.salvar(telefone);
        }
        return isSalvo;
    }

    public ArrayList<Telefone> listar() {
        telefoneDao = new TelefoneDao();
        ArrayList<Telefone> telefones = telefoneDao.listar();
        return telefones;
    }

    public boolean editar() {
        telefoneDao = new TelefoneDao();
        int id = informarId();
        Telefone telefone = preencher();
        telefone.setId(id);
        boolean isSalvo = telefoneDao.editar(telefone);
        return isSalvo;
    }

    public boolean editar(Telefone telefone) {
        telefoneDao = new TelefoneDao();
        int id = telefone.getId();
        telefone.setId(id);
        boolean isSalvo = telefoneDao.editar(telefone);
        return isSalvo;
    }

    public boolean deletar() {
        telefoneDao = new TelefoneDao();
        int id = informarId();
        boolean isSalvo = telefoneDao.deletar(id);
        return isSalvo;
    }

    public boolean deletar(int id) {
        telefoneDao = new TelefoneDao();
        boolean isSalvo = telefoneDao.deletar(id);
        return isSalvo;
    }

    public Telefone findByID() {
        telefoneDao = new TelefoneDao();
        int id = informarId();
        Telefone telefone = telefoneDao.findByID(id);
        return telefone;
    }

    public Telefone findByID(int id) {
        telefoneDao = new TelefoneDao();
        Telefone telefone = telefoneDao.findByID(id);
        return telefone;
    }

    // Metodos Extras ============================================================
    public Telefone preencher() {
        Telefone telefone = new Telefone();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o código de área: ");
        telefone.setCodigoArea(in.nextLine());

        System.out.println("Digite o DDD: ");
        telefone.setDDD(in.nextLine());

        System.out.println("Digite o número do telefone: ");
        telefone.setNumero(in.nextLine());

        int tipoSelecionado = -1;
        while ((tipoSelecionado != 1) || (tipoSelecionado != 2)) {
            System.out.println("Selecione:" + "\n1 - Fixo" + "\n2 - Celular");
            tipoSelecionado = in.nextInt();

            if (tipoSelecionado == 1) {
                telefone.setTipo(TelefoneTipo.Fixo);
            } else if (tipoSelecionado == 2) {
                telefone.setTipo(TelefoneTipo.Celular);
            } else {
                System.err.println("Tipo inválido! Tente novamente...");
            }
        }

        System.out.println("Digite o Id da pessosa vinculada (0 para nenhum)");
        int idPessoa = in.nextInt();
        if (idPessoa != 0) {
            telefone.setIdPessoa(idPessoa);
        }

        return telefone;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public void print(Telefone telefone) {
        System.out.println("\nId: " + telefone.getId() + "\nCódigo de área: " + telefone.getCodigoArea() + "\nDDD: "
                + telefone.getDDD() + "\nNúmero: " + telefone.getNumero() + "\nTipo: " + telefone.getTipo());
    }

    public void printAll() {
        List<Telefone> telefones = listar();
        for (Telefone telefone : telefones) {
            print(telefone);
        }
    }

}
