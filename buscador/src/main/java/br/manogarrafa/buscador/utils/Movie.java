package br.manogarrafa.buscador.utils;

public class Movie {
    public String name;
    public String releaseDate;
    public String rated;
    public String runtime;
    public String genre;
    public String director;
    public String awards;
    public String country;
    public String language;
    public String rating;
    public String poster;

    public String toString() {
        return name + "\n" + rated + "\n" + releaseDate + "\n" + rated + "\n" + runtime + "\n" + genre + "\n" + director + "\n" + awards + "\n" + country + "\n" + language + "\n" + rating + "\n" + poster;
    }
}
