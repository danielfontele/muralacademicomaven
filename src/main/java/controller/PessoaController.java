package controller;

import model.Pessoa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PessoaController {

    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Pessoa pessoa;

    public void cadastrarPessoa(){

        pessoa = new Pessoa();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        pessoa.setNome(in.next());

        Boolean valido = false;
        while(!valido){
            System.out.println("Digite o CPF (sem pontuações): ");
            String CPF = in.next();
            valido = validarCPF(CPF);
            if(valido) {
                pessoa.setCpf(CPF);
            }
        }

        System.out.println("Digite o email: ");
        pessoa.setEmail(in.next());

        pessoa.setId(id_generator.getAndIncrement());
        System.out.println("O ID da pessoa registrada é: "+pessoa.getId());

        pessoas.add(pessoa);

        in.close();
    }

    public Pessoa listarPessoas(long id){
        for(Pessoa pessoa : pessoas){
            if(pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public void editarPessoa(long id){
        int i = 0;
        for (Pessoa pessoa : pessoas){
            if(pessoa.getId() == id){
                Pessoa pessoaEditado = new Pessoa();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o nome: ");
                pessoaEditado.setNome(in.next());

                Boolean valido = false;
                while(!valido){
                    System.out.println("Digite o CPF (sem pontuações): ");
                    String CPF = in.next();
                    valido = validarCPF(CPF);
                    if (valido) {
                        pessoaEditado.setCpf(CPF);
                    }
                }

                System.out.println("Digite o email: ");
                pessoaEditado.setEmail(in.next());

                pessoaEditado.setId(id);

                pessoas.set(i, pessoa);

                in.close();
            }
            i++;
        }
    }

    public void deletarPessoa(long id){
        int i = 0;
        for (Pessoa pessoa : pessoas){
            if(pessoa.getId() == id){
                pessoas.remove(i);
            }
            i++;
        }
    }


    public static Boolean validarCPF(String CPF){
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

}