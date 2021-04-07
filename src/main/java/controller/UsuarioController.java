package controller;

import model.Palestrante;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioController {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Usuario usuario;

    public void cadastrarUsuario(){

        usuario = new Usuario();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o usuário: ");
        usuario.setUsuario(in.nextLine());

        System.out.println("Digite a senha: ");
        usuario.setSenha(in.nextLine());

        usuario.setId(id_generator.getAndIncrement());
        System.out.println("O ID da usuario registrado é: "+usuario.getId());

        usuarios.add(usuario);
    }

    public Usuario listarUsuarios(long id){
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    public void editarUsuario(long id){
        int index = 0;
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                Usuario usuarioEditado = new Usuario();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o usuário: ");
                usuarioEditado.setUsuario(in.nextLine());

                System.out.println("Digite a senha: ");
                usuarioEditado.setSenha(in.nextLine());

                usuarioEditado.setId(id);

                usuarios.set(index, usuarioEditado);

            }
            index++;
        }
    }

    public void deletarUsuario(long id){
        int index = 0;
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                usuarios.remove(index);
            }
            index++;
        }
    }

    public Boolean logar(String user, String password){
        Boolean usuarioValido = false;
        Boolean senhaValida = false;
        for (Usuario usuario : usuarios ){
            if (usuario.getUsuario().equals(user)){
                usuarioValido = true;
            }
            if (usuario.getSenha().equals(password)) {
                senhaValida = true;
            }
            if(usuarioValido && senhaValida) { return true; }

        }
        return false;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void print(Usuario usuario){
        System.out.println("\n !! Método criado afins de teste !! " +
                "\nId: " + usuario.getId()+
                "\nUsuário: "+ usuario.getUsuario() +
                "\nSenha: " + usuario.getSenha() );
    }

    public void printAll(){
        for (Usuario usuario : usuarios) {
            print(usuario);
        }
    }
}
