package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Postagem {

    private int id;
    private String titulo;
    private String conteudo;
    private LocalDate data;
    private Categoria categoria;
    private ArrayList<Curso> cursos;
    private Palestrante autor;
    private Nivel nivel;
    private int idPalestrante;

    public Postagem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public Palestrante getAutor() {
        return autor;
    }

    public void setAutor(Palestrante autor) {
        this.autor = autor;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public int getIdPalestrante() {
        return this.idPalestrante;
    }

    public void setIdPalestrante(int idPalestrante) {
        this.idPalestrante = idPalestrante;
    }

}
