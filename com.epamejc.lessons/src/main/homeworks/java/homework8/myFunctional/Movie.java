package main.homeworks.java.homework8.myFunctional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;


@Data
@AllArgsConstructor
public class Movie {

    private String title;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    public boolean f(MySupplier<List<Movie>> supplier, MyBiFunction<String, Integer, Movie> biFunction) {
        return supplier.get().contains(biFunction.apply(title, year));
    }
}
