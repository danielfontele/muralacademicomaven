package controller;

import model.Categoria;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CategoriaController {

    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Categoria categoria;

    public void cadastrarCategoria() {

        categoria = new Categoria();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        categoria.setNome(in.next());

        categoria.setId(id_generator.getAndIncrement());
        System.out.println("O ID da categoria registrado é: " + categoria.getId());

        categorias.add(categoria);

        in.close();
    }

    public Categoria listarCategorias(long id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public void editarCategoria(long id) {
        int i = 0;
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                Categoria categoriaEditado = new Categoria();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o nome: ");
                categoriaEditado.setNome(in.next());

                categoriaEditado.setId(id);

                categorias.set(i, categoriaEditado);

                in.close();

                break;
            }
            i++;
        }
    }

    public void deletarCategoria(long id) {
        int i = 0;
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                categorias.remove(i);
            }
            i++;
        }
    }
}