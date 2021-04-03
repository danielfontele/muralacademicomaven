package controller;

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
        usuario.setUsuario(in.next());

        System.out.println("Digite a senha: ");
        usuario.setSenha(in.next());

        usuario.setId(id_generator.getAndIncrement());
        System.out.println("O ID da usuario registrado é: "+usuario.getId());

        usuarios.add(usuario);

        in.close();
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
                usuarioEditado.setUsuario(in.next());

                System.out.println("Digite a senha: ");
                usuarioEditado.setSenha(in.next());

                usuarioEditado.setId(id);

                usuarios.set(index, usuarioEditado);

                in.close();
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
}
