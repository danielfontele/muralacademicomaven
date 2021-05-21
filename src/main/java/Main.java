import controller.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CategoriaController categoriaController = new CategoriaController();
        CursoController cursoController = new CursoController();
        EnderecoController enderecoController = new EnderecoController();
        PalestranteController palestranteController = new PalestranteController();
        PessoaController pessoaController = new PessoaController();
        PostagemController postagemController = new PostagemController();
        TelefoneController telefoneController = new TelefoneController();
        UsuarioController usuarioController = new UsuarioController();

        System.out.println("Usuário teste:      user");
        System.out.println("Senha do usuario:   user");

        System.out.println("\nPaletrante teste:      admin");
        System.out.println("Senha do palestrante:  admin\n");

        Scanner in2 = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        boolean run = true;
        int escolha[] = new int[5];
        Boolean principal = true;

        int id1;
        int id2;
        int id3;
        int id4;
        int id5;
        int id6;
        int id7;
        int id8;

        Boolean userLogado = false;
        Boolean adminLogado = false;

        Boolean cadastrado = false;

        while (principal) {
            while (!cadastrado) {
                System.out.println("Já é cadastrado?" + "\n1 - Sim" + "\n2 - Não");
                escolha[0] = in.nextInt();
                if (escolha[0] == 1) {
                    System.out.println("Digite o Usuario:");
                    String usuario = in.next();
                    System.out.println("Digite a Senha:");
                    String senha = in.next();
                    if (usuarioController.logar(usuario, senha)) { // Usuário
                        userLogado = true;
                        cadastrado = true;
                        adminLogado = false;
                    } else if (palestranteController.logar(usuario, senha)) { // Palestrante
                        adminLogado = true;
                        cadastrado = true;
                        userLogado = false;
                    } else {
                        System.err.println("Usuário e/ou Senha incorreto(s)");
                    }
                } else if (escolha[0] == 2) {
                    System.out.println("Deseja cadastrar um usuário?" + "\n1 - Sim" + "\n2 - Não");
                    escolha[4] = in.nextInt();
                    if (escolha[4] == 1) {
                        usuarioController.salvar();
                    } else if (escolha[4] == 2) {
                        System.out.println("#Função criada para testes -> Deseja cadastrar um palestrante?"
                                + "\n1 - Sim" + "\n2 - Não");
                        escolha[2] = in2.nextInt();
                        if (escolha[2] == 1) {
                            palestranteController.salvar();
                        } else if (escolha[2] == 2) {
                            System.out.println("Ok!");
                        } else {
                            System.out.println("Escolha inválida!");
                        }
                    } else {
                        System.err.println("Comando inválido!");
                    }
                }
            }
            while (run) {
                if (userLogado) { // Usuário
                    postagemController.printarPostagens();
                } else if (adminLogado) { // Palestrante
                    System.out.println("Selecione o módulo:" + "\n1 - Categoria" + "\n2 - Curso" + "\n3 - Endereço"
                            + "\n4 - Palestrante" + "\n5 - Pessoa" + "\n6 - Postagem" + "\n7 - Telefone"
                            + "\n8 - Usuario");
                    escolha[3] = in.nextInt();
                    switch (escolha[3]) {
                        case 1:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao1 = in.nextInt();
                            switch (operacao1) {
                                case 1:
                                    categoriaController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id1 = in.nextInt();
                                    if (id1 == -1) {
                                        categoriaController.printAll();
                                    } else {
                                        categoriaController.print(categoriaController.findByID(id1));
                                    }
                                    break;
                                case 3:
                                    categoriaController.editar();
                                    break;
                                case 4:
                                    categoriaController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 2:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao2 = in.nextInt();
                            switch (operacao2) {
                                case 1:
                                    cursoController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id2 = in.nextInt();
                                    if (id2 == -1) {
                                        cursoController.printAll();
                                    } else {
                                        cursoController.print(cursoController.findByID(id2));
                                    }
                                    break;
                                case 3:
                                    cursoController.editar();
                                    break;
                                case 4:
                                    cursoController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 3:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao3 = in.nextInt();
                            switch (operacao3) {
                                case 1:
                                    enderecoController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id3 = in.nextInt();
                                    if (id3 == -1) {
                                        enderecoController.printAll();
                                    } else {
                                        enderecoController.print(enderecoController.findByID(id3));
                                    }
                                    break;
                                case 3:
                                    enderecoController.editar();
                                    break;
                                case 4:
                                    enderecoController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 4:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao4 = in.nextInt();
                            switch (operacao4) {
                                case 1:
                                    palestranteController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id4 = in.nextInt();
                                    if (id4 == -1) {
                                        palestranteController.printAll();
                                    } else {
                                        palestranteController.print(palestranteController.findByID(id4));
                                    }
                                    break;
                                case 3:
                                    palestranteController.editar();
                                    break;
                                case 4:
                                    palestranteController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 5:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao5 = in.nextInt();
                            switch (operacao5) {
                                case 1:
                                    pessoaController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id5 = in.nextInt();
                                    if (id5 == -1) {
                                        pessoaController.printAll();
                                    } else {
                                        pessoaController.print(pessoaController.findByID(id5));
                                    }
                                    break;
                                case 3:
                                    pessoaController.editar();
                                    break;
                                case 4:
                                    pessoaController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 6:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao6 = in.nextInt();
                            switch (operacao6) {
                                case 1:
                                    postagemController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id6 = in.nextInt();
                                    if (id6 == -1) {
                                        postagemController.printAll();
                                    } else {
                                        postagemController.print(postagemController.findByID(id6));
                                    }
                                    break;
                                case 3:
                                    postagemController.editar();
                                    break;
                                case 4:
                                    postagemController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 7:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao7 = in.nextInt();
                            switch (operacao7) {
                                case 1:
                                    telefoneController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id7 = in.nextInt();
                                    if (id7 == -1) {
                                        telefoneController.printAll();
                                    } else {
                                        telefoneController.print(telefoneController.findByID(id7));
                                    }
                                    break;
                                case 3:
                                    telefoneController.editar();
                                    break;
                                case 4:
                                    telefoneController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 8:
                            System.out.println("Selecione a operação:" + "\n1 - Criar" + "\n2 - Procurar"
                                    + "\n3 - Editar" + "\n4 - Deletar");
                            int operacao8 = in.nextInt();
                            switch (operacao8) {
                                case 1:
                                    usuarioController.salvar();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id8 = in.nextInt();
                                    if (id8 == -1) {
                                        usuarioController.printAll();
                                    } else {
                                        usuarioController.print(usuarioController.findByID(id8));
                                    }
                                    break;
                                case 3:
                                    usuarioController.editar();
                                    break;
                                case 4:
                                    usuarioController.deletar();
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        default:
                            System.err.println("Erro! Módulo inválida...");
                    }
                } else {
                    System.err.println("Usuário e/ou Senha incorreto(s)");
                }
                System.out.println("Deseja encerrar a sessão?\n1 - Sim\n2 - Não");
                if (in.hasNextLine()) {
                    escolha[1] = in.nextInt();
                }
                if (escolha[1] == 1) {
                    System.out.println(",_.-*ª'*-._, Obrigado por utilizar o sistema ,_.-*'ª*-._,");
                    run = false;
                }
            }
            cadastrado = false;
            run = true;
        }

    }
}