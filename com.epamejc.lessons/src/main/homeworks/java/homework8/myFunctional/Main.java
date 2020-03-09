package main.homeworks.java.homework8.myFunctional;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Blowup", 1966));
        movies.add(new Movie("The Tree of Life", 2010));
        movies.add(new Movie("Modern Times", 1936));
        movies.add(new Movie("There Will Be Blood", 2007));
        movies.add(new Movie("Blue Velvet", 1986));

        Movie movie1 = new Movie("The Avengers", 2012);
        Movie movie2 = new Movie("Modern Times", 1936);

        boolean isInTheList1 = movie1.f(() -> movies, (title, year) -> new Movie(title, year));
        boolean isInTheList2 = movie2.f(() -> movies, (title, year) -> new Movie(title, year));

        System.out.println(movie1 + " is on the list: " + isInTheList1);
        System.out.println(movie2 + " is on the list: " + isInTheList2);
    }
}
