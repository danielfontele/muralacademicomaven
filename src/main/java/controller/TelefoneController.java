package controller;

import model.Postagem;
import model.Telefone;
import model.TelefoneTipo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TelefoneController {

    private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Telefone telefone;

    public void cadastrarTelefone() {

        telefone = new Telefone();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o código de área: ");
        telefone.setCodigoArea(in.nextLine());

        System.out.println("Digite o DDD: ");
        telefone.setDDD(in.nextLine());

        System.out.println("Digite o número do telefone: ");
        telefone.setNumero(in.nextLine());

        int tipoSelecionado = -1;
        while ((tipoSelecionado != 1) || (tipoSelecionado != 2)) {
            System.out.println("Selecione:" +
                             "\n1 - Fixo" +
                             "\n2 - Celular");
            tipoSelecionado = in.nextInt();

            if (tipoSelecionado == 1) {
                telefone.setTipo(TelefoneTipo.Fixo);
            }
            else if (tipoSelecionado == 2) {
                telefone.setTipo(TelefoneTipo.Celular);
            }
            else {
                System.err.println("Tipo inválido! Tente novamente...");
            }
        }

        telefone.setId(id_generator.getAndIncrement());
        System.out.println("O ID do telefone registrado é: "+telefone.getId());

        telefones.add(telefone);

    }

    public Telefone listarTelefones(long id){
        for(Telefone telefone : telefones) {
            if(telefone.getId() == id) {
                return telefone;
            }
        }
        return null;
    }

    public void editarTelefones(long id){
        int index = 0;
        for(Telefone telefone : telefones) {
            if(telefone.getId() == id) {
                Telefone telefoneEditado = new Telefone();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o código de área: ");
                telefoneEditado.setCodigoArea(in.nextLine());

                System.out.println("Digite o DDD: ");
                telefoneEditado.setDDD(in.nextLine());

                System.out.println("Digite o número do telefone: ");
                telefoneEditado.setNumero(in.nextLine());

                int tipoSelecionado = -1;
                while ((tipoSelecionado != 1) || (tipoSelecionado != 2)) {
                    System.out.println("Selecione:" +
                            "\n1 - Fixo" +
                            "\n2 - Celular");
                    tipoSelecionado = in.nextInt();

                    if (tipoSelecionado == 1) {
                        telefoneEditado.setTipo(TelefoneTipo.Fixo);
                    }
                    else if (tipoSelecionado == 2) {
                        telefoneEditado.setTipo(TelefoneTipo.Celular);
                    }
                    else {
                        System.err.println("Tipo inválido! Tente novamente...");
                    }
                }

                telefoneEditado.setId(id);

                telefones.set(index, telefone);

                break;
            }
            index++;
        }
    }

    public void deletarTelefones(long id){
        int index = 0;
        for(Telefone telefone : telefones) {
            if(telefone.getId() == id) {
                telefones.remove(index);
                break;
            }
            index++;
        }
    }

    public void print(Telefone telefone){
        System.out.println("\nId: " + telefone.getId()+
                "\nCódigo de área: "+ telefone.getCodigoArea()+
                "\nDDD: " + telefone.getDDD() +
                "\nNúmero: " + telefone.getNumero() +
                "\nTipo: " + telefone.getTipo());
    }

    public void printAll(){
        for (Telefone telefone : telefones) {
            print(telefone);
        }
    }

}

