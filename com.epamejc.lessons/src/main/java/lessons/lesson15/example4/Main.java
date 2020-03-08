package lessons.lesson15.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Author> authors1 = new ArrayList<>();
        authors1.add(new Author("Jw. Rowling"));
        authors1.add(new Author("Dambaldor"));
        authors1.add(new Author("Molfoy"));

        List<Author> authors2 = new ArrayList<>();
        authors2.add(new Author("Tolkien"));
        authors2.add(new Author("Gendalf"));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter", authors1));
        books.add(new Book("Lord of the rings", authors2));

        // authors > 2 => bookName = Harry Potter
        Stream<Book> stream = books.stream();

        List<String> collect = stream
                .filter(size -> size.getAuthorList().size() > 2)
                .map(Book::getBookName)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
