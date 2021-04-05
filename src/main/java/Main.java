import controller.*;
import model.Palestrante;
import model.Usuario;

import java.util.ArrayList;
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

        Scanner in = new Scanner(System.in);
        boolean run = true;
        int ecadastrado = -1;
        int cadastrarP;
        int escolhaModulo;
        int cadastrarUser;

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


        while (run) {
            System.out.println("Já é cadastrado?" +
                    "\n1 - Sim" +
                    "\n2 - Não");
            ecadastrado = in.nextInt();

            if (ecadastrado == 1) {
                System.out.println("Digite o Usuario:");
                String usuario = in.next();

                System.out.println("Digite a Senha:");
                String senha = in.next();

                if (usuarioController.logar(usuario, senha)) {        //Usuário
                    postagemController.printarPostagens();
                } else if (palestranteController.logar(usuario, senha)) {    //Palestrante
                    System.out.println("Selecione o módulo:" +
                            "\n1 - Categoria" +
                            "\n2 - Curso" +
                            "\n3 - Endereço" +
                            "\n4 - Palestrante" +
                            "\n5 - Pessoa" +
                            "\n6 - Postagem" +
                            "\n7 - Telefone" +
                            "\n8 - Usuario");
                    escolhaModulo = in.nextInt();

                    switch (escolhaModulo) {
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
                                    categoriaController.listarCategorias(id12);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id13 = in.nextInt();
                                    categoriaController.editarCategoria(id13);
                                    break;
                                case 4:
                                    System.out.println("Qual id? (-1 para todos)");
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
                                    cursoController.listarCursos(id22);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    id23 = in.nextInt();
                                    cursoController.editarCurso(id23);
                                    break;
                                case 4:
                                    System.out.println("Qual id? (-1 para todos)");
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
                                    enderecoController.listarEndereco(id32);
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
                                    palestranteController.listarPalestrantes(id42);
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
                                    pessoaController.listarPessoas(id52);
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
                                    postagemController.listarPostagens(id62);
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
                                    telefoneController.listarTelefones(id72);
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
                                    usuarioController.listarUsuarios(id82);
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
            } else if (ecadastrado == 2) {
                System.out.println("Deseja cadastrar um usuário?" +
                        "\n1 - Sim" +
                        "\n2 - Não");
                cadastrarUser = in.nextInt();
                if (cadastrarUser == 1) {
                    usuarioController.cadastrarUsuario();
                } else if (cadastrarUser == 2) {
                    System.out.println("\\Função Criada para testes// Deseja cadastrar um palestrante?" +
                            "\n1 - Sim" +
                            "\n2 - Não");
                    cadastrarP = in.nextInt();

                    if (cadastrarP == 1) {
                        palestranteController.cadastrarPalestrante();
                    } else {
                        System.out.println("Escolha inválida!");
                    }
                } else {
                    System.err.println("Comando inválido!");
                }
            }
            System.out.println(",_.-*ª'*-._, Obrigado por utilizar o sistema ,_.-*'ª*-._,");
        }
    }
}