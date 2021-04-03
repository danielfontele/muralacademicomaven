import controller.*;
import model.Palestrante;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

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

        System.out.println("\nPaletrante teste:     admin");
        System.out.println("senha do palestrante:   admin\n");

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Palestrante> palestrantes = new ArrayList<Palestrante>();

        Usuario user = new Usuario();
        user.setUsuario("user");
        user.setSenha("user");

        Palestrante admin = new Palestrante();
        admin.setUsuario("admin");
        admin.setSenha("admin");


        Scanner in = new Scanner(System.in);
        boolean run = true;

        while (run){
            int ecadastrado = -1;
            System.out.println("Já é cadastrado?" +
                    "\n1 - Sim" +
                    "\n2 - Não");
            ecadastrado = in.nextInt();

            if(ecadastrado == 1) {
                System.out.println("Digite o Usuario:");
                String usuarioLogado = in.next();
                Boolean usuarioValido = false;

                System.out.println("Digite a Senha:");
                String senhaLogado = in.next();
                Boolean senhaValido = false;

                Boolean isPalestrante = false;

                for (Usuario usuario : usuarios ){
                    if (usuario.getUsuario().equals(usuarioLogado)){
                        usuarioValido = true;
                    }
                    if (usuario.getSenha().equals(senhaLogado)) {
                        senhaValido = true;
                    }
                    if(usuarioValido && senhaValido) { isPalestrante = false; }
                }
                for (Palestrante palestrante : palestrantes ){
                    if (palestrante.getUsuario().equals(usuarioLogado)){
                        usuarioValido = true;
                    }
                    if (palestrante.getSenha().equals(senhaLogado)) {
                        senhaValido = true;
                    }
                    if(usuarioValido && senhaValido) { isPalestrante = true; }
                }

                if(usuarioValido && senhaValido && !isPalestrante) {        //Usuário
                    postagemController.printarPostagens();
                }
                else if(usuarioValido && senhaValido && isPalestrante) {    //Palestrante
                    System.out.println("Selecione o módulo:" +
                                     "\n1 - Categoria" +
                                     "\n2 - Curso" +
                                     "\n3 - Endereço" +
                                     "\n4 - Palestrante" +
                                     "\n5 - Pessoa" +
                                     "\n6 - Postagem" +
                                     "\n7 - Telefone" +
                                     "\n8 - Usuario" );
                    int escolhaModulo = in.nextInt();

                    switch (escolhaModulo) {
                        case 1:
                            System.out.println("Selecione a operação:" +
                                    "\n1 - Criar" +
                                    "\n2 - Procurar" +
                                    "\n3 - Editar" +
                                    "\n4 - Deletar");
                            int operacao1 = in.nextInt();
                            switch (operacao1){
                                case 1:
                                    categoriaController.cadastrarCategoria();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id12 = in.nextInt();
                                    categoriaController.listarCategorias(id12);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id13 = in.nextInt();
                                    categoriaController.editarCategoria(id13);
                                    break;
                                case 4:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id14 = in.nextInt();
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
                            switch (operacao2){
                                case 1:
                                    cursoController.cadastrarCurso();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id22 = in.nextInt();
                                    cursoController.listarCursos(id22);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id23 = in.nextInt();
                                    cursoController.editarCurso(id23);
                                    break;
                                case 4:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id24 = in.nextInt();
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
                            switch (operacao3){
                                case 1:
                                    enderecoController.cadastrarEndereco();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id32 = in.nextInt();
                                    enderecoController.listarEndereco(id32);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id33 = in.nextInt();
                                    enderecoController.editarEndereco(id33);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    int id34 = in.nextInt();
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
                            switch (operacao4){
                                case 1:
                                    palestranteController.cadastrarPalestrante();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id42 = in.nextInt();
                                    palestranteController.listarPalestrantes(id42);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id43 = in.nextInt();
                                    palestranteController.editarPalestrante(id43);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    int id44 = in.nextInt();
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
                            switch (operacao5){
                                case 1:
                                    pessoaController.cadastrarPessoa();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id52 = in.nextInt();
                                    pessoaController.listarPessoas(id52);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id53 = in.nextInt();
                                    pessoaController.editarPessoa(id53);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    int id54 = in.nextInt();
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
                            switch (operacao6){
                                case 1:
                                    postagemController.cadastrarPostagem();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id62 = in.nextInt();
                                    postagemController.listarPostagens(id62);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id63 = in.nextInt();
                                    postagemController.editarPostagem(id63);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    int id64 = in.nextInt();
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
                            switch (operacao7){
                                case 1:
                                    telefoneController.cadastrarTelefone();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id72 = in.nextInt();
                                    telefoneController.listarTelefones(id72);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id73 = in.nextInt();
                                    telefoneController.editarTelefones(id73);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    int id74 = in.nextInt();
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
                            switch (operacao8){
                                case 1:
                                    usuarioController.cadastrarUsuario();
                                    break;
                                case 2:
                                    System.out.println("Qual id? (-1 para todos)");
                                    int id82 = in.nextInt();
                                    usuarioController.listarUsuarios(id82);
                                    break;
                                case 3:
                                    System.out.println("Qual id?");
                                    int id83 = in.nextInt();
                                    usuarioController.editarUsuario(id83);
                                    break;
                                case 4:
                                    System.out.println("Qual id?");
                                    int id84 = in.nextInt();
                                    usuarioController.deletarUsuario(id84);
                                    break;
                                default:
                                    System.err.println("Erro! Operação inválida...");
                            }
                            break;
                        default:
                            System.err.println("Erro! Módulo inválida...");
                    }
                }
                else {
                    System.err.println("Usuário e/ou Senha incorreto(s)");
                }
            }
            else if (ecadastrado == 2) {
                usuarioController.cadastrarUsuario();
            }
            else {
                System.err.println("Comando inválido!");
            }
        }
        System.out.println(",_.-*ª'*-._, Obrigado por utilizar o sistema ,_.-*'ª*-._,");
    }
}