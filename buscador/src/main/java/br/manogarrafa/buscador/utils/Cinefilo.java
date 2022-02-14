package br.manogarrafa.buscador.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class Cinefilo {
    CinefiloObserver observer;

    public Cinefilo() {

    }

    public String buscar(String nome) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String json = "";

        Request request = new Request.Builder()
                .url("http://www.omdbapi.com/?apikey=d58efcda&t=" + nome.replace(" ", "+"))
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            json = Objects.requireNonNull(response.body()).string();
        }
        if (json.contains("Error")) {
            return null;
        }
        if (observer != null) {
            Movie movie = MovieParser.parse(json);

            observer.acheiOFilme(movie);
        }
        return json;
    }

    public void setObserver(CinefiloObserver cinefiloObserver) {
        observer = cinefiloObserver;
    }
}