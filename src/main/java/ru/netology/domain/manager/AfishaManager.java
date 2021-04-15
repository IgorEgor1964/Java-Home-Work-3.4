package ru.netology.domain.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class AfishaManager {
    private Movie[] movies = new Movie[0];
    private int moviesToReturn;
    private int moviesToReturnDefault = 10;

    public AfishaManager(int moviesToReturn) {

        this.moviesToReturn = moviesToReturn;
    }

    public void add(Movie movieItem) {

        Movie[] tmp = new Movie[movies.length + 1];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        tmp[tmp.length - 1] = movieItem;

        movies = tmp;
    }

    public Movie[] getMovies() {
        int arrayLength;

        if (moviesToReturn <= 0)
            moviesToReturn = moviesToReturnDefault;
        arrayLength = moviesToReturn;

        if (moviesToReturn > movies.length) {
            arrayLength = movies.length;
        }
        Movie[] result = new Movie[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
