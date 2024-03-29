package org.dados;

import java.util.LinkedList;
import java.util.List;

public class Playlist {

    private int id;
    private String nome;
    private List<Musica> musicas = new LinkedList<>();


    public Playlist() {

    }

    public Playlist(int id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public String toString() {
        return "Playlist [id=" + id + ", nome=" + nome + ", musicas=" + musicas + "]";
    }


}
