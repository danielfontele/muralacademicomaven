package controller;

import model.Curso;
import model.Endereco;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EnderecoController {

    private Endereco endereco;
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();

    public void cadastrarEndereco(){
        endereco = new Endereco();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome da sua rua: ");
        endereco.setRua(in.nextLine());

        System.out.println("Digite o número: ");
        endereco.setNumero(in.nextLine());

        System.out.println("Digite o bairro: ");
        endereco.setBairro(in.nextLine());

        System.out.println("Digite o complemento: ");
        endereco.setComplemento(in.nextLine());

        System.out.println("Digite a cidade: ");
        endereco.setCidade(in.nextLine());

        System.out.println("Digite o estado: ");
        endereco.setEstado(in.nextLine());

        enderecos.add(endereco);

    }

    public Endereco listarEndereco(long id){
        for (Endereco endereco : enderecos) {
            if(endereco.getId() == id) {
                return endereco;
            }
        }
        return null;
    }

    public void editarEndereco(long id){
        int index = 0;
        for (Endereco endereco : enderecos) {
            if(endereco.getId() == id) {
                Endereco enderecoEditado = new Endereco();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o nome da sua rua: ");
                enderecoEditado.setRua(in.nextLine());

                System.out.println("Digite o número: ");
                enderecoEditado.setNumero(in.nextLine());

                System.out.println("Digite o bairro: ");
                enderecoEditado.setBairro(in.nextLine());

                System.out.println("Digite o complemento: ");
                enderecoEditado.setComplemento(in.nextLine());

                System.out.println("Digite a cidade: ");
                enderecoEditado.setCidade(in.nextLine());

                System.out.println("Digite o estado: ");
                enderecoEditado.setEstado(in.nextLine());

                enderecos.set(index, enderecoEditado);

            }
            index++;
        }
    }

    public void deletarEndereco(long id){
        int index = 0;
        for (Endereco endereco : enderecos) {
            if(endereco.getId() == id) {
                enderecos.remove(index);
            }
            index++;
        }
    }

    public void print(Endereco endereco){
        System.out.println("\nId: " + endereco.getId()+
                "\nRua: "+ endereco.getRua() +
                "\nNúmero: " + endereco.getNumero() +
                "\nComplemento: " + endereco.getComplemento() +
                "\nBairro: " + endereco.getBairro() +
                "\nCidade: " + endereco.getCidade() +
                "\nEstado: " + endereco.getEstado());
    }

    public void printAll(){
        for (Endereco endereco : enderecos) {
            print(endereco);
        }
    }

}
