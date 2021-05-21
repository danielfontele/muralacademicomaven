package controller;

import model.Usuario;
import model.dao.UsuarioDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioController {

    // private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    // private static AtomicInteger id_generator = new AtomicInteger(0);
    // private Usuario usuario;
    UsuarioDao usuarioDao;

    /*
     * //CRUD Antigo public void cadastrarUsuario(){
     * 
     * usuario = new Usuario(); Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o usuário: "); usuario.setUsuario(in.nextLine());
     * 
     * System.out.println("Digite a senha: "); usuario.setSenha(in.nextLine());
     * 
     * usuario.setId(id_generator.getAndIncrement());
     * System.out.println("O ID da usuario registrado é: "+usuario.getId());
     * 
     * usuarios.add(usuario); }
     * 
     * public Usuario listarUsuarios(int id){ for(Usuario usuario : usuarios) {
     * if(usuario.getId() == id){ return usuario; } } return null; }
     * 
     * public void editarUsuario(int id){ int index = 0; for(Usuario usuario :
     * usuarios){ if(usuario.getId() == id){ Usuario usuarioEditado = new Usuario();
     * Scanner in = new Scanner(System.in);
     * 
     * System.out.println("Digite o usuário: ");
     * usuarioEditado.setUsuario(in.nextLine());
     * 
     * System.out.println("Digite a senha: ");
     * usuarioEditado.setSenha(in.nextLine());
     * 
     * usuarioEditado.setId(id);
     * 
     * usuarios.set(index, usuarioEditado);
     * 
     * } index++; } }
     * 
     * public void deletarUsuario(int id){ int index = 0; for(Usuario usuario :
     * usuarios){ if(usuario.getId() == id){ usuarios.remove(index); } index++; } }
     */
    // Dao Crud =================================================================
    // Validações feitos em preencher();
    public boolean salvar() {
        usuarioDao = new UsuarioDao();
        Usuario usuario = preencher();
        boolean isSalvo;
        if (usuario.getIdPessoa() == 0) {
            isSalvo = usuarioDao.salvarSemPessoa(usuario);
        } else {
            isSalvo = usuarioDao.salvar(usuario);
        }
        return isSalvo;
    }

    public ArrayList<Usuario> listar() {
        usuarioDao = new UsuarioDao();
        ArrayList<Usuario> usuarios = usuarioDao.listar();
        return usuarios;
    }

    public boolean editar() {
        usuarioDao = new UsuarioDao();
        int id = informarId();
        Usuario usuario = preencher();
        usuario.setId(id);
        boolean isSalvo = usuarioDao.editar(usuario);
        return isSalvo;
    }

    public boolean deletar() {
        usuarioDao = new UsuarioDao();
        int id = informarId();
        boolean isSalvo = usuarioDao.deletar(id);
        return isSalvo;
    }

    public Usuario findByID() {
        usuarioDao = new UsuarioDao();
        int id = informarId();
        Usuario usuario = usuarioDao.findByID(id);
        return usuario;
    }

    public Usuario findByID(int id) {
        usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.findByID(id);
        return usuario;
    }

    // Metodos Extras ============================================================
    public static Usuario preencher() {
        Usuario usuario = new Usuario();
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        usuario.setUsuario(input.nextLine());

        System.out.println("Digite a senha: ");
        usuario.setSenha(input.nextLine());

        System.out.println("Digite o Id da pessosa vinculada (0 para nenhum)");
        usuario.setIdPessoa(input.nextInt());

        return usuario;
    }

    public int informarId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id: ");
        int id = input.nextInt();
        return id;
    }

    public Boolean logar(String user, String password) {
        Boolean usuarioValido = false;
        Boolean senhaValida = false;
        List<Usuario> usuarios = listar();
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(user)) {
                usuarioValido = true;
            }
            if (usuario.getSenha().equals(password)) {
                senhaValida = true;
            }
            if (usuarioValido && senhaValida) {
                return true;
            }

        }
        return false;
    }

    public void print(Usuario usuario) {
        System.out.println("\n !! Método criado afins de teste, não existiria em uma aplicação real !! " + "\nId: "
                + usuario.getId() + "\nUsuário: " + usuario.getUsuario() + "\nSenha: " + usuario.getSenha());
    }

    public void printAll() {
        List<Usuario> usuarios = listar();
        for (Usuario usuario : usuarios) {
            print(usuario);
        }
    }
}
