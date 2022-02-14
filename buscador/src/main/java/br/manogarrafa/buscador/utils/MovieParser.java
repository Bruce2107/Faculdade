package br.manogarrafa.buscador.utils;

import com.google.gson.*;

import java.net.URL;

public class MovieParser {
    public static Movie parse(String json) {
        Movie filme = new Movie();
        JsonElement elm = JsonParser.parseString(json);
        if(elm.isJsonObject()) {
            JsonObject obj = elm.getAsJsonObject();
            filme.name = obj.get("Title").getAsString();
            filme.director = obj.get("Director").getAsString();
            filme.releaseDate = obj.get("Released").getAsString();
            filme.rated = obj.get("Rated").getAsString();
            filme.runtime = obj.get("Runtime").getAsString();
            filme.awards = obj.get("Awards").getAsString();
            filme.country = obj.get("Country").getAsString();
            filme.language = obj.get("Language").getAsString();
            filme.genre = obj.get("Genre").getAsString();
            filme.rating = obj.get("imdbRating").getAsString();
            filme.poster = obj.get("Poster").getAsString();
        }

        return filme;
    }

    public static String getUrlPoster(String json) {
        String url = null;
        JsonElement elm = JsonParser.parseString(json);
        if(elm.isJsonObject()) {
            JsonObject obj = elm.getAsJsonObject();
            url = obj.get("Poster").getAsString();
        }
        return url;
    }
}
