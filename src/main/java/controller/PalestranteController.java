package controller;

import model.Palestrante;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PalestranteController {

    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Palestrante palestrante;
    private ArrayList<Palestrante> palestrantes = new ArrayList<Palestrante>();

    public void cadastrarPalestrante(){

        palestrante = new Palestrante();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        palestrante.setUsuario(in.next());

        System.out.println("Digite a senha: ");
        palestrante.setSenha(in.next());

        palestrante.setId(id_generator.getAndIncrement());
        System.out.println("O ID da palestrante registrado é: "+palestrante.getId());

        palestrantes.add(palestrante);

        in.close();
    }

    public Palestrante listarPalestrantes(long id){
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getId() == id) {
                return palestrante;
            }
        }
        return null;
    }

    public void editarPalestrante(long id){
        int i = 0;
        for (Palestrante palestrante : palestrantes) {
            if (palestrante.getId() == id) {
                Palestrante palestranteEditado = new Palestrante();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o usuário: ");
                palestranteEditado.setUsuario(in.next());

                System.out.println("Digite a senha: ");
                palestranteEditado.setSenha(in.next());

                palestranteEditado.setId(id);

                palestrantes.set(i, palestranteEditado);
            }
            i++;
        }
    }

    public void deletarPalestrante(long id){
        int i = 0;
        for(Palestrante palestrante : palestrantes) {
            if (palestrante.getId() == id) {
                palestrantes.remove(i);
            }
            i++;
        }
    }
}
