package controller;

import model.Pessoa;
import model.dao.PessoaDao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PessoaController {

    // private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    // private Pessoa pessoa;
    private PessoaDao pessoaDao;

    /*
     * //Crud Antigo
     * 
     * public void cadastrarPessoa() {
     * 
     * pessoa = new Pessoa(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o nome: "); pessoa.setNome(in.nextLine());
     * 
     * Boolean valido = false; while (!valido) {
     * System.out.println("Digite o CPF (sem pontuações): "); String CPF =
     * in.nextLine(); valido = validarCPF(CPF); if (valido) { pessoa.setCpf(CPF); }
     * }
     * 
     * System.out.println("Digite o email: "); pessoa.setEmail(in.nextLine());
     * 
     * pessoas.add(pessoa);
     * 
     * }
     * 
     * public Pessoa listarPessoas(int id) { for (Pessoa pessoa : pessoas) { if
     * (pessoa.getId() == id) { return pessoa; } } return null; }
     * 
     * public void editarPessoa(int id) { int i = 0; for (Pessoa pessoa : pessoas) {
     * if (pessoa.getId() == id) { Pessoa pessoaEditado = new Pessoa(); Scanner in =
     * new Scanner(System.in);
     * 
     * System.out.println("Digite o nome: "); pessoaEditado.setNome(in.nextLine());
     * 
     * Boolean valido = false; while (!valido) {
     * System.out.println("Digite o CPF (sem pontuações): "); String CPF =
     * in.nextLine(); valido = validarCPF(CPF); if (valido) {
     * pessoaEditado.setCpf(CPF); } }
     * 
     * System.out.println("Digite o email: ");
     * pessoaEditado.setEmail(in.nextLine());
     * 
     * pessoaEditado.setId(id);
     * 
     * pessoas.set(i, pessoa); } i++; } }
     * 
     * public void deletarPessoa(int id) { int i = 0; for (Pessoa pessoa : pessoas)
     * { if (pessoa.getId() == id) { pessoas.remove(i); } i++; } }
     * 
     */

    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        pessoaDao = new PessoaDao();
        Pessoa pessoa = preencher();
        Boolean isSalvo;
        if (pessoa.getIdEndereco() == 0) {
            isSalvo = pessoaDao.salvarSemEndereco(pessoa);
        } else {
            isSalvo = pessoaDao.salvar(pessoa);
        }
        return isSalvo;
    }

    public ArrayList<Pessoa> listar() {
        pessoaDao = new PessoaDao();
        ArrayList<Pessoa> pessoas = pessoaDao.listar();
        return pessoas;
    }

    public boolean editar() {
        pessoaDao = new PessoaDao();
        int id = informarId();
        Pessoa pessoa = preencher();
        pessoa.setId(id);
        boolean isSalvo = pessoaDao.editar(pessoa);
        return isSalvo;
    }

    public boolean deletar() {
        pessoaDao = new PessoaDao();
        int id = informarId();
        boolean isSalvo = pessoaDao.deletar(id);
        return isSalvo;
    }

    public Pessoa findByID() {
        pessoaDao = new PessoaDao();
        int id = informarId();
        Pessoa pessoa = pessoaDao.findByID(id);
        return pessoa;
    }

    public Pessoa findByID(int id) {
        pessoaDao = new PessoaDao();
        Pessoa pessoa = pessoaDao.findByID(id);
        return pessoa;
    }

    public boolean salvarComTelefone() {
        pessoaDao = new PessoaDao();
        Pessoa pessoa = preencher();
        boolean isSalvo = pessoaDao.salvarComTelefones(pessoa);
        return isSalvo;
    }

    // Metodos Extras ===========================================================
    public Pessoa preencher() {
        Pessoa pessoa = new Pessoa();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        pessoa.setNome(in.nextLine());

        Boolean isCpfValido = false;
        while (!isCpfValido) {
            System.out.println("Digite o CPF (sem pontuações): ");
            String CPF = in.nextLine();
            isCpfValido = validarCPF(CPF);
            if (isCpfValido) {
                pessoa.setCpf(CPF);
            }
        }

        System.out.println("Digite o email: ");
        pessoa.setEmail(in.nextLine());

        System.out.println("Digite o Id do endereço registrado (0 para nenhum)");
        int idEndereco = in.nextInt();
        if (idEndereco != 0) {
            pessoa.setIdEndereco(idEndereco);
        }

        return pessoa;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public static Boolean validarCPF(String CPF) {

        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public void print(Pessoa pessoa) {
        System.out.println("\nId: " + pessoa.getId() + "\nNome: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf()
                + "\nEmail: " + pessoa.getEmail() + "\nId do Endereço: " + pessoa.getIdEndereco());
    }

    public void printAll() {
        List<Pessoa> pessoas = listar();
        for (Pessoa pessoa : pessoas) {
            print(pessoa);
        }
    }

}
