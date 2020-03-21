package main.java.homework.immutable;

public final class Book {
    final int pages;
    final String name;
    final String author;

    public Book(int pages, String name, String author) {
        this.pages = pages;
        this.name = name;
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
