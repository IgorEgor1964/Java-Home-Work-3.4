package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Movie first = new Movie(1, 1, "Alien 1", "Fantastic", "http://movie.com");
    private Movie second = new Movie(2, 2, "Alien 2", "Fantastic", "http://movie.com");
    private Movie third = new Movie(3, 3, "Alien 3", "Fantastic", "http://movie.com");
    private Movie fourth = new Movie(4, 4, "Alien 4", "Fantastic", "http://movie.com");
    private Movie fifth = new Movie(5, 5, "Mad Max 1", "Fantastic", "http://movie.com");
    private Movie sixth = new Movie(6, 6, "Mad Max 2", "Fantastic", "http://movie.com");
    private Movie seventh = new Movie(7, 7, "Mad Max 3", "Fantastic", "http://movie.com");
    private Movie eighth = new Movie(8, 8, "Mad Max 4", "Fantastic", "http://movie.com");
    private Movie ninth = new Movie(9, 9, "Transporter 1", "Action", "http://movie.com");
    private Movie tenth = new Movie(10, 10, "Transporter 2", "Action", "http://movie.com");
    private Movie eleventh = new Movie(11, 11, "Transporter 3", "Action", "http://movie.com");

    @Test
    void shouldReturnLastFourIfMoviesToReturnSix() {
        AfishaManager manager = new AfishaManager(6);
        Movie[] expected = new Movie[]{third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);

        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldAdd() {
        Movie[] expected = new Movie[]{first};

        manager.add(first);

        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldReturnAllMoviesForDefault() {
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        assertArrayEquals(expected, manager.getMovies());
    }

    void shouldReturnDefaultIfLessZero() {
        manager = new AfishaManager(-4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldEmptyArrayMovies() {
        assertArrayEquals(new Movie[0], manager.getMovies());
    }

    @Test
    void shouldReturnMoviesWithMoviesToReturned() {
        AfishaManager manager = new AfishaManager(5);
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldReturnEmptyArrayIfAddMoviesAndMoviesToReturnZero() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        AfishaManager manager = new AfishaManager(0);
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, manager.getMovies());
    }
}