import controller.*;
import model.Palestrante;
import model.Pessoa;
import model.Usuario;

import java.util.ArrayList;
import java.util.Iterator;
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


        ArrayList<Pessoa> pessoas = pessoaController.listarPessoas();
        for(Iterator iterator = pessoas.iterator(); iterator.hasNext();){
            Pessoa pessoa = (Pessoa) iterator.next();
            System.out.println("id: "+pessoa.getId());
            System.out.println("nome: "+pessoa.getNome());
            System.out.println("cpf: "+pessoa.getCpf());
            System.out.println("email: "+pessoa.getEmail());
        }

        //Setando contas testes
        System.out.println("Usuário teste:      user");
        System.out.println("Senha do usuario:   user");

        System.out.println("\nPaletrante teste:      admin");
        System.out.println("senha do palestrante:  admin\n");

        Usuario user = new Usuario();
        user.setUsuario("user");
        user.setSenha("user");
        usuarioController.addUsuario(user);

        Palestrante admin = new Palestrante();
        admin.setUsuario("admin");
        admin.setSenha("admin");
        palestranteController.addPalestrante(admin);

        Scanner in2 = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        boolean run = true;
        int escolha[] = new int[5];
        Boolean principal = true;

        int id12;
        int id13;
        int id14;
        int id22;
        int id23;
        int id24;
        int id32;
        int id33;
        int id34;
        int id42;
        int id43;
        int id44;
        int id52;
        int id53;
        int id54;
        int id62;
        int id63;
        int id64;
        int id72;
        int id73;
        int id74;
        int id82;
        int id83;
        int id84;

        Boolean userLogado = false;
        Boolean adminLogado = false;

        Boolean cadastrado = false;


        while (principal) {
            while (!cadastrado) {
                System.out.println("Já é cadastrado?" +
                        "\n1 - Sim" +
                        "\n2 - Não");
                escolha[0] = in.nextInt();
                if (escolha[0] == 1) {
                    System.out.println("Digite o Usuario:");
                    String usuario = in.next();
                    System.out.println("Digite a Senha:");
                    String senha = in.next();
                    if (usuarioController.logar(usuario, senha)) {        //Usuário
                        userLogado = true;
                        cadastrado = true;
                        adminLogado = false;
                    } else if (palestranteController.logar(usuario, senha)) {    //Palestrante
                        adminLogado = true;
                        cadastrado = true;
                        userLogado = false;
                    } else {
                        System.err.println("Usuário e/ou Senha incorreto(s)");
                    }
                } else if (escolha[0] == 2) {
                    System.out.println("Deseja cadastrar um usuário?" +
                            "\n1 - Sim" +
                            "\n2 - Não");
                    escolha[4] = in.nextInt();
                    if (escolha[4] == 1) {
                        usuarioController.cadastrarUsuario();
                    } else if (escolha[4] == 2) {
                        System.out.println("#Função criada para testes -> Deseja cadastrar um palestrante?" +
                                "\n1 - Sim" +
                                "\n2 - Não");
                        escolha[2] = in2.nextInt();
                        if (escolha[2] == 1) {
                            palestranteController.cadastrarPalestrante();
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
                if (userLogado) {        //Usuário
                    postagemController.printarPostagens();
                } else if (adminLogado) {    //Palestrante
                    System.out.println("Selecione o módulo:" +
                            "\n1 - Categoria" +
                            "\n2 - Curso" +
                            "\n3 - Endereço" +
                            "\n4 - Palestrante" +
                            "\n5 - Pessoa" +
                            "\n6 - Postagem" +
                            "\n7 - Telefone" +
                            "\n8 - Usuario");
                    escolha[3] = in.nextInt();
                    switch (escolha[3]) {
                        case 1:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao1 = in.nextInt();
                            switch (operacao1) {
                                case 1:
                                    categoriaController.cadastrarCategoria();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id12 = in.nextInt();
                                    if (id12 == -1) {
                                        categoriaController.printAll();
                                    } else {
                                        categoriaController.print(categoriaController.listarCategorias(id12));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id13 = in.nextInt();
                                    categoriaController.editarCategoria(id13);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id14 = in.nextInt();
                                    categoriaController.deletarCategoria(id14);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 2:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao2 = in.nextInt();
                            switch (operacao2) {
                                case 1:
                                    cursoController.cadastrarCurso();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id22 = in.nextInt();
                                    if (id22 == -1) {
                                        cursoController.printAll();
                                    } else {
                                        cursoController.print(cursoController.listarCursos(id22));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id23 = in.nextInt();
                                    cursoController.editarCurso(id23);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id24 = in.nextInt();
                                    cursoController.deletarCurso(id24);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 3:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao3 = in.nextInt();
                            switch (operacao3) {
                                case 1:
                                    enderecoController.cadastrarEndereco();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id32 = in.nextInt();
                                    if (id32 == -1) {
                                        enderecoController.printAll();
                                    } else {
                                        enderecoController.print(enderecoController.listarEndereco(id32));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id33 = in.nextInt();
                                    enderecoController.editarEndereco(id33);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id34 = in.nextInt();
                                    enderecoController.deletarEndereco(id34);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 4:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao4 = in.nextInt();
                            switch (operacao4) {
                                case 1:
                                    palestranteController.cadastrarPalestrante();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id42 = in.nextInt();
                                    if (id42 == -1) {
                                        palestranteController.printAll();
                                    } else {
                                        palestranteController.print(palestranteController.listarPalestrantes(id42));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id43 = in.nextInt();
                                    palestranteController.editarPalestrante(id43);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id44 = in.nextInt();
                                    palestranteController.deletarPalestrante(id44);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 5:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao5 = in.nextInt();
                            switch (operacao5) {
                                case 1:
                                    pessoaController.cadastrarPessoa();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id52 = in.nextInt();
                                    if (id52 == -1) {
                                        pessoaController.printAll();
                                    } else {
                                        pessoaController.print(pessoaController.listarPessoas(id52));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id53 = in.nextInt();
                                    pessoaController.editarPessoa(id53);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id54 = in.nextInt();
                                    pessoaController.deletarPessoa(id54);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 6:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao6 = in.nextInt();
                            switch (operacao6) {
                                case 1:
                                    postagemController.cadastrarPostagem();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id62 = in.nextInt();
                                    if (id62 == -1) {
                                        postagemController.printAll();
                                    } else {
                                        postagemController.print(postagemController.listarPostagens(id62));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id63 = in.nextInt();
                                    postagemController.editarPostagem(id63);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id64 = in.nextInt();
                                    postagemController.deletarPostagem(id64);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 7:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao7 = in.nextInt();
                            switch (operacao7) {
                                case 1:
                                    telefoneController.cadastrarTelefone();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id72 = in.nextInt();
                                    if (id72 == -1) {
                                        telefoneController.printAll();
                                    } else {
                                        telefoneController.print(telefoneController.listarTelefones(id72));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id73 = in.nextInt();
                                    telefoneController.editarTelefones(id73);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id74 = in.nextInt();
                                    telefoneController.deletarTelefones(id74);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        case 8:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao8 = in.nextInt();
                            switch (operacao8) {
                                case 1:
                                    usuarioController.cadastrarUsuario();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    id82 = in.nextInt();
                                    if (id82 == -1) {
                                        usuarioController.printAll();
                                    } else {
                                        usuarioController.print(usuarioController.listarUsuarios(id82));
                                    }
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id83 = in.nextInt();
                                    usuarioController.editarUsuario(id83);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    id84 = in.nextInt();
                                    usuarioController.deletarUsuario(id84);
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
        in.close();

    }
}