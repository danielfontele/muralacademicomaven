package controller;

import model.Nivel;
import model.Postagem;
import model.dao.PostagemDao;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostagemController {

    // private ArrayList<Postagem> postagens = new ArrayList<Postagem>();
    // private static AtomicInteger id_generator = new AtomicInteger(0);
    // private Postagem postagem;
    PostagemDao postagemDao;

    /*
     * //CRUD Antigo public void cadastrarPostagem(){ postagem = new Postagem();
     * Scanner in = new Scanner(System.in); System.out.println("Digite o título: ");
     * postagem.setTitulo(in.nextLine()); System.out.println("Digite o conteúdo: ");
     * postagem.setConteudo(in.nextLine()); postagem.setData(LocalDate.now()); int i
     * = -1; while(i < 1 || i > 5){ System.out.println("Selecione o nível:" +
     * "\n1 - Graduação" + "\n2 - Pós-Graduação" + "\n3 - Mestrado" +
     * "\n4 - Doutorado" + "\n5 - Pós-Doutorado"); i = in.nextInt(); switch (i){
     * case 1: postagem.setNivel(Nivel.Graduacao); break; case 2:
     * postagem.setNivel(Nivel.PosGraduacao); break; case 3:
     * postagem.setNivel(Nivel.Mestrado); break; case 4:
     * postagem.setNivel(Nivel.Doutorado); break; case 5:
     * postagem.setNivel(Nivel.PosDoutorado); break; default:
     * System.err.println("Opção Inválida! Tente novamente..."); } }
     * 
     * 
     * postagem.setId(id_generator.getAndIncrement());
     * System.out.println("O ID da postagem registrado é: "+postagem.getId());
     * 
     * postagens.add(postagem);
     * 
     * 
     * }
     * 
     * public Postagem listarPostagens(int id){ for(Postagem postagem : postagens){
     * if(postagem.getId() == id) { return postagem; } } return null; }
     * 
     * public void printarPostagens(){ if(postagens.isEmpty()){
     * System.out.println("Nenhuma postagem! :("); } for(Postagem postagem :
     * postagens){ System.out.println( "-=- -=- -=- -=- -=-" +
     * "\nId:        "+postagem.getId() + "\nTítulo:    "+postagem.getTitulo() +
     * "\nConteúdo:  "+postagem.getConteudo() + "\nAutor:     "+postagem.getAutor()
     * + "\nCursos:    "+postagem.getCursos() + "\nData:      "+postagem.getData() +
     * "\nCategoria: "+postagem.getCategoria() + "\nNível:     "+postagem.getNivel()
     * );
     * 
     * } System.out.println("-=- -=- -=- -=- -=-"); }
     * 
     * public void editarPostagem(int id){ int index = 0; for(Postagem postagem :
     * postagens){ if(postagem.getId() == id) { Postagem postagemEditado = new
     * Postagem(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o título: ");
     * postagemEditado.setTitulo(in.nextLine());
     * 
     * System.out.println("Digite o conteúdo: ");
     * postagemEditado.setConteudo(in.nextLine());
     * 
     * postagemEditado.setData(postagem.getData());
     * 
     * int i = -1; while(i < 1 || i > 5){ System.out.println("Selecione o nível:" +
     * "\n1 - Graduação" + "\n2 - Pós-Graduação" + "\n3 - Mestrado" +
     * "\n4 - Doutorado" + "\n5 - Pós-Doutorado"); i = in.nextInt();
     * 
     * switch (i){ case 1: postagemEditado.setNivel(Nivel.Graduacao); break; case 2:
     * postagemEditado.setNivel(Nivel.PosGraduacao); break; case 3:
     * postagemEditado.setNivel(Nivel.Mestrado); break; case 4:
     * postagemEditado.setNivel(Nivel.Doutorado); break; case 5:
     * postagemEditado.setNivel(Nivel.PosDoutorado); break; default:
     * System.err.println("Opção Inválida! Tente novamente..."); } }
     * 
     * 
     * postagemEditado.setId(id);
     * 
     * postagens.set(index, postagemEditado);
     * 
     * break; } index++; }
     * 
     * }
     * 
     * public void deletarPostagem(int id){ int i = 0; for(Postagem postagem :
     * postagens){ if(postagem.getId() == id) { postagens.remove(i); break; } i++; }
     * }
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        postagemDao = new PostagemDao();
        Postagem postagem = preencher();
        Boolean isSalvo;
        if (postagem.getIdPalestrante() == 0) {
            isSalvo = postagemDao.salvarSemPalestrante(postagem);
        } else {
            isSalvo = postagemDao.salvar(postagem);
        }
        return isSalvo;
    }

    public ArrayList<Postagem> listar() {
        postagemDao = new PostagemDao();
        ArrayList<Postagem> postagens = postagemDao.listar();
        return postagens;
    }

    public boolean editar() {
        postagemDao = new PostagemDao();
        int id = informarId();
        Postagem postagem = preencher();
        postagem.setId(id);
        boolean isSalvo = postagemDao.editar(postagem);
        return isSalvo;
    }

    public boolean deletar() {
        postagemDao = new PostagemDao();
        int id = informarId();
        boolean isSalvo = postagemDao.deletar(id);
        return isSalvo;
    }

    public Postagem findByID() {
        postagemDao = new PostagemDao();
        int id = informarId();
        Postagem postagem = postagemDao.findByID(id);
        return postagem;
    }

    public Postagem findByID(int id) {
        postagemDao = new PostagemDao();
        Postagem postagem = postagemDao.findByID(id);
        return postagem;
    }

    // Metodos Extras ============================================================
    public Postagem preencher() {
        Postagem postagem = new Postagem();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o título: ");
        postagem.setTitulo(in.nextLine());

        System.out.println("Digite o conteúdo: ");
        postagem.setConteudo(in.nextLine());

        postagem.setData(LocalDate.now());

        int i = -1;
        while (i < 1 || i > 5) {
            System.out.println("Selecione o nível:" + "\n1 - Graduação" + "\n2 - Pós-Graduação" + "\n3 - Mestrado"
                    + "\n4 - Doutorado" + "\n5 - Pós-Doutorado");
            i = in.nextInt();
            switch (i) {
                case 1:
                    postagem.setNivel(Nivel.Graduacao);
                    break;
                case 2:
                    postagem.setNivel(Nivel.PosGraduacao);
                    break;
                case 3:
                    postagem.setNivel(Nivel.Mestrado);
                    break;
                case 4:
                    postagem.setNivel(Nivel.Doutorado);
                    break;
                case 5:
                    postagem.setNivel(Nivel.PosDoutorado);
                    break;
                default:
                    System.err.println("Opção Inválida! Tente novamente...");
            }
        }

        System.out.println("Digite o Id do palestrante vinculado (0 para nenhum)");
        int idPalestrante = in.nextInt();
        if (idPalestrante != 0) {
            postagem.setIdPalestrante(idPalestrante);
        }
        return postagem;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public void print(Postagem postagem) {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("\nId: " + postagem.getId() + "\nTítulo: " + postagem.getTitulo() + "\nConteúdo: "
                + postagem.getConteudo() + "\nData: " + formatDate.format(postagem.getData()) + "\nNível: "
                + postagem.getNivel());
    }

    public void printAll() {
        List<Postagem> postagems = listar();
        for (Postagem postagem : postagems) {
            print(postagem);
        }
    }

    public void printarPostagens() {
        List<Postagem> postagens = listar();
        if (postagens.isEmpty()) {
            System.out.println("Nenhuma postagem! :(");
        }
        for (Postagem postagem : postagens) {
            System.out.println(
                    "-=- -=- -=- -=- -=-" + "\nId:        " + postagem.getId() + "\nTítulo:    " + postagem.getTitulo()
                            + "\nConteúdo:  " + postagem.getConteudo() + "\nAutor:     " + postagem.getAutor()
                            + "\nCursos:    " + postagem.getCursos() + "\nData:      " + postagem.getData()
                            + "\nCategoria: " + postagem.getCategoria() + "\nNível:     " + postagem.getNivel());
        }
    }

}
