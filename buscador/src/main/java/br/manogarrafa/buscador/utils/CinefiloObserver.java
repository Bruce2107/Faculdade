package br.manogarrafa.buscador.utils;

import java.io.IOException;

public interface CinefiloObserver {
    void acheiOFilme(Movie f) throws IOException;
}