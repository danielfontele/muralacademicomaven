package controller;

import model.Endereco;
import model.dao.EnderecoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnderecoController {

    // private Endereco endereco;
    // private static AtomicInteger id_generator = new AtomicInteger(0);
    // private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    EnderecoDao enderecoDao;

    /*
     * //CRUD Antigo public void cadastrarEndereco(){ endereco = new Endereco();
     * Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o nome da sua rua: ");
     * endereco.setRua(in.nextLine());
     * 
     * System.out.println("Digite o número: "); endereco.setNumero(in.nextLine());
     * 
     * System.out.println("Digite o bairro: "); endereco.setBairro(in.nextLine());
     * 
     * System.out.println("Digite o complemento: ");
     * endereco.setComplemento(in.nextLine());
     * 
     * System.out.println("Digite a cidade: "); endereco.setCidade(in.nextLine());
     * 
     * System.out.println("Digite o estado: "); endereco.setEstado(in.nextLine());
     * 
     * enderecos.add(endereco);
     * 
     * }
     * 
     * public Endereco listarEndereco(int id){ for (Endereco endereco : enderecos) {
     * if(endereco.getId() == id) { return endereco; } } return null; }
     * 
     * public void editarEndereco(int id){ int index = 0; for (Endereco endereco :
     * enderecos) { if(endereco.getId() == id) { Endereco enderecoEditado = new
     * Endereco(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o nome da sua rua: ");
     * enderecoEditado.setRua(in.nextLine());
     * 
     * System.out.println("Digite o número: ");
     * enderecoEditado.setNumero(in.nextLine());
     * 
     * System.out.println("Digite o bairro: ");
     * enderecoEditado.setBairro(in.nextLine());
     * 
     * System.out.println("Digite o complemento: ");
     * enderecoEditado.setComplemento(in.nextLine());
     * 
     * System.out.println("Digite a cidade: ");
     * enderecoEditado.setCidade(in.nextLine());
     * 
     * System.out.println("Digite o estado: ");
     * enderecoEditado.setEstado(in.nextLine());
     * 
     * enderecos.set(index, enderecoEditado);
     * 
     * } index++; } }
     * 
     * public void deletarEndereco(int id){ int index = 0; for (Endereco endereco :
     * enderecos) { if(endereco.getId() == id) { enderecos.remove(index); } index++;
     * } }
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        enderecoDao = new EnderecoDao();
        Endereco endereco = preencher();
        boolean isSalvo = enderecoDao.salvar(endereco);
        return isSalvo;
    }

    public boolean salvar(Endereco endereco) {
        enderecoDao = new EnderecoDao();
        boolean isSalvo = enderecoDao.salvar(endereco);
        return isSalvo;
    }

    public ArrayList<Endereco> listar() {
        enderecoDao = new EnderecoDao();
        ArrayList<Endereco> enderecos = enderecoDao.listar();
        return enderecos;
    }

    public boolean editar() {
        enderecoDao = new EnderecoDao();
        int id = informarId();
        Endereco endereco = preencher();
        endereco.setId(id);
        boolean isSalvo = enderecoDao.editar(endereco);
        return isSalvo;
    }

    public boolean editar(Endereco endereco) {
        enderecoDao = new EnderecoDao();
        int id = endereco.getId();
        endereco.setId(id);
        boolean isSalvo = enderecoDao.editar(endereco);
        return isSalvo;
    }

    public boolean deletar() {
        enderecoDao = new EnderecoDao();
        int id = informarId();
        boolean isSalvo = enderecoDao.deletar(id);
        return isSalvo;
    }

    public boolean deletar(int id) {
        enderecoDao = new EnderecoDao();
        boolean isSalvo = enderecoDao.deletar(id);
        return isSalvo;
    }

    public Endereco findByID() {
        enderecoDao = new EnderecoDao();
        int id = informarId();
        Endereco endereco = enderecoDao.findByID(id);
        return endereco;
    }

    public Endereco findByID(int id) {
        enderecoDao = new EnderecoDao();
        Endereco endereco = enderecoDao.findByID(id);
        return endereco;
    }

    // Metodos Extras ============================================================
    public Endereco preencher() {
        Endereco endereco = new Endereco();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite a rua: ");
        endereco.setRua(in.nextLine());

        System.out.println("Digite o numero: ");
        endereco.setRua(in.nextLine());

        System.out.println("Digite o complemento: ");
        endereco.setComplemento(in.nextLine());

        System.out.println("Digite o bairro: ");
        endereco.setBairro(in.nextLine());

        System.out.println("Digite a cidade: ");
        endereco.setCidade(in.nextLine());

        System.out.println("Digite o estado: ");
        endereco.setEstado(in.nextLine());

        return endereco;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public void print(Endereco endereco) {
        System.out.println("\nId: " + endereco.getId() + "\nRua: " + endereco.getRua() + "\nNúmero: "
                + endereco.getNumero() + "\nComplemento: " + endereco.getComplemento() + "\nBairro: "
                + endereco.getBairro() + "\nCidade: " + endereco.getCidade() + "\nEstado: " + endereco.getEstado());
    }

    public void printAll() {
        List<Endereco> enderecos = listar();
        for (Endereco endereco : enderecos) {
            print(endereco);
        }
    }
}
