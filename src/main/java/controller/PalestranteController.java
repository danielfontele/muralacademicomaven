package controller;

import model.Endereco;
import model.Palestrante;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PalestranteController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Palestrante palestrante;
    private ArrayList<Palestrante> palestrantes = new ArrayList<Palestrante>();

    public void cadastrarPalestrante() {

        palestrante = new Palestrante();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        palestrante.setUsuario(in.nextLine());

        System.out.println("Digite a senha: ");
        palestrante.setSenha(in.nextLine());

        palestrante.setId(id_generator.getAndIncrement());
        System.out.println("O ID da palestrante registrado é: " + palestrante.getId());

        palestrantes.add(palestrante);

    }

    public Palestrante listarPalestrantes(long id) {
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getId() == id) {
                return palestrante;
            }
        }
        return null;
    }

    public void editarPalestrante(long id) {
        int i = 0;
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getId() == id) {
                Palestrante palestranteEditado = new Palestrante();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o usuário: ");
                palestranteEditado.setUsuario(in.nextLine());

                System.out.println("Digite a senha: ");
                palestranteEditado.setSenha(in.nextLine());

                palestranteEditado.setId(id);

                palestrantes.set(i, palestranteEditado);
            }
            i++;
        }
    }

    public void deletarPalestrante(long id) {
        int i = 0;
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getId() == id) {
                palestrantes.remove(i);
            }
            i++;
        }
    }

    public Boolean logar(String user, String password) {
        Boolean usuarioValido = false;
        Boolean senhaValida = false;
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getUsuario().equals(user)) {
                usuarioValido = true;
            }
            if (palestrante.getSenha().equals(password)) {
                senhaValida = true;
            }
            if (usuarioValido && senhaValida) { return true; }
        }
        return false;
    }

    public void addPalestrante(Palestrante palestrante) {
        palestrantes.add(palestrante);
    }

    public void print(Palestrante palestrante){
        System.out.println("\n !! Método criado afins de teste !! " +
                "\nId: " + palestrante.getId()+
                "\nUsuário: "+ palestrante.getUsuario() +
                "\nSenha: " + palestrante.getSenha() );
    }

    public void printAll(){
        for (Palestrante palestrante : palestrantes) {
            print(palestrante);
        }
    }

}