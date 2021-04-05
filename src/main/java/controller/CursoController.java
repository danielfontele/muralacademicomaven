package controller;

import model.Curso;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CursoController {

    private ArrayList<Curso> cursos = new ArrayList<Curso>();
    private static AtomicInteger id_generator = new AtomicInteger(0);
    private Curso curso;

    public void cadastrarCurso(){

        curso = new Curso();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        curso.setNome(in.nextLine());

        curso.setId(id_generator.getAndIncrement());
        System.out.println("O ID da curso registrado é: "+curso.getId());

        cursos.add(curso);

        in.close();
    }

    public Curso listarCursos(long id){
        for(Curso curso : cursos){
            if(curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

    public void editarCurso(long id){
        int index = 0;
        for(Curso curso : cursos) {
            if(curso.getId() == id){
                Curso cursoEditado = new Curso();
                Scanner in = new Scanner(System.in);

                System.out.println("Digite o nome: ");
                cursoEditado.setNome(in.nextLine());

                cursoEditado.setId(id);

                cursos.set(index, cursoEditado);

                in.close();
            }
            index++;
        }
    }

    public void deletarCurso(long id){
        int index = 0;
        for(Curso curso : cursos) {
            if(curso.getId() == id){
                cursos.remove(index);
            }
            index++;
        }
    }
}
